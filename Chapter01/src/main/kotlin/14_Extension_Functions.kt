package org.example

data class Password(val password: String) {
    fun hidePassword(): String = "*".repeat(password.length)
}

// 확장 함수로 기존의 String 클래스에 hidePassword 메서드를 추가
fun String.hidePassword() = "*".repeat(this.length)

// 위의 확장 함수는 아래와 같은 전역 함수를 추가하는 것과 동일

//fun hidePassword(password: String): String {
//    return "*".repeat(password.length)
//}

fun main() {
    val password = "secretpassword"

    println(password.hidePassword())
}