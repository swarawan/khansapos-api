package com.swarawan.khansapos.api.credential

import com.swarawan.khansapos.base.BaseController
import com.swarawan.khansapos.vo.ResultVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by rioswarawan on 10/5/18.
 */
@RestController
@RequestMapping("/api/v1/credential")
class CredentialController : BaseController() {

    @Autowired
    lateinit var credentialService: CredentialService

    @Autowired
    lateinit var messageSource: MessageSource

    @PostMapping(value = ["/register"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun register(@RequestBody request: CredentialRequest.Register): ResponseEntity<ResultVO> {
        val response = credentialService.register(request)
        return abstractResponseHandler(response).getResult()
    }

    @PostMapping(value = ["/login"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun login(@RequestBody request: CredentialRequest.Login): ResponseEntity<ResultVO> {
        val response = credentialService.login(request)
        return abstractResponseHandler(response).getResult()
    }
}
