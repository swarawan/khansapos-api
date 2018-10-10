package com.swarawan.khansapos.api.goods

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.stereotype.Component
import java.util.*

@Component
class GoodsValidator {

    @Autowired
    lateinit var messageSource: MessageSource

    private val errorFieldRequired: String by lazy {
        messageSource.getMessage("error.field.required", null, Locale("en_us"))
    }

    fun validateForm(request: GoodsRequest): String = when {
        request.name.isNullOrEmpty() -> String.format(errorFieldRequired, "Name")
        else -> ""
    }
}