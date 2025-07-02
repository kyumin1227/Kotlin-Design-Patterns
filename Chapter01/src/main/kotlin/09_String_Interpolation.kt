package org.example

fun main() {
    val hero = "Batman"
    println("Archenemy of $hero is ${archenemy(hero)}")
//    함수를 호출할 때는 중괄호를 사용

    println("Twinkle, Twinkle Little Bat\n" +
            "How I wonder what you're at!\n" +
            "Up above the world you fly,\n" +
            "Like a tea tray in the sky.\n" +
            "Twinkle, twinkle, little bat!\n" +
            "How I wonder what you're at!")

    println("""Twinkle, Twinkle Little Bat
    How I wonder what you're at!
    Up above the world you fly,
    Like a tea tray in the sky.
    Twinkle, twinkle, little bat!
    How I wonder what you're at!""")

    println("""
    Twinkle, Twinkle Little Bat
    How I wonder what you're at! 
    """.trimIndent())
//    공백 문자 제거

//    여러줄 문자열에는 쌍따옴표를 이스케이프 하지 않아도 됨
    println(" From \" Alice's Adventures in Wonderland \" ")
    println(""" From " Alice's Adventures in Wonderland " """)
}