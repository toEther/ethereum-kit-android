package io.definenulls.erc20kit.contract

import io.definenulls.ethereumkit.contracts.ContractMethod
import io.definenulls.ethereumkit.models.Address

class BalanceOfMethod(val owner: Address) : ContractMethod() {

    override val methodSignature = "balanceOf(address)"
    override fun getArguments() = listOf(owner)

}
