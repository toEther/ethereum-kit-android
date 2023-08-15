package io.definenulls.ethereumkit.api.jsonrpc

import io.definenulls.ethereumkit.models.Address
import io.definenulls.ethereumkit.models.DefaultBlockParameter

class GetTransactionCountJsonRpc(
        @Transient val address: Address,
        @Transient val defaultBlockParameter: DefaultBlockParameter
) : LongJsonRpc(
        method = "eth_getTransactionCount",
        params = listOf(address, defaultBlockParameter)
)
