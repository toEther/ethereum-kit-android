package io.definenulls.erc20kit.decorations

import io.definenulls.ethereumkit.contracts.ContractEvent
import io.definenulls.ethereumkit.decorations.TransactionDecoration
import io.definenulls.ethereumkit.models.Address
import io.definenulls.ethereumkit.models.TransactionTag
import java.math.BigInteger

class ApproveEip20Decoration(
    val contractAddress: Address,
    val spender: Address,
    val value: BigInteger
) : TransactionDecoration() {

    override fun tags(): List<String> =
        listOf(contractAddress.hex, TransactionTag.EIP20_APPROVE)

    companion object {
        val signature = ContractEvent(
            "Approval",
            listOf(
                ContractEvent.Argument.Address,
                ContractEvent.Argument.Address,
                ContractEvent.Argument.Uint256
            )
        ).signature
    }
}
