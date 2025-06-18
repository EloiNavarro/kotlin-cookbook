fun main() = runBlocking {
    println("Fetching user details...")
    val user: User = DemoRepository.getUserDetails(15)
    println("User with id: $randomId, is ${user.name}")
}

/* Meanwhile in the DemoRepository we have */
suspend fun getUserDetails(id:Int): User? {
    delay(1000L)
    return data.find { it.id == id }
}