package com.swarawan.khansapos.exception

import com.swarawan.khansapos.constant.StatusCode
import org.springframework.http.HttpStatus

/**
 * Created by rioswarawan on 10/5/18.
 */
class AppException(val errorMessage: String = "",
                   val status: StatusCode = StatusCode.ERROR,
                   val code: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR) : RuntimeException(errorMessage)