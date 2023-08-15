package io.definenulls.nftkit.events

import io.definenulls.ethereumkit.contracts.ContractEvent
import io.definenulls.ethereumkit.contracts.ContractEventInstance
import io.definenulls.ethereumkit.models.Address
import io.definenulls.nftkit.models.TokenInfo
import java.math.BigInteger

class Eip1155TransferEventInstance(
    contractAddress: Address,
    val from: Address,
    val to: Address,
    val tokenId: BigInteger,
    val value: BigInteger,
    val tokenInfo: TokenInfo? = null
): ContractEventInstance(contractAddress) {

    override fun tags(userAddress: Address): List<String> {
        return buildList {
            add(contractAddress.hex)

            if (from == userAddress) {
                add("${contractAddress.hex}_outgoing")
                add("outgoing")
            }

            if (to == userAddress) {
                add("${contractAddress.hex}_incoming")
                add("incoming")
            }
        }
    }

    companion object {
        val transferSingleSignature = ContractEvent(
            "TransferSingle",
            listOf(
                ContractEvent.Argument.Address,
                ContractEvent.Argument.Address,
                ContractEvent.Argument.Address,
                ContractEvent.Argument.Uint256,
                ContractEvent.Argument.Uint256,
            )
        ).signature
        val transferBatchSignature = ContractEvent(
            "TransferBatch",
            listOf(
                ContractEvent.Argument.Address,
                ContractEvent.Argument.Address,
                ContractEvent.Argument.Address,
                ContractEvent.Argument.Uint256Array,
                ContractEvent.Argument.Uint256Array,
            )
        ).signature

    }


}
