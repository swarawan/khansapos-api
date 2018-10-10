package com.swarawan.khansapos.api.goods

data class GoodsResponse(var secureId: String? = null,
                         var name: String? = null,
                         var price: Int? = 0,
                         var stock: Int? = 0,
                         var available: Boolean = true)