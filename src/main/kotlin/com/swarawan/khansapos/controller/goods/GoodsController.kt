package com.swarawan.khansapos.controller.goods

import com.swarawan.khansapos.base.BaseController
import com.swarawan.khansapos.vo.ResultVO
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/goods")
@Api(value = "Goods API", description = "CRUD Goods API")
class GoodsController : BaseController() {

    @Autowired
    lateinit var goodsService: GoodsService

    @ApiOperation(value = "Get all goods records")
    @GetMapping(value = ["/all"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAll(): ResponseEntity<ResultVO> {
        val response = goodsService.getAllGoods()
        return abstractResponseHandler(response).getResult()
    }

    @ApiOperation(value = "Get goods by secure id")
    @GetMapping(value = ["/{secureId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getUser(@PathVariable secureId: String): ResponseEntity<ResultVO> {
        val response = goodsService.getOne(secureId)
        return abstractResponseHandler(response).getResult()
    }

    @ApiOperation(value = "update goods by secure id")
    @PutMapping(value = ["/{secureId}"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun updateOne(@PathVariable secureId: String,
                  @RequestBody request: GoodsRequest): ResponseEntity<ResultVO> {
        val response = goodsService.updateUser(secureId, request)
        return abstractResponseHandler(response).getResult()
    }

    @ApiOperation(value = "add new goods")
    @PostMapping(value = ["/add"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun addOne(@RequestBody request: GoodsRequest): ResponseEntity<ResultVO> {
        val response = goodsService.addGoods(request)
        return abstractResponseHandler(response).getResult()
    }
}