package org.example

fun main(args: Array<String>) {
    lists()

    sets()

    maps()

    arrays()

    println(args.joinToString(", ")) // 명령행 인자를 쉼표로 구분하여 출력
}

fun arrays() {
    val musketeers: Array<String> = arrayOf("Athos", "Porthos", "Aramis")

    println(musketeers)

    listOf(1, 2, 3, 5).toTypedArray()   // List를 Array로 변환
}

fun maps() {
    val movieBatman = mapOf(
        "Batman Returns" to "Michael Keaton",
        "Batman Forever" to "Val Kilmer",
        "Batman & Robin" to "George Clooney",
    )

    println(movieBatman["Batman Returns"])

    println("Batman Begins" !in movieBatman)
}

fun sets() {
    val footballChampions = setOf("France", "Germany", "Spain", "Italy", "Brazil", "France", "Brazil", "Germany")

    println(footballChampions) // 중복된 값은 자동으로 제거 [France, Germany, Spain, Italy, Brazil]

    println("Israel" in footballChampions) // false
    println("Italy" in footballChampions) // true
}

fun lists() {
    val hobbits = listOf("Frodo", "Sam", "Pippin", "Merry")
// 명시적 타입 선언
//    val hobbits: List<String> = listOf("Frodo", "Sam", "Pippin", "Merry")

    println(hobbits[1])

//    hobbits[0] = "Bilbo" // 오류: List는 불변(immutable)

    val editableHobbits = mutableListOf("Frodo", "Sam", "Pippin", "Merry")

    editableHobbits.add("Bilbo") // mutableListOf는 변경 가능(mutable)하므로 요소를 추가 및 수정 가능
}