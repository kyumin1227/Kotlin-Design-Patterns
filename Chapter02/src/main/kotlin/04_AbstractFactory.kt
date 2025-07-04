fun main() {
    val environment = Parser.server(listOf("port: 8080", "environment: production"))
    println(environment)

    // is를 이용하여 안전하게 타입을 검사 가능
    println(environment.properties.get(0) is IntProperty)
    println(environment.properties.get(0) is StringProperty)
}

class Parser {

    companion object {
        fun server(propertyStrings: List<String>): ServerConfiguration {
            val parsedProperties = mutableListOf<Property>()
            for (p in propertyStrings) {
                parsedProperties += property(p)
            }

            return ServerConfigurationImpl(parsedProperties)
        }

        fun property(prop: String): Property {
            val (name, value) = prop.split(":")

            return when (name) {
                "port" -> IntProperty(name, value.trim().toInt())
                "environment" -> StringProperty(name, value.trim())
                else -> throw RuntimeException("Unknown property: $name")
            }
        }
    }
}

interface Property {
    val name: String
    val value: Any  // Any 타입은 모든 타입을 허용하나 null은 허용하지 않음
}

interface ServerConfiguration {
    val properties: List<Property>
}

data class ServerConfigurationImpl(
    override val properties: List<Property>
) : ServerConfiguration

// 타입 캐스팅을 하여 Any로 저장하는 것은 안전하지 않기 때문에 하위 클래스 생성
data class IntProperty(
    override val name: String,
    override val value: Int
) : Property

data class StringProperty(
    override val name: String,
    override val value: String
) : Property
