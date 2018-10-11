package com.swarawan.khansapos.controller.user

/**
 * Created by rioswarawan on 10/8/18.
 */
data class UserRequest(val name: String,
                       val email: String,
                       val password: String,
                       val confirmation: String)