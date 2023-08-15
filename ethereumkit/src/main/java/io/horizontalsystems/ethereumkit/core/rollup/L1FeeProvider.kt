package io.definenulls.ethereumkit.core.rollup

import io.definenulls.ethereumkit.contracts.ContractMethod
import io.definenulls.ethereumkit.core.EthereumKit
import io.definenulls.ethereumkit.core.TransactionBuilder
import io.definenulls.ethereumkit.models.Address
import io.definenulls.ethereumkit.models.GasPrice
import io.definenulls.ethereumkit.models.RawTransaction
import io.definenulls.ethereumkit.spv.core.toBigInteger
import io.reactivex.Single
import java.math.BigInteger

class L1FeeProvider(
        private val evmKit: EthereumKit,
        private val contractAddress: Address
) {

    class L1FeeMethod(val transaction: ByteArray) : ContractMethod() {
        override val methodSignature = "getL1Fee(bytes)"
        override fun getArguments() = listOf(transaction)
    }

    fun getL1Fee(gasPrice: GasPrice, gasLimit: Long, to: Address, value: BigInteger, data: ByteArray): Single<BigInteger> {
        val rawTransaction = RawTransaction(gasPrice, gasLimit, to, value, 1, data)
        val encoded = TransactionBuilder.encode(rawTransaction, null, evmKit.chain.id)
        val feeMethodABI = L1FeeMethod(encoded).encodedABI()

        return evmKit.call(contractAddress, feeMethodABI)
                .map { it.sliceArray(IntRange(0, 31)).toBigInteger() }
    }

}
