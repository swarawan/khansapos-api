package com.swarawan.khansapos.api.user

import com.swarawan.khansapos.entity.User
import com.swarawan.khansapos.exception.AppException
import com.swarawan.khansapos.ext.getDefaultDate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService {

    @Autowired
    lateinit var userRepo: UserRepo

    @Autowired
    lateinit var userValidator: UserValidator

    fun getAllUser(): MutableList<User> = userRepo.findAll()

    fun getOne(secureId: String): UserResponse {
        val user = userRepo.findBySecureId(secureId)
        return UserResponse(user.secureId, user.name, user.email)
    }

//    fun addUser(request: UserRequest): UserResponse {
//        val message = userValidator.validateRegisterForm(request)
//        if (message.isNotEmpty()) throw AppException(errorMessage = message, code = HttpStatus.BAD_REQUEST)
//
//        val newUser = userRepo.save(User(
//                secureId = UUID.randomUUID().toString(),
//                name = request.name,
//                email = request.email,
//                password = request.password?.encrypt()))
//        return UserResponse(newUser.secureId,
//                newUser.name,
//                newUser.email)
//    }

    fun updateUser(secureId: String, request: UserRequest): UserResponse {
        val message = userValidator.validateDataForm(request)
        if (message.isNotEmpty()) throw AppException(errorMessage = message, code = HttpStatus.BAD_REQUEST)

        val oldUser = userRepo.findBySecureId(secureId)
        userRepo.save(User(
                id = oldUser.id,
                secureId = oldUser.secureId,
                name = request.name,
                email = request.email,
                password = oldUser.password,
                updatedAt = Date().getDefaultDate()))
        return UserResponse(oldUser.secureId,
                request.name,
                request.email)
    }
}