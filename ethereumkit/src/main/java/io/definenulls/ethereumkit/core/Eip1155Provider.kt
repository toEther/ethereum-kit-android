package io.definenulls.ethereumkit.core

import io.definenulls.ethereumkit.api.core.IRpcApiProvider
import io.definenulls.ethereumkit.api.core.NodeApiProvider
import io.definenulls.ethereumkit.api.core.RpcBlockchain
import io.definenulls.ethereumkit.contracts.ContractMethod
import io.definenulls.ethereumkit.models.Address
import io.definenulls.ethereumkit.models.DefaultBlockParameter
import io.definenulls.ethereumkit.models.RpcSource
import io.definenulls.ethereumkit.spv.core.toBigInteger
import io.reactivex.Single
import java.math.BigInteger

class Eip1155Provider(
    private val provider: IRpcApiProvider
) {

    class BalanceOfMethod(val owner: Address, val tokenId: BigInteger) : ContractMethod() {
        override val methodSignature = "balanceOf(address,uint256)"
        override fun getArguments() = listOf(owner, tokenId)
    }

    fun getTokenBalance(contractAddress: Address, tokenId: BigInteger, address: Address): Single<BigInteger> {
        val callRpc = RpcBlockchain.callRpc(contractAddress, BalanceOfMethod(address, tokenId).encodedABI(), DefaultBlockParameter.Latest)

        return provider
            .single(callRpc)
            .map { it.sliceArray(IntRange(0, 31)).toBigInteger() }
    }

    companion object {

        fun instance(rpcSource: RpcSource.Http): Eip1155Provider {
            val apiProvider = NodeApiProvider(rpcSource.urls, EthereumKit.gson, rpcSource.auth)

            return Eip1155Provider(apiProvider)
        }

    }

}
