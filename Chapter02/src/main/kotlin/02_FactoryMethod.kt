fun main() {
//    말의 종류와 위치를 나타내는 문자열을 받아서 해당 클래스를 생성하는 팩토리 메서드
    val queen = createPiece("qa4")
    val pawn = createPiece("pa2")
    println(queen)
    println(pawn)
}

interface ChessPiece {
    val file: Char
    val rank: Char
}

data class Pawn(
    override val file: Char,
    override val rank: Char
) : ChessPiece

data class Queen(
    override val file: Char,
    override val rank: Char
) : ChessPiece

fun createPiece(notation: String): ChessPiece {
    val (type, file, rank) = notation.toCharArray()

    return when (type) {
        'p' -> Pawn(file, rank)
        'q' -> Queen(file, rank)
        else -> throw IllegalArgumentException("Unknown piece type: $type")
    }
}