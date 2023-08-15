package io.definenulls.nftkit.contracts

import io.definenulls.ethereumkit.contracts.ContractMethodFactories

object Eip721ContractMethodFactories : ContractMethodFactories() {
    init {
        registerMethodFactories(listOf(Eip721SafeTransferFromMethodFactory()))
    }
}