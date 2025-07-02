package org.example

import kotlin.reflect.typeOf

fun main() {
    val a = 1000;
    val b = 1000;

    println(a == b)         // true
    println(a.equals(b))    // true
    println(a === b)        // true, Int 타입은 값이 같으면 동일한 객체를 참조합니다.
}