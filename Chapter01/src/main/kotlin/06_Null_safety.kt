package org.example

fun main() {
//    val s: String = null // 오류: null을 허용하지 않는 타입에 null을 할당할 수 없습니다.

//    printLength(null) // 오류: null을 허용하지 않는 타입에 null을 전달할 수 없습니다.

    val willInitializeLater: String? = null // nullable 타입으로 선언
}

fun printLength(s: String) {
    println(s.length)
}