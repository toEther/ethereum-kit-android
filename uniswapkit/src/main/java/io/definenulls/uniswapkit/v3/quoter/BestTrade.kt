package io.definenulls.uniswapkit.v3.quoter

import io.definenulls.uniswapkit.models.*
import io.definenulls.uniswapkit.v3.SwapPath
import java.math.BigInteger

data class BestTrade(
    val tradeType: TradeType,
    val swapPath: SwapPath,
    val amountIn: BigInteger,
    val amountOut: BigInteger,
    val tokenIn: Token,
    val tokenOut: Token
) {
    val singleSwap = swapPath.items.size == 1
    val singleSwapFee get() = swapPath.items.single().fee
}
