package io.definenulls.uniswapkit.contract

import io.definenulls.ethereumkit.contracts.ContractMethod

class GetReservesMethod : ContractMethod() {

    override val methodSignature = "getReserves()"
    override fun getArguments() = listOf<Any>()

}
