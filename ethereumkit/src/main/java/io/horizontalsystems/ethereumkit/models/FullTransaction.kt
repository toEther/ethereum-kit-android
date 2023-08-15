package io.definenulls.ethereumkit.models

import io.definenulls.ethereumkit.decorations.TransactionDecoration

class FullTransaction(
    val transaction: Transaction,
    val decoration: TransactionDecoration
)
