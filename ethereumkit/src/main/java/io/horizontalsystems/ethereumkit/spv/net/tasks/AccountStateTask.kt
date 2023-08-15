package io.definenulls.ethereumkit.spv.net.tasks

import io.definenulls.ethereumkit.models.Address
import io.definenulls.ethereumkit.spv.core.ITask
import io.definenulls.ethereumkit.spv.models.BlockHeader

class AccountStateTask(val address: Address, val blockHeader: BlockHeader) : ITask
