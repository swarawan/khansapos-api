package com.swarawan.khansapos.api.goods

import com.swarawan.khansapos.entity.Goods
import com.swarawan.khansapos.exception.AppException
import com.swarawan.khansapos.ext.getDefaultDate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import java.util.*

@Service
class GoodsService {

    @Autowired
    lateinit var goodsRepo: GoodsRepo

    @Autowired
    lateinit var goodsValidator: GoodsValidator

    fun getAllGoods(): MutableList<Goods> = goodsRepo.findAll()

    fun getOne(secureId: String): GoodsResponse {
        val goods = goodsRepo.findBySecureId(secureId)
        return GoodsResponse(goods.secureId,
                goods.name,
                goods.price,
                goods.stock,
                goods.available)
    }

    fun addGoods(request: GoodsRequest): GoodsResponse {
        val message = goodsValidator.validateForm(request)
        if (message.isNotEmpty()) throw AppException(errorMessage = message, code = HttpStatus.BAD_REQUEST)

        val newGoods = goodsRepo.save(Goods(
                secureId = UUID.randomUUID().toString(),
                name = request.name,
                price = request.price,
                stock = request.stock,
                available = request.available))
        return GoodsResponse(
                newGoods.secureId,
                newGoods.name,
                newGoods.price,
                newGoods.stock,
                newGoods.available)
    }

    fun updateUser(secureId: String, request: GoodsRequest): GoodsResponse {
        val message = goodsValidator.validateForm(request)
        if (message.isNotEmpty()) throw AppException(errorMessage = message, code = HttpStatus.BAD_REQUEST)

        val oldGoods = goodsRepo.findBySecureId(secureId)
        goodsRepo.save(Goods(
                id = oldGoods.id,
                secureId = oldGoods.secureId,
                name = request.name,
                price = request.price,
                stock = request.stock,
                available = request.available,
                updatedAt = Date().getDefaultDate()))
        return GoodsResponse(
                oldGoods.secureId,
                request.name,
                request.price,
                request.stock,
                request.available)
    }
}