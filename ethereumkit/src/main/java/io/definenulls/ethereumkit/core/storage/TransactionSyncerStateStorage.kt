package io.definenulls.ethereumkit.core.storage

import io.definenulls.ethereumkit.models.TransactionSyncerState

class TransactionSyncerStateStorage(database: TransactionDatabase) {
    private val dao = database.transactionSyncerStateDao()

    fun get(syncerId: String): TransactionSyncerState? =
        dao.get(syncerId)

    fun save(transactionSyncerState: TransactionSyncerState) {
        dao.save(transactionSyncerState)
    }

}
