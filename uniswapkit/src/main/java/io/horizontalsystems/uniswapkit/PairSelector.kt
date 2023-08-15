package io.definenulls.uniswapkit

import io.definenulls.uniswapkit.models.Token

class PairSelector(
        private val tokenFactory: TokenFactory
) {
    fun tokenPairs(tokenA: Token, tokenB: Token): List<Pair<Token, Token>> =
            if (tokenA.isEther || tokenB.isEther) {
                listOf(Pair(tokenA, tokenB))
            } else {
                val etherToken = tokenFactory.etherToken()

                listOf(Pair(tokenA, tokenB), Pair(tokenA, etherToken), Pair(tokenB, etherToken))
            }
}
