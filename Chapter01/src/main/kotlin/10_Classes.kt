package org.example

import java.util.*

fun main() {

    val player = Player("Roland")

    println(player.name)

    player.score = -10

    println(player.score)
}

class Player(name: String) {
    val name = name
        get() = field.uppercase(Locale.getDefault())

    var score: Int = 0
        set(value) {
            field = if (value >= 0) {
                value
            } else {
                0
            }
        }
}