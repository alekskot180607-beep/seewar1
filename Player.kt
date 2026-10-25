class Player {
    var name: String = ""
    var field: Array<CharArray> = Array(10) { CharArray(10) { '.' } }
    var shots: Int = 0
    var hits: Int = 0
    var shipsLeft: Int = 20

    fun isAlive(): Boolean {
        return shipsLeft > 0
    }

    fun accuracy(): Double {
        if (shots == 0) return 0.0
        return hits * 100.0 / shots
    }

    fun status(): String {
        val acc = String.format("%.1f", accuracy())
        return "Игрок $name: палуб осталось $shipsLeft, выстрелов $shots, попаданий $hits, точность $acc%"
    }

    fun takeDamage(): Boolean {
        shipsLeft--
        return shipsLeft > 0
    }

    fun registerShot(hit: Boolean) {
        shots++
        if (hit) {
            hits++
        }
    }

    fun reset() {
        shots = 0
        hits = 0
        shipsLeft = 20
        for (r in field.indices) {
            for (c in field[r].indices) {
                field[r][c] = '.'
            }
        }
    }

    fun printField() {
        println("=== Поле игрока: $name ===")
        print("   ")
        for (c in field.indices) print("$c ")
        println()
        for (r in field.indices) {
            print("$r  ")
            for (c in field[r].indices) {
                print("${field[r][c]} ")
            }
            println()
        }
    }

    fun printStats() {
        println(status())
    }
}

fun printBothFields(player: Player, enemy: Player) {
    println("=== Ваше поле ===")
    print(" ".repeat(player.field.size * 2 + 6))
    println("=== Поле противника ===")

    print("   ")
    for (c in player.field.indices) print("$c ")
    print("    ")
    for (c in enemy.field.indices) print("$c ")
    println()

    for (r in player.field.indices) {
        print("$r  ")
        for (c in player.field[r].indices) {
            print("${player.field[r][c]} ")
        }
        print("    ")
        print("$r  ")
        for (c in enemy.field[r].indices) {
            print("${enemy.field[r][c]} ")
        }
        println()
    }
}