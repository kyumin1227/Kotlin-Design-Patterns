package org.example

fun main() {
    var greeting = "Hello Kotlin"

//    greeting = 1  // 코틀린은 선언 시 타입을 추론하므로, greeting 변수는 String 타입으로 고정됩니다.

//    명시적 타입 선언을 사용하면 다음과 같이 작성할 수 있습니다:
//    var greeting: String = "Hello Kotlin"

    println(greeting)

//    greeting = "Hello World!" // greeting 변수는 여전히 String 타입이므로, 다른 String 값을 할당할 수 있습니다.
}