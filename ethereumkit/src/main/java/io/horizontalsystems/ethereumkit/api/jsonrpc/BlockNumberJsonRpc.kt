package io.definenulls.ethereumkit.api.jsonrpc

class BlockNumberJsonRpc : LongJsonRpc(
        method = "eth_blockNumber",
        params = listOf()
)
