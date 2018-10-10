package com.swarawan.khansapos.api.credential

/**
 * Created by rioswarawan on 10/8/18.
 */
class CredentialRequest() {

    data class Register(val name: String,
                        val email: String,
                        val password: String,
                        val confirmation: String)

    data class Login(val email: String,
                     val password: String)
}