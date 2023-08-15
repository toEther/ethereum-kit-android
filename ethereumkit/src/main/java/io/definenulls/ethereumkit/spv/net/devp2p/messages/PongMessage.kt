package io.definenulls.ethereumkit.spv.net.devp2p.messages

import io.definenulls.ethereumkit.core.hexStringToByteArray
import io.definenulls.ethereumkit.spv.net.IInMessage
import io.definenulls.ethereumkit.spv.net.IOutMessage

class PongMessage() : IInMessage, IOutMessage {

    constructor(payload: ByteArray) : this()

    override fun encoded(): ByteArray {
        return payload
    }

    override fun toString(): String {
        return "Pong"
    }

    companion object {
        val payload = "C0".hexStringToByteArray()
    }
}
