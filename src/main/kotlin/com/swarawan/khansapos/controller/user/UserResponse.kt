package com.swarawan.khansapos.controller.user

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Created by rioswarawan on 10/5/18.
 */
@ApiModel
data class UserResponse(@ApiModelProperty(example = "319114ac-3f73-49fe-96f5-d2f7e5e52d7f", dataType = "String", required = true, position = 0)
                        var secureId: String? = null,

                        @ApiModelProperty(example = "Rio Swarawan", dataType = "String", required = true, position = 1)
                        var name: String? = null,

                        @ApiModelProperty(example = "swarawan.rio@gmail.com", dataType = "String", required = true, position = 2)
                        var email: String? = null)