package io.definenulls.erc20kit.contract

import io.definenulls.ethereumkit.contracts.ContractMethodFactory
import io.definenulls.ethereumkit.contracts.ContractMethodHelper
import io.definenulls.ethereumkit.models.Address
import io.definenulls.ethereumkit.spv.core.toBigInteger

object ApproveMethodFactory : ContractMethodFactory {

    override val methodId = ContractMethodHelper.getMethodId(ApproveMethod.methodSignature)

    override fun createMethod(inputArguments: ByteArray): ApproveMethod {
        val address = Address(inputArguments.copyOfRange(12, 32))
        val value = inputArguments.copyOfRange(32, 64).toBigInteger()

        return ApproveMethod(address, value)
    }

}
