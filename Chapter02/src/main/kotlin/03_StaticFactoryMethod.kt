fun main() {
    val port1 = Server.withPort(8080)
//    Server(9090)  에러: Server 클래스의 생성자는 private 이므로 외부에서 호출 불가능
    val port2 = Server.withPort(8080)
    val port3 = Server.withPort(9090)

    println("Server created on port $port1")
    println("Server created on port $port2")
    println("Server created on port $port3")
}

// Server 클래스는 object 가 아니기 때문에 같은 포트 번호로 여러 인스턴스를 생성할 수 있음
class Server private constructor(port: Long) {

    init {
        println("Server initialized on port $port")
    }

//  동반 객체로 자바의 static 메서드와 유사한 팩토리 메서드를 제공
//  withPort 메서드는 하나만 정의됨
    companion object {
        fun withPort(port: Long) = Server(port)
    }
}