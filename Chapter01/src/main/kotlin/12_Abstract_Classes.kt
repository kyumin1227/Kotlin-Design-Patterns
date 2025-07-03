package org.example

fun main() {
    val player = ActivePlayer("Roland")
    println(player.name)
    println(player.rollDice())
    player.move(10, 20)
    println(player.position())

    val confusePlayer = ConfusePlayer("Alice")
    val diceX = confusePlayer.rollDice()
    val diceY = confusePlayer.rollDice()

    confusePlayer.move(diceX, diceY)

    println("${confusePlayer.name} moved to ${confusePlayer.position()} with dice rolls $diceX and $diceY")
}

// 추상 클래스
abstract class Moveable() {
    protected var x: Int = 0
    protected var y: Int = 0

//    추상 메서드 (open 키워드 필요)
    open fun move(x: Int, y: Int) {
        this.x = x
        this.y = y
    }

    fun position() = "$x $y"
}

// 코틀린에서 기본 클래스는 상속을 받을 수 없는 클래스이므로
// 다른 클래스에서 상속받을 수 있는 클래스는 앞에 open 키워드를 붙여야 한다.
open class ActivePlayer(val name: String): Moveable(), DiceRoller {
    override fun rollDice(): Int {
        return (1..6).random()
    }
}

class ConfusePlayer(name: String): ActivePlayer(name) {

    override fun move(x: Int, y: Int) {
        // 부모 클래스의 move 메서드를 호출하지 않고
        // x, y 좌표를 반대로 바꿔서 이동
        this.x = y
        this.y = x
    }
}