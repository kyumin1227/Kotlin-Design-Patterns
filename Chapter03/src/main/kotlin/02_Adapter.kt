fun main() {
    cellPhone(
        charger(
            krPowerOutlet().toPlugTypeA()
        ).toUsbTypeC()
    )
}

interface PlugTypeF {
    val hasPower: Int
}

interface PlugTypeA {
    val hasPower: String // "TRUE" or "FALSE"
}

interface UsbMini {
    val hasPower: Power
}

enum class Power {
    TRUE, FALSE
}

interface UsbTypeC {
    val hasPower: Boolean
}

fun cellPhone(chargeCable: UsbTypeC) {
    if (chargeCable.hasPower) {
        println("충전 중입니다.")
    } else {
        println("전원이 연결되지 않았습니다.")
    }
}

fun krPowerOutlet(): PlugTypeF {
    return object : PlugTypeF {
        override val hasPower = 1
    }
}

fun charger(plug: PlugTypeA): UsbMini {
    return object : UsbMini {
        override val hasPower = Power.valueOf(plug.hasPower)
    }
}

// 확장 함수 적용

fun PlugTypeF.toPlugTypeA(): PlugTypeA {
    val hasPower = if (this.hasPower == 1) "TRUE" else "FALSE"
    return object : PlugTypeA {
        override val hasPower = hasPower
    }
}

fun UsbMini.toUsbTypeC(): UsbTypeC {
    val hasPower = this.hasPower == Power.TRUE
    return object : UsbTypeC {
        override val hasPower = hasPower
    }
}