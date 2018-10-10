package com.swarawan.khansapos.entity

import com.swarawan.khansapos.ext.getDefaultDate
import java.util.*
import javax.persistence.*

/**
 * Created by rioswarawan on 10/5/18.
 */
@Entity
@Table(name = "users")
data class User(@Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                var id: Long = 0,

                @Column(name = "secure_id")
                var secureId: String = UUID.randomUUID().toString(),

                @Column(name = "name")
                var name: String? = "",

                @Column(name = "email")
                var email: String? = "",

                @Column(name = "password")
                var password: String? = "",

                @Column(name = "created_at")
                var createdAt: String? = Date().getDefaultDate(),

                @Column(name = "updated_at")
                var updatedAt: String? = Date().getDefaultDate())