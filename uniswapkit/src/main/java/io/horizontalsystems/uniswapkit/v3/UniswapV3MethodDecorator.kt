package io.definenulls.uniswapkit.v3

import io.definenulls.ethereumkit.contracts.ContractMethod
import io.definenulls.ethereumkit.core.IMethodDecorator
import io.definenulls.uniswapkit.v3.contract.UniswapV3ContractMethodFactories

class UniswapV3MethodDecorator(private val contractMethodFactories: UniswapV3ContractMethodFactories) :
    IMethodDecorator {

    override fun contractMethod(input: ByteArray): ContractMethod? =
        contractMethodFactories.createMethodFromInput(input)

}
