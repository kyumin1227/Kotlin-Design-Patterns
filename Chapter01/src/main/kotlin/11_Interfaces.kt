package org.example

import kotlin.random.Random

fun main() {
    val player = DicePlayer()
    println(player.rollDice())
}

interface DiceRoller {
    fun rollDice(): Int
}

class DicePlayer: DiceRoller {
    override fun rollDice() = Random.nextInt(0, 6)
}