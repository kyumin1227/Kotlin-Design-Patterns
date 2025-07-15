fun main() {
    val starTrekRepository = DefaultStarTrekRepository()
    val withValidating = ValidatingAdd(starTrekRepository)
    val withLoggingAndValidating = LoggingGetCaptain(withValidating)
    withLoggingAndValidating["USS Enterprise"]
    withLoggingAndValidating["USS 보이저"] = "캐서린 제인웨이"
}

interface StarTrekRepository {
//    연산자 오버로딩 - get과 set은 [] 인덱스의 접근 연산자를 오버로딩 가능
    operator fun get(starshipName: String): String
    operator fun set(starshipName: String, captainName: String)
}

class DefaultStarTrekRepository : StarTrekRepository {
    private val starshipCaptains = mutableMapOf("USS Enterprise" to "장뤽 피카드")

    override fun get(starshipName: String): String {
        // 엘비스 연산자 ?: - null 값을 받았을 때의 기본값 처리
        return starshipCaptains[starshipName] ?: "Unknown"
    }

    override fun set(starshipName: String, captainName: String) {
        starshipCaptains[starshipName] = captainName
    }
}

class LoggingGetCaptain(private val repository: StarTrekRepository):
    StarTrekRepository by repository {
    override fun get(starshipName: String): String {
        println("$starshipName 함선의 선장을 조회 중입니다.")
        return repository[starshipName]
    }
}

class ValidatingAdd(private val repository: StarTrekRepository):
    StarTrekRepository by repository {
        private val maxNameLength = 7
    override fun set(starshipName: String, captainName: String) {
        require (captainName.length < maxNameLength) {
            throw RuntimeException("${captainName}의 이름이 ${maxNameLength}글자를 넘습니다.")
        }
        repository[starshipName] = captainName
    }
}