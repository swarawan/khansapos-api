package com.swarawan.khansapos.base

import com.swarawan.khansapos.handler.AbstractResponseHandler

open class BaseController {
    fun abstractResponseHandler(`object`: Any) = object : AbstractResponseHandler() {
        override fun processResponse(): Any? = `object`
    }
}