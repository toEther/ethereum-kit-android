package io.definenulls.ethereumkit.api.jsonrpc

import io.definenulls.ethereumkit.models.Address
import io.definenulls.ethereumkit.models.DefaultBlockParameter

class GetStorageAtJsonRpc(
        @Transient val contractAddress: Address,
        @Transient val position: ByteArray,
        @Transient val defaultBlockParameter: DefaultBlockParameter
) : DataJsonRpc(
        method = "eth_getStorageAt",
        params = listOf(contractAddress, position, defaultBlockParameter)
)
