fun main() {
    val mail = MailBuilder()
        .to(listOf("a", "b", "c"))
        .message("Hello")
        .build()

    println(mail.to)
    println(mail.cc)
    println(mail.message)
}

class MailBuilder {
//    기본값을 정의하여 객체 생성 시 필수가 아니도록 설정
    private var to: List<String> = listOf()
    private var cc: List<String> = listOf()
    private var title: String = ""
    private var message: String = ""
    private var important: Boolean = false

//    internal을 통해 모듈 내의 모든 코드에서 Mail 클래스에 접근 가능
    class Mail internal constructor(
        val to : List<String>,
        val cc : List<String>,
        val title : String,
        val message : String,
        val important : Boolean,
    )

    fun build(): Mail {
        if (to.isEmpty()) {
            throw RuntimeException("To property is empty")
        }
        return Mail(to, cc, title, message, important)
    }

    fun message(message: String): MailBuilder {
        this.message = message
        return this
    }

    fun to(to: List<String>): MailBuilder {
        this.to = to
        return this
    }

}