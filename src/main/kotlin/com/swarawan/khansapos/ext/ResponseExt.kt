package com.swarawan.khansapos.ext

import com.swarawan.khansapos.vo.ResultVO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

/**
 * Created by rioswarawan on 10/5/18.
 */
private val CONTENT_TYPE = "Content-Type"

fun ResultVO.generateResponseEntity(status: HttpStatus = org.springframework.http.HttpStatus.OK): ResponseEntity<ResultVO> {
    val headers = org.springframework.http.HttpHeaders().apply {
        set(CONTENT_TYPE, org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    }
    return org.springframework.http.ResponseEntity(this, headers, status)
}