package com.swarawan.khansapos.entity

import com.swarawan.khansapos.ext.getDefaultDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "goods")
data class Goods(@Id
                 @GeneratedValue(strategy = GenerationType.IDENTITY)
                 var id: Long = 0,

                 @Column(name = "secure_id")
                 var secureId: String? = UUID.randomUUID().toString(),

                 @Column(name = "name")
                 var name: String? = "",

                 @Column(name = "price")
                 var price: Int? = 0,

                 @Column(name = "stock")
                 var stock: Int? = 0,

                 @Column(name = "available")
                 var available: Boolean = true,

                 @Column(name = "created_at")
                 var createdAt: String? = Date().getDefaultDate(),

                 @Column(name = "updated_at")
                 var updatedAt: String? = Date().getDefaultDate())