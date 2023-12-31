package io.definenulls.nftkit.core

import android.util.Log
import io.definenulls.ethereumkit.api.jsonrpc.JsonRpc
import io.definenulls.ethereumkit.models.Address
import io.definenulls.nftkit.models.Nft
import io.definenulls.nftkit.models.NftType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext
import java.util.concurrent.atomic.AtomicBoolean

class BalanceSyncManager(
    private val address: Address,
    private val storage: Storage,
    private val dataProvider: DataProvider
) {
    private var syncing = AtomicBoolean(false)
    private var syncRequested = AtomicBoolean(false)

    var listener: IBalanceSyncManagerListener? = null

    private suspend fun finishSync() {
        syncing.set(false)

        if (syncRequested.getAndSet(false)) {
            sync()
        }
    }

    suspend fun sync() = withContext(Dispatchers.IO) {
        if (syncing.getAndSet(true)) {
            syncRequested.set(true)
            return@withContext
        }

        val nftBalances = storage.nonSyncedNftBalances()
        if (nftBalances.isEmpty()) {
            finishSync()
            Log.e("nfts", "finishSync NON-SYNCED NFT BALANCES")
        }

        Log.e("nfts", "NON-SYNCED NFT BALANCES ${nftBalances.size}")

        val balanceSyncTasks = nftBalances.map { nftBalance ->
            val nft = nftBalance.nft
            Log.e("nfts", "Start to sync balance for ${nft.tokenName} - ${nft.contractAddress} - ${nft.tokenId}")
            async {
                try {
                    storage.setSynced(nft, getBalance(nft))
                } catch (error: Throwable) {
                    Log.e("nfts", "Failed to sync balance for ${nft.tokenName} - ${nft.contractAddress} - ${nft.tokenId}")
                }
            }
        }

        Log.e("nfts", "A-NFT BALANCES finishSync")

        balanceSyncTasks.awaitAll()

        listener?.didFinishSyncBalances()

        finishSync()
        Log.e("nfts", "NFT BALANCES finishSync")
    }

    private suspend fun getBalance(nft: Nft) = when (nft.type) {
        NftType.Eip721 -> try {
            val owner = dataProvider.getEip721Owner(nft.contractAddress, nft.tokenId)
            if (owner == address) {
                1
            } else {
                0
            }
        } catch (rcpError: JsonRpc.ResponseError.RpcError) {
            0
        }
        NftType.Eip1155 -> {
            dataProvider.getEip1155Balance(nft.contractAddress, address, nft.tokenId)
        }
    }

}