package io.definenulls.oneinchkit.decorations

import io.definenulls.ethereumkit.contracts.Bytes32Array
import io.definenulls.ethereumkit.models.Address
import io.definenulls.ethereumkit.models.TransactionTag
import java.math.BigInteger

class OneInchUnoswapDecoration(
    override val contractAddress: Address,
    val tokenIn: Token,
    val tokenOut: Token?,
    val amountIn: BigInteger,
    val amountOut: Amount,
    val params: Bytes32Array
) : OneInchDecoration(contractAddress) {

    override fun tags(): List<String> {
        val tags = super.tags().toMutableList()

        listOf(contractAddress.hex, TransactionTag.SWAP)

        tags.addAll(getTags(tokenIn, TransactionTag.OUTGOING))

        if (tokenOut != null) {
            tags.addAll(getTags(tokenOut, TransactionTag.INCOMING))
        }

        return tags
    }

}
