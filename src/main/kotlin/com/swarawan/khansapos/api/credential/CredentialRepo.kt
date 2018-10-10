package com.swarawan.khansapos.api.credential

import com.swarawan.khansapos.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

/**
 * Created by rioswarawan on 10/5/18.
 */
@Repository
interface CredentialRepo : JpaRepository<User, Long> {

    @Query(value = "SELECT u FROM USER u WHERE u.email = :email AND u.password = :password",
            nativeQuery = true)
    fun findByEmailPassword(@Param("email") email: String,
                            @Param("password") password: String): User?

}