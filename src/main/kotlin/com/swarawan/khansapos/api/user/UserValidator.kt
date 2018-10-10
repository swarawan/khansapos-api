package com.swarawan.khansapos.api.user

import com.swarawan.khansapos.ext.isEmailValid
import com.swarawan.khansapos.ext.isNameValid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.stereotype.Component

/**
 * Created by rioswarawan on 10/5/18.
 */

@Component
class UserValidator {

    @Autowired
    lateinit var messageSource: MessageSource

    private val errorName: String by lazy {
        messageSource.getMessage("error.name.format", null, LocaleContextHolder.getLocale())
    }

    private val errorEmail: String by lazy {
        messageSource.getMessage("error.email.format", null, LocaleContextHolder.getLocale())
    }

    private val errorFieldRequired: String by lazy {
        messageSource.getMessage("error.field.required", null, LocaleContextHolder.getLocale())
    }

    private val errorPasswordNotMatch: String by lazy {
        messageSource.getMessage("error.password.match", null, LocaleContextHolder.getLocale())
    }

//    fun validateRegisterForm(user: UserRequest): String {
//        return when {
//            user.name.isNullOrEmpty() -> String.format(errorFieldRequired, "Name")
//            user.email.isNullOrEmpty() -> String.format(errorFieldRequired, "Email")
//            user.password.isNullOrEmpty() -> String.format(errorFieldRequired, "Password")
//            !user.name.isNameValid() -> String.format(errorName, "Name")
//            !user.email.isEmailValid() -> String.format(errorEmail, "Email")
//            !user.password.equals(user.confirmation) -> errorPasswordNotMatch
//            else -> ""
//        }
//    }

    fun validateDataForm(user: UserRequest): String {
        return when {
            user.name.isEmpty() -> String.format(errorFieldRequired, "Name")
            user.email.isEmpty() -> String.format(errorFieldRequired, "Email")
            !user.name.isNameValid() -> String.format(errorName, "Name")
            !user.email.isEmailValid() -> String.format(errorName, "Email")
            else -> ""
        }
    }
}