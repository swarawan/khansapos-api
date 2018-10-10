package com.swarawan.khansapos.exception

import com.swarawan.khansapos.vo.ErrorVO
import com.swarawan.khansapos.vo.ResultVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.NoSuchMessageException
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class CustomExceptionHandler : ResponseEntityExceptionHandler() {

    @Autowired
    lateinit var messageSource: MessageSource

    private val errorNotFound: String by lazy {
        messageSource.getMessage("error.404", null, LocaleContextHolder.getLocale())
    }
    private val errorInternalServerError: String by lazy {
        messageSource.getMessage("error.500", null, LocaleContextHolder.getLocale())
    }

    @ExceptionHandler(AppException::class)
    fun badRequest(ex: AppException): ResponseEntity<ResultVO> {
        val error = ErrorVO(ex.errorMessage, ex.code.value())
        val response = ResultVO(status = HttpStatus.BAD_REQUEST.name, error = error)
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(Exception::class)
    fun generalError(ex: Exception): ResponseEntity<ResultVO> {
        val error = ErrorVO(errorInternalServerError, HttpStatus.INTERNAL_SERVER_ERROR.value())
        val response = ResultVO(status = HttpStatus.INTERNAL_SERVER_ERROR.name, error = error)
        return ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(EmptyResultDataAccessException::class)
    fun emptyResult(ex: EmptyResultDataAccessException): ResponseEntity<ResultVO> {
        val error = ErrorVO(errorNotFound, HttpStatus.NOT_FOUND.value())
        val response = ResultVO(status = HttpStatus.NOT_FOUND.name, error = error)
        return ResponseEntity(response, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(NoSuchMessageException::class)
    fun noSuchMessage(ex: NoSuchMessageException): ResponseEntity<ResultVO> {
        val error = ErrorVO(errorNotFound, HttpStatus.NOT_FOUND.value())
        val response = ResultVO(status = HttpStatus.NOT_FOUND.name, error = error)
        return ResponseEntity(response, HttpStatus.NOT_FOUND)
    }
}