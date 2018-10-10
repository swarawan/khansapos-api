package com.swarawan.khansapos.api.user

import com.swarawan.khansapos.base.BaseController
import com.swarawan.khansapos.vo.ResultVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Created by rioswarawan on 10/5/18.
 */
@RestController
@RequestMapping("/api/v1/user")
class UserController : BaseController() {

    @Autowired
    lateinit var userService: UserService

    @Autowired
    lateinit var messageSource: MessageSource

    @GetMapping(value = ["/all"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAll(): ResponseEntity<ResultVO> {
        val response = userService.getAllUser()
        return abstractResponseHandler(response).getResult()
    }

    @GetMapping(value = ["/{secureId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getUser(@PathVariable secureId: String): ResponseEntity<ResultVO> {
        val response = userService.getOne(secureId)
        return abstractResponseHandler(response).getResult()
    }

    @PutMapping(value = ["/{secureId}"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun updateData(@PathVariable secureId: String,
                   @RequestBody request: UserRequest): ResponseEntity<ResultVO> {
        val response = userService.updateUser(secureId, request)
        return abstractResponseHandler(response).getResult()
    }

//    @PostMapping(value = ["/add"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
//    fun addUser(@RequestBody request: UserRequest): ResponseEntity<ResultVO> {
//        val response = userService.addUser(request)
//        return abstractResponseHandler(response).getResult()
//    }
}
