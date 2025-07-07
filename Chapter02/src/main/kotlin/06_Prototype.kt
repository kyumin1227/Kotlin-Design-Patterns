// 유사하지만 조금 다른 객체를 생성하기 위해서 사용하는 패턴

fun main() {
    val user1 = User("Alice", Role.ADMIN, setOf("edit", "delete"))
    allUsers += user1

    createUser("Bob", Role.ADMIN)

    println(allUsers)
}

data class User(
    val name: String,
    val role: Role,
    private val permissions: Set<String>
) {
    fun hasPermission(permission: String) = permission in permissions
}

enum class Role {
    ADMIN,
    SUPER_ADMIN,
    REGULAR_USER
}

// 실제 어플리케이션에서는 사용자 데이터베이스 할당
val allUsers = mutableListOf<User>()

fun createUser(_name: String, role: Role) {
    for (u in allUsers) {
        if (u.role == role) {
//            역할이 같은 유저가 있으면 복사
            allUsers += u.copy(name = _name)
            return
        }
    }
}