package io.definenulls.ethereumkit.spv.net

import io.definenulls.ethereumkit.core.ISpvStorage
import io.definenulls.ethereumkit.network.INetwork
import io.definenulls.ethereumkit.spv.models.BlockHeader

class BlockHelper(val storage: ISpvStorage, val network: INetwork) {

    val lastBlockHeader: BlockHeader
        get() = storage.getLastBlockHeader() ?: network.checkpointBlock

}
