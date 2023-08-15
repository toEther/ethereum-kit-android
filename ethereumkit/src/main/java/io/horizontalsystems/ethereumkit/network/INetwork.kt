package io.definenulls.ethereumkit.network

import io.definenulls.ethereumkit.spv.models.BlockHeader

interface INetwork {
    val id: Int
    val genesisBlockHash: ByteArray
    val checkpointBlock: BlockHeader
    val blockTime: Long
}