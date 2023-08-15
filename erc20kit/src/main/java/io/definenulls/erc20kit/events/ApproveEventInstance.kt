package io.definenulls.erc20kit.events

import io.definenulls.ethereumkit.contracts.ContractEventInstance
import io.definenulls.ethereumkit.models.Address
import java.math.BigInteger

class ApproveEventInstance(
    contractAddress: Address,
    val owner: Address,
    val spender: Address,
    val value: BigInteger
) : ContractEventInstance(contractAddress)
