package com.example.bloodbank20bce0121

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    // Simulated user credentials for successful login
    private val correctEmail = "user@example.com"
    private val correctPassword = "password"

    // State to hold the login result
    val loginResult = mutableStateOf<LoginResult?>(null)

    fun login(email: String, password: String) {
        // Simulate a network call or actual authentication process
        if (email == correctEmail && password == correctPassword) {
            // Login successful
            loginResult.value = LoginResult.Success
        } else if (email != correctEmail && password == correctPassword)  {
            // Login failed
            loginResult.value = LoginResult.Failure("Invalid credentials. Please try again.")
        }
        else if (email == correctEmail && password != correctPassword)  {
            // Login failed
            loginResult.value = LoginResult.Failure("Invalid credentials. Please try again.")
        }
        else if (email != correctEmail && password != correctPassword)  {
            // Login failed
            loginResult.value = LoginResult.Failure("Invalid credentials. Please try again.")
        }

    }

    sealed class LoginResult {
        object Success : LoginResult()
        data class Failure(val message: String) : LoginResult()
    }
}


