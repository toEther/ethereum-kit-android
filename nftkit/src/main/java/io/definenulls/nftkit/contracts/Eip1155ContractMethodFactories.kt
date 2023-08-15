package io.definenulls.nftkit.contracts

import io.definenulls.ethereumkit.contracts.ContractMethodFactories

object Eip1155ContractMethodFactories : ContractMethodFactories() {
    init {
        registerMethodFactories(listOf(Eip1155SafeTransferFromMethodFactory()))
    }
}