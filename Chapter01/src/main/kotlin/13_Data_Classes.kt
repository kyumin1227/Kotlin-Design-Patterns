package org.example

// 데이터 클래스는 pojo와 유사한 역할을 함
// 데이터 클래스는 항상 최종 클래스로 상속이 불가능
data class User(val username: String, private val password: String) {
    fun hidePassword() = "*".repeat(password.length)
}

fun main() {
    val user = User("Alexey", "abcd1234")
    println(user.hidePassword())
}