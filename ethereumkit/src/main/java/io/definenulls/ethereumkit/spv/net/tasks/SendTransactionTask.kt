package io.definenulls.ethereumkit.spv.net.tasks

import io.definenulls.ethereumkit.spv.core.ITask
import io.definenulls.ethereumkit.models.RawTransaction
import io.definenulls.ethereumkit.models.Signature

class SendTransactionTask(val sendId: Int,
                          val rawTransaction: RawTransaction,
                          val signature: Signature) : ITask
