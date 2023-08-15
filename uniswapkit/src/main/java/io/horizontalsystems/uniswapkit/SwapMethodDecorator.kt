package io.definenulls.uniswapkit

import io.definenulls.ethereumkit.contracts.ContractMethod
import io.definenulls.ethereumkit.core.IMethodDecorator
import io.definenulls.uniswapkit.contract.SwapContractMethodFactories

class SwapMethodDecorator(private val contractMethodFactories: SwapContractMethodFactories) : IMethodDecorator {

    override fun contractMethod(input: ByteArray): ContractMethod? =
        contractMethodFactories.createMethodFromInput(input)

}
