package com.swarawan.khansapos.controller.goods

data class GoodsRequest(val name: String? = null,
                        val price: Int? = 0,
                        val stock: Int? = 0,
                        val available: Boolean = true)