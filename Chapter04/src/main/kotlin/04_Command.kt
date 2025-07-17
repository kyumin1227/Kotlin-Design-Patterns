fun main() {
    val trooper = Trooper()
    trooper.appendMove(20, 0)
        .appendMove(20, 20)
        .appendMove(5, 20)
        .executeOrder()
}

open class Trooper {
    private val commands = mutableListOf<Command>()

//    fluent syntax를 이용하기 위해 apply 사용
    fun appendMove(x: Int, y: Int) = apply {
        commands.add(moveGenerator(this, x, y))
    }

    fun executeOrder() {
        while (commands.isNotEmpty()) {
            val order = commands.removeFirst()
            order()
        }
    }

    fun move(x: Int, y: Int) {
        println("($x, $y)로 이동 중")
    }
}

// 실행 가능한 함수로 정의
typealias Command = () -> Unit

val moveGenerator = fun(trooper: Trooper, x: Int, y: Int): Command {
    return fun() {
        trooper.move(x, y)
    }
}