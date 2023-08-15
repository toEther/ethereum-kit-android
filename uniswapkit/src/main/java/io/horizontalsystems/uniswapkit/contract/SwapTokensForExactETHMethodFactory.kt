package io.definenulls.uniswapkit.contract

import io.definenulls.ethereumkit.contracts.ContractMethod
import io.definenulls.ethereumkit.contracts.ContractMethodFactory
import io.definenulls.ethereumkit.contracts.ContractMethodHelper
import io.definenulls.ethereumkit.models.Address
import java.math.BigInteger

object SwapTokensForExactETHMethodFactory : ContractMethodFactory {
    override val methodId = ContractMethodHelper.getMethodId(SwapTokensForExactETHMethod.methodSignature)

    override fun createMethod(inputArguments: ByteArray): ContractMethod {
        val parsedArguments = ContractMethodHelper.decodeABI(inputArguments, listOf(BigInteger::class, BigInteger::class, List::class, Address::class, BigInteger::class))
        val amountOut = parsedArguments[0] as BigInteger
        val amountInMax = parsedArguments[1] as BigInteger
        val path = parsedArguments[2] as List<Address>
        val to = parsedArguments[3] as Address
        val deadline = parsedArguments[4] as BigInteger
        return SwapTokensForExactETHMethod(amountOut, amountInMax, path, to, deadline)
    }

}
