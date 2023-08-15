package io.definenulls.ethereumkit.spv.net.tasks

import io.definenulls.ethereumkit.spv.core.ITask
import io.definenulls.ethereumkit.spv.models.BlockHeader

class BlockHeadersTask(val blockHeader: BlockHeader, val limit: Int, val reverse: Boolean = false) : ITask