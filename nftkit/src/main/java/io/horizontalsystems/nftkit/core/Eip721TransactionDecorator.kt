package io.definenulls.nftkit.core

import io.definenulls.ethereumkit.contracts.ContractEventInstance
import io.definenulls.ethereumkit.contracts.ContractMethod
import io.definenulls.ethereumkit.core.ITransactionDecorator
import io.definenulls.ethereumkit.decorations.TransactionDecoration
import io.definenulls.ethereumkit.models.Address
import io.definenulls.ethereumkit.models.InternalTransaction
import io.definenulls.nftkit.contracts.Eip721SafeTransferFromMethod
import io.definenulls.nftkit.decorations.OutgoingEip721Decoration
import io.definenulls.nftkit.events.Eip721TransferEventInstance
import java.math.BigInteger

class Eip721TransactionDecorator(
    private val userAddress: Address
) : ITransactionDecorator {

    override fun decoration(
        from: Address?,
        to: Address?,
        value: BigInteger?,
        contractMethod: ContractMethod?,
        internalTransactions: List<InternalTransaction>,
        eventInstances: List<ContractEventInstance>
    ): TransactionDecoration? {
        if (from == null || to == null || value == null || contractMethod == null) return null

        return when {
            contractMethod is Eip721SafeTransferFromMethod && from == userAddress -> {
                OutgoingEip721Decoration(
                    contractAddress = to,
                    to = contractMethod.to,
                    tokenId = contractMethod.tokenId,
                    sentToSelf = contractMethod.to == userAddress,
                    tokenInfo = eventInstances.mapNotNull { it as? Eip721TransferEventInstance }.firstOrNull { it.contractAddress == to }?.tokenInfo
                )
            }
            else -> null
        }
    }
}