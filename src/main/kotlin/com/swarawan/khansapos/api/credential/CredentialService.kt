package com.swarawan.khansapos.api.credential

import com.swarawan.khansapos.entity.User
import com.swarawan.khansapos.exception.AppException
import com.swarawan.khansapos.ext.encrypt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import java.util.*

@Service
class CredentialService {

    @Autowired
    lateinit var credentialRepo: CredentialRepo

    @Autowired
    lateinit var credentialValidator: CredentialValidator

    fun login(request: CredentialRequest.Login): CredentialResponse {
        val message = credentialValidator.validateLoginForm(request)
        if (message.isNotEmpty()) throw AppException(errorMessage = message, code = HttpStatus.BAD_REQUEST)

        val user = credentialRepo.findByEmailPassword(request.email, request.password.encrypt())
        return CredentialResponse(user?.secureId, user?.name, user?.email)
    }

    fun register(request: CredentialRequest.Register): CredentialResponse {
        val message = credentialValidator.validateRegisterForm(request)
        if (message.isNotEmpty()) throw AppException(errorMessage = message, code = HttpStatus.BAD_REQUEST)

        val newUser = credentialRepo.save(User(
                secureId = UUID.randomUUID().toString(),
                name = request.name,
                email = request.email,
                password = request.password.encrypt()))
        return CredentialResponse(newUser.secureId,
                newUser.name,
                newUser.email)
    }
}