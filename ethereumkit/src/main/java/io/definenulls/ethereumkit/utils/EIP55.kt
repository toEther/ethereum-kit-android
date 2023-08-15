package io.definenulls.ethereumkit.utils

import io.definenulls.ethereumkit.core.stripHexPrefix
import io.definenulls.ethereumkit.core.toHexString
import io.definenulls.ethereumkit.core.toRawHexString
import io.definenulls.ethereumkit.crypto.CryptoUtils
import java.util.*

object EIP55 {

    fun encode(data: ByteArray): String {
        return format(data.toHexString())
    }

    fun format(address: String): String {
        val lowercaseAddress = address.stripHexPrefix().toLowerCase(Locale.ENGLISH)
        val addressHash = CryptoUtils.sha3(lowercaseAddress.toByteArray()).toRawHexString()

        val result = StringBuilder(lowercaseAddress.length + 2)

        result.append("0x")

        for (i in lowercaseAddress.indices) {
            if (Integer.parseInt(addressHash[i].toString(), 16) >= 8) {
                result.append(lowercaseAddress[i].toString().toUpperCase(Locale.ENGLISH))
            } else {
                result.append(lowercaseAddress[i])
            }
        }

        return result.toString()
    }
}
