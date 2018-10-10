package com.swarawan.khansapos.api.user

/**
 * Created by rioswarawan on 10/8/18.
 */
data class UserRequest(val name: String,
                       val email: String,
                       val password: String,
                       val confirmation: String)