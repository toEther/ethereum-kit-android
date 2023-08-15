package io.definenulls.ethereumkit.contracts

import io.definenulls.ethereumkit.models.Address

open class ContractEventInstance(val contractAddress: Address) {

    open fun tags(userAddress: Address): List<String> = listOf()

}
