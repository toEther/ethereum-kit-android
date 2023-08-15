package io.definenulls.oneinchkit.contracts.v5

import io.definenulls.ethereumkit.contracts.ContractMethod
import io.definenulls.ethereumkit.models.Address
import java.math.BigInteger

class SwapMethodV5(
    val caller: Address,
    val swapDescription: SwapDescription,
    val permit: ByteArray,
    val data: ByteArray
) : ContractMethod() {

    override val methodSignature = Companion.methodSignature

    override fun getArguments() = listOf(caller, swapDescription, data)

    data class SwapDescription(
        val srcToken: Address,
        val dstToken: Address,
        val srcReceiver: Address,
        val dstReceiver: Address,
        val amount: BigInteger,
        val minReturnAmount: BigInteger,
        val flags: BigInteger
    )

    companion object {
        val methodSignature = "swap(address,(address,address,address,address,uint256,uint256,uint256),bytes,bytes)"
    }

}
