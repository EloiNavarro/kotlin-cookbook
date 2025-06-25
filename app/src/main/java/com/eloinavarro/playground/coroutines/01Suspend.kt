package com.eloinavarro.playground.coroutines

import com.eloinavarro.playground.DemoRepository
import com.eloinavarro.playground.User
import kotlinx.coroutines.runBlocking
import kotlin.random.Random


fun main() = runBlocking {
    println("Fetching user details...")
    val randomId = Random.nextInt(from = 1, until = 60)
    val user: User? = DemoRepository.getUserDetails(randomId)
    if (user != null) {
        println("User with id: $randomId, is ${user.name}")
    } else {
        println("User with id: $randomId, not found")
    }
}