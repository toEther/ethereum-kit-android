package io.definenulls.erc20kit.contract

import io.definenulls.ethereumkit.contracts.ContractMethod

class SymbolMethod: ContractMethod() {
    override var methodSignature = "symbol()"
    override fun getArguments() = listOf<Any>()
}
