package io.definenulls.ethereumkit.spv.core

import io.definenulls.ethereumkit.core.ISpvStorage
import io.definenulls.ethereumkit.models.Address
import io.definenulls.ethereumkit.spv.models.AccountStateSpv
import io.definenulls.ethereumkit.spv.models.BlockHeader
import io.definenulls.ethereumkit.spv.net.handlers.AccountStateTaskHandler
import io.definenulls.ethereumkit.spv.net.tasks.AccountStateTask

class AccountStateSyncer(private val storage: ISpvStorage,
                         private val address: Address) : AccountStateTaskHandler.Listener {

    interface Listener {
        fun onUpdate(accountState: AccountStateSpv)
    }

    var listener: Listener? = null

    fun sync(taskPerformer: ITaskPerformer, blockHeader: BlockHeader) {
        taskPerformer.add(AccountStateTask(address, blockHeader))
    }

    override fun didReceive(accountState: AccountStateSpv, address: Address, blockHeader: BlockHeader) {
        storage.saveAccountSate(accountState)
        listener?.onUpdate(accountState)
    }

}
