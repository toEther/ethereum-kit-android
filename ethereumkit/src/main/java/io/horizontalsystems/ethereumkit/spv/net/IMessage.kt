package io.definenulls.ethereumkit.spv.net

interface IMessage

interface IInMessage : IMessage

interface IOutMessage : IMessage {
    fun encoded(): ByteArray
}
