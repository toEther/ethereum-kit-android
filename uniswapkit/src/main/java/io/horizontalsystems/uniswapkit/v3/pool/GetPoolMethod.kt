package io.definenulls.uniswapkit.v3.pool

import io.definenulls.ethereumkit.contracts.ContractMethod
import io.definenulls.ethereumkit.models.Address
import java.math.BigInteger

class GetPoolMethod(
    private val tokenA: Address,
    private val tokenB: Address,
    private val fee: BigInteger
) : ContractMethod() {

    override val methodSignature = "getPool(address,address,uint24)"
    override fun getArguments() = listOf(tokenA, tokenB, fee)

}
