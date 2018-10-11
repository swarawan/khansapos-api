package com.swarawan.khansapos.controller.goods

import io.swagger.annotations.ApiModelProperty

data class GoodsResponse(@ApiModelProperty(example = "2e6306f2-bc3b-4dfd-8411-e02b95ef70c2", dataType = "String", required = true, position = 0)
                         var secureId: String? = null,

                         @ApiModelProperty(example = "Kacang Panjang", dataType = "String", required = true, position = 1)
                         var name: String? = null,

                         @ApiModelProperty(example = "5000", dataType = "Integer", required = true, position = 2)
                         var price: Int? = 0,

                         @ApiModelProperty(example = "10", dataType = "Integer", required = true, position = 3)
                         var stock: Int? = 0,

                         @ApiModelProperty(example = "true", dataType = "Boolean", required = true, position = 4)
                         var available: Boolean = true)