package com.swarawan.khansapos.api.goods

import com.swarawan.khansapos.base.BaseController
import com.swarawan.khansapos.vo.ResultVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/goods")
class GoodsController : BaseController() {

    @Autowired
    lateinit var goodsService: GoodsService

    @GetMapping(value = ["/all"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAll(): ResponseEntity<ResultVO> {
        val response = goodsService.getAllGoods()
        return abstractResponseHandler(response).getResult()
    }

    @GetMapping(value = ["/{secureId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getUser(@PathVariable secureId: String): ResponseEntity<ResultVO> {
        val response = goodsService.getOne(secureId)
        return abstractResponseHandler(response).getResult()
    }

    @PutMapping(value = ["/{secureId}"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun updateOne(@PathVariable secureId: String,
                  @RequestBody request: GoodsRequest): ResponseEntity<ResultVO> {
        val response = goodsService.updateUser(secureId, request)
        return abstractResponseHandler(response).getResult()
    }

    @PostMapping(value = ["/add"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun addOne(@RequestBody request: GoodsRequest): ResponseEntity<ResultVO> {
        val response = goodsService.addGoods(request)
        return abstractResponseHandler(response).getResult()
    }
}