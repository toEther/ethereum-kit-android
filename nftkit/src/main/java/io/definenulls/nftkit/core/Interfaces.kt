package io.definenulls.nftkit.core

import io.definenulls.nftkit.models.Nft
import io.definenulls.nftkit.models.NftType

interface ITransactionSyncerListener {
    fun didSync(nfts: List<Nft>, type: NftType)
}

interface IBalanceSyncManagerListener {
    fun didFinishSyncBalances()
}