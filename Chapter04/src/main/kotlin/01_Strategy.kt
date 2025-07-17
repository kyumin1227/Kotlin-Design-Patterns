fun main() {
    val hero = OurHero()
    hero.shoot()
    hero.currentWeapon = Weapon::banana
    hero.shoot()
}

enum class Direction {
    LEFT, RIGHT
}

data class Projectile(
    private var x: Int,
    private var y: Int,
    private var direction: Direction)

class OurHero {
    private var direction = Direction.LEFT
    private var x: Int = 42
    private var y: Int = 173

    var currentWeapon = Weapon::peashooter

    fun shoot(): Projectile {
        return currentWeapon(x, y, direction)
    }
}

object Weapon {

    fun peashooter(x: Int, y: Int, direction: Direction): Projectile {
        println("It's a peashooter")
        return Projectile(x, y, direction)
    }

    fun banana(x: Int, y: Int, direction: Direction): Projectile {
        println("It's a banana")
        return Projectile(x, y, direction)
    }
}