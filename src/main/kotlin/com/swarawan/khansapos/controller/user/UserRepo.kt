package com.swarawan.khansapos.controller.user

import com.swarawan.khansapos.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by rioswarawan on 10/5/18.
 */
@Repository
interface UserRepo : JpaRepository<User, Long> {

    fun findBySecureId(secureId: String): User

}