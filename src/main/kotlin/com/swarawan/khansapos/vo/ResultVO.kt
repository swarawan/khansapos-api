package com.swarawan.khansapos.vo

import com.swarawan.khansapos.constant.StatusCode

/**
 * Created by rioswarawan on 10/4/18.
 */
data class ResultVO(var status: String = StatusCode.OK.name,
                    var data: Any? = null,
                    var error: ErrorVO? = null)