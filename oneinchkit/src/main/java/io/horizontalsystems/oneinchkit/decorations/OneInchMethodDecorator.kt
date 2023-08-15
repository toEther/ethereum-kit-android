package io.definenulls.oneinchkit.decorations

import io.definenulls.ethereumkit.contracts.ContractMethod
import io.definenulls.ethereumkit.core.IMethodDecorator
import io.definenulls.oneinchkit.contracts.OneInchContractMethodFactories

class OneInchMethodDecorator(private val contractMethodFactories: OneInchContractMethodFactories) : IMethodDecorator {

    override fun contractMethod(input: ByteArray): ContractMethod? =
        contractMethodFactories.createMethodFromInput(input)

}
