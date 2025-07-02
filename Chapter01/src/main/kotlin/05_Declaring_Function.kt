package org.example

// 반환이 없다면 반환형 생략 가능
fun main() {
    greet(getGreeting())
}

fun greet(greeting: String) {
    println(greeting)
}

// 위의 greet 함수는 다음과 같이 한줄로 작성할 수도 있습니다:
// fun greet(greeting: String) = println(greeting)

fun getGreeting(): String {
    return "Hello Kotlin"
}
