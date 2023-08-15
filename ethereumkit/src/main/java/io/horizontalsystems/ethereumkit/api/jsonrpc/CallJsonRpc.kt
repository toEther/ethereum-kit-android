package io.definenulls.ethereumkit.api.jsonrpc

import io.definenulls.ethereumkit.models.Address
import io.definenulls.ethereumkit.models.DefaultBlockParameter

class CallJsonRpc(
        @Transient val contractAddress: Address,
        @Transient val data: ByteArray,
        @Transient val defaultBlockParameter: DefaultBlockParameter
) : DataJsonRpc(
        method = "eth_call",
        params = listOf(mapOf("to" to contractAddress, "data" to data), defaultBlockParameter)
)
