package io.definenulls.nftkit.core

import io.definenulls.ethereumkit.core.EthereumKit
import io.definenulls.ethereumkit.models.Address
import io.definenulls.ethereumkit.spv.core.toInt
import io.definenulls.nftkit.contracts.Eip1155BalanceOfMethod
import io.definenulls.nftkit.contracts.Eip721OwnerOfMethod
import kotlinx.coroutines.rx2.await
import java.math.BigInteger

class DataProvider(
    private val evmKit: EthereumKit
) {
    suspend fun getEip721Owner(contractAddress: Address, tokenId: BigInteger): Address {
        val address = evmKit.call(contractAddress, Eip721OwnerOfMethod(tokenId).encodedABI()).await()
        return Address(address)
    }

    suspend fun getEip1155Balance(contractAddress: Address, owner: Address, tokenId: BigInteger): Int {
        val balance = evmKit.call(contractAddress, Eip1155BalanceOfMethod(owner, tokenId).encodedABI()).await()

        return try {
            balance.copyOfRange(0, 32).toInt()
        } catch (error: Throwable) {
            throw ContractCallError.InvalidBalanceData
        }
    }

    sealed class ContractCallError : Throwable() {
        object InvalidBalanceData : ContractCallError()
    }
}