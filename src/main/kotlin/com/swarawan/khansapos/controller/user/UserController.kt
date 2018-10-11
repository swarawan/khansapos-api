package com.swarawan.khansapos.controller.user

import com.swarawan.khansapos.base.BaseController
import com.swarawan.khansapos.vo.ResultVO
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Created by rioswarawan on 10/5/18.
 */
@RestController
@RequestMapping("/api/v1/user")
@Api(value = "User API", description = "CRUD User API")
class UserController : BaseController() {

    @Autowired
    lateinit var userService: UserService

    @ApiOperation(value = "Get all user records")
    @GetMapping(value = ["/all"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAll(): ResponseEntity<ResultVO> {
        val response = userService.getAllUser()
        return abstractResponseHandler(response).getResult()
    }

    @ApiOperation(value = "Get user by secure id")
    @GetMapping(value = ["/{secureId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getUser(@PathVariable secureId: String): ResponseEntity<ResultVO> {
        val response = userService.getOne(secureId)
        return abstractResponseHandler(response).getResult()
    }

    @ApiOperation(value = "update specific user by secure id")
    @PutMapping(value = ["/{secureId}"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun updateData(@PathVariable secureId: String,
                   @RequestBody request: UserRequest): ResponseEntity<ResultVO> {
        val response = userService.updateUser(secureId, request)
        return abstractResponseHandler(response).getResult()
    }
}
