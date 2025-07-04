fun main() {
    println("Singleton Example")
    // Accessing the singleton instance
    Logger.log("This is a log message")
}

// object로 선언된 객체는 싱글톤 패턴을 따름
object Logger {
//    싱글톤 객체의 초기화 블록은 lazy 하게 실행
    init {
        println("Logger initialized")
    }

    fun log(message: String) {
        println("Log: $message")
    }
}