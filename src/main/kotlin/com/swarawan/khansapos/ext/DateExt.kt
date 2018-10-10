package com.swarawan.khansapos.ext

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by rioswarawan on 10/5/18.
 */
fun Date.getDefaultDate(): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    return dateFormat.format(this)
}