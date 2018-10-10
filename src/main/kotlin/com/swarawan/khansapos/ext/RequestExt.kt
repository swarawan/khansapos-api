package com.swarawan.khansapos.ext

import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.util.regex.Pattern

/**
 * Created by rioswarawan on 10/5/18.
 */
val EMAIL_ADDRESS = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
)

val PERSON_NAME = Pattern.compile("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*\$")

fun String?.isEmailValid(): Boolean {
    return EMAIL_ADDRESS.matcher(this).matches()
}

fun String?.isNameValid(): Boolean {
    return PERSON_NAME.matcher(this).matches()
}

fun String.isNonNumeric(): Boolean {
    val p = "\\D+".toRegex()
    return matches(p)
}

fun String.isNumeric(): Boolean {
    val p = ".*\\d+.*".toRegex()
    return matches(p)
}

fun String.encrypt(): String {
    val md = MessageDigest.getInstance("MD5")
    val bytes = md.digest(this.toByteArray(StandardCharsets.UTF_8))
    val hashBuilder = StringBuilder()

    bytes.forEach {
        hashBuilder.append(String.format("%02x", it))
    }
    return hashBuilder.toString()
}