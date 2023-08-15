package io.definenulls.ethereumkit.decorations

import io.definenulls.ethereumkit.contracts.ContractEventInstance
import io.definenulls.ethereumkit.contracts.ContractMethod
import io.definenulls.ethereumkit.contracts.EmptyMethod
import io.definenulls.ethereumkit.core.ITransactionDecorator
import io.definenulls.ethereumkit.models.Address
import io.definenulls.ethereumkit.models.InternalTransaction
import java.math.BigInteger

class EthereumDecorator(private val address: Address) : ITransactionDecorator {

    override fun decoration(from: Address?, to: Address?, value: BigInteger?, contractMethod: ContractMethod?, internalTransactions: List<InternalTransaction>, eventInstances: List<ContractEventInstance>): TransactionDecoration? {
        if (from == null || value == null) return null
        if (to == null) return ContractCreationDecoration()

        if (contractMethod != null && contractMethod is EmptyMethod) {
            if (from == address) {
                return OutgoingDecoration(to, value, to == address)
            }

            if (to == address) {
                return IncomingDecoration(from, value)
            }
        }

        return null
    }

}
