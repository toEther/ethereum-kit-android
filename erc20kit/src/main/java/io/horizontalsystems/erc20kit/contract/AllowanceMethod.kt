package io.definenulls.erc20kit.contract

import io.definenulls.ethereumkit.contracts.ContractMethod
import io.definenulls.ethereumkit.models.Address

class AllowanceMethod(val owner: Address, val spender: Address) : ContractMethod() {

    override val methodSignature = "allowance(address,address)"
    override fun getArguments() = listOf(owner, spender)

}
