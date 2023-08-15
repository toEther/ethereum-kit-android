package io.definenulls.oneinchkit.contracts.v4

import io.definenulls.ethereumkit.contracts.ContractMethod
import io.definenulls.ethereumkit.contracts.ContractMethodHelper
import io.definenulls.ethereumkit.contracts.ContractMethodsFactory

class UnparsedSwapMethodsFactoryV4 : ContractMethodsFactory {
    override val methodIds: List<ByteArray> = listOf(
            ContractMethodHelper.getMethodId("fillOrderRFQ((uint256,address,address,address,address,uint256,uint256),bytes,uint256,uint256)"),
            ContractMethodHelper.getMethodId("fillOrderRFQTo((uint256,address,address,address,address,uint256,uint256),bytes,uint256,uint256,address)"),
            ContractMethodHelper.getMethodId("fillOrderRFQToWithPermit((uint256,address,address,address,address,uint256,uint256),bytes,uint256,uint256,address,bytes)"),
            ContractMethodHelper.getMethodId("clipperSwap(address,address,uint256,uint256)"),
            ContractMethodHelper.getMethodId("clipperSwapTo(address,address,address,uint256,uint256)"),
            ContractMethodHelper.getMethodId("clipperSwapToWithPermit(address,address,address,uint256,uint256,bytes)"),
            ContractMethodHelper.getMethodId("uniswapV3Swap(uint256,uint256,uint256[])"),
            ContractMethodHelper.getMethodId("uniswapV3SwapTo(address,uint256,uint256,uint256[])"),
            ContractMethodHelper.getMethodId("uniswapV3SwapToWithPermit(address,address,uint256,uint256,uint256[],bytes)"),
            ContractMethodHelper.getMethodId("unoswapWithPermit(address,uint256,uint256,bytes32[],bytes)")
    )

    override fun createMethod(inputArguments: ByteArray): ContractMethod {
        return UnparsedSwapMethodV4()
    }
}
