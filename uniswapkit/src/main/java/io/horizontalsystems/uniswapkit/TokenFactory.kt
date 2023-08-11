package io.horizontalsystems.uniswapkit

import io.horizontalsystems.ethereumkit.models.Address
import io.horizontalsystems.ethereumkit.models.Chain
import io.horizontalsystems.uniswapkit.models.Token

class TokenFactory(chain: Chain) {
    val wethAddress = getWethAddress(chain)

    sealed class UnsupportedChainError : Throwable() {
        object NoWethAddress : UnsupportedChainError()
    }

    fun etherToken(): Token {
        return Token.Ether(wethAddress)
    }

    fun token(contractAddress: Address, decimals: Int): Token {
        return Token.Erc20(contractAddress, decimals)
    }

    companion object {
        private fun getWethAddress(chain: Chain): Address {
            val wethAddressHex = when (chain) {
                Chain.Ethereum -> "0xC02aaA39b223FE8D0A0e5C4F27eAD9083C756Cc2"
                Chain.Optimism -> "0x4200000000000000000000000000000000000006"
                Chain.BinanceSmartChain -> "0xbb4cdb9cbd36b01bd1cbaebf2de08d9173bc095c"
                Chain.Komerco -> "0x209171E8260b8F84bA486644Ce166c5034c3AAF5"
                Chain.Avalanche -> "0xB31f66AA3C1e785363F0875A1B74E27b85FD66c7"
                Chain.EthereumGoerli -> "0xB4FBF271143F4FBf7B91A5ded31805e42b2208d6"
                Chain.ArbitrumOne -> "0x82aF49447D8a07e3bd95BD0d56f35241523fBab1"
                 else -> throw UnsupportedChainError.NoWethAddress
            }
            return Address(wethAddressHex)
        }
    }

}
