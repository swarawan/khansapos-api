package com.swarawan.khansapos.api.goods

import com.swarawan.khansapos.entity.Goods
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GoodsRepo : JpaRepository<Goods, Long> {

    fun findBySecureId(secureId: String): Goods

}