fun main() {
    val bobaFett = StormTrooper(Rifle(), RegularLegs())

    val squad1 = Squad(listOf(bobaFett.copy(), bobaFett.copy(), bobaFett.copy()))
    val squad2 = Squad(bobaFett.copy(), bobaFett.copy(), bobaFett.copy())
}

class Squad(val unit: List<Trooper>): Trooper {

    constructor(vararg units: Trooper):
            this(units.toList())

    override fun move(x: Long, y: Long) {
        for (u in unit) {
            u.move(x, y)
        }
    }

    override fun attackRebel(x: Long, y: Long) {
        for (u in unit) {
            u.attackRebel(x, y)
        }
    }
}
