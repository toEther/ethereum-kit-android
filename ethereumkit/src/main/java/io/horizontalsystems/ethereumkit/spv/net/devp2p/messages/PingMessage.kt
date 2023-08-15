package io.definenulls.ethereumkit.spv.net.devp2p.messages

import io.definenulls.ethereumkit.core.hexStringToByteArray
import io.definenulls.ethereumkit.spv.net.IInMessage

class PingMessage() : IInMessage {

    constructor(payload: ByteArray) : this()

    override fun toString(): String {
        return "Ping"
    }

    companion object {
        val payload = "C0".hexStringToByteArray()
    }
}
