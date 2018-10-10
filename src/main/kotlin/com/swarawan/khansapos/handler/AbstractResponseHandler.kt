package com.swarawan.khansapos.handler

import com.swarawan.khansapos.constant.StatusCode
import com.swarawan.khansapos.exception.AppException
import com.swarawan.khansapos.ext.generateResponseEntity
import com.swarawan.khansapos.vo.ErrorVO
import com.swarawan.khansapos.vo.ResultVO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

/**
 * Created by rioswarawan on 10/5/18.
 */
abstract class AbstractResponseHandler {

    fun getResult(): ResponseEntity<ResultVO> {
        val result = ResultVO()
        val processRequest = processResponse()
        return when (processRequest) {
            is AppException -> {
                result.status = StatusCode.ERROR.name
                result.error = ErrorVO(processRequest.errorMessage, processRequest.code.value())
                result.generateResponseEntity(HttpStatus.BAD_REQUEST)
            }
            else -> {
                result.status = StatusCode.OK.name
                result.data = processRequest
                result.generateResponseEntity()
            }
        }
    }

    abstract fun processResponse(): Any?

}