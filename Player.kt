class Player(val name: String) {


    private val _field: Array<CharArray> = Array(10) { CharArray(10) { '.' } }
    private var _shots: Int = 0
    private var _hits: Int = 0

    fun field(): Array<CharArray> = _field

    val shots: Int
        get() = _shots

    val hits: Int
        get() = _hits

    // считаем выстрелы и попадания
    fun registerShot(hit: Boolean) {
        _shots++
        if (hit) _hits++
    }

    // Ставим корабль (с проверкой координат)
    fun placeShip(row: Int, col: Int) {
        if (row in 0..9 && col in 0..9) {
            _field[row][col] = '#'
        }
    }

    // Отмечаем выстрел врага: X — попал, O — промах
    fun markShot(row: Int, col: Int, hit: Boolean) {
        if (row in 0..9 && col in 0..9) {
            _field[row][col] = if (hit) 'X' else 'O'
        }
    }

    fun status(): String {
        val acc = if (_shots == 0) 0.0 else _hits * 100.0 / _shots
        val accStr = String.format("%.1f", acc)
        return "Игрок $name: выстрелов $_shots, попаданий $_hits, точность $accStr%"
    }
}

fun printBothFields(player: Player, enemy: Player) {
    println("=== Поле игрока ${player.name} ===" + " ".repeat(6) + "=== Поле игрока ${enemy.name} ===")
    print("   ")
    for (c in 0..9) print("$c ")
    print("    ")
    for (c in 0..9) print("$c ")
    println()

    for (r in 0..9) {
        print("$r  ")
        for (c in 0..9) print("${player.field()[r][c]} ")
        print("    ")
        print("$r  ")
        for (c in 0..9) print("${enemy.field()[r][c]} ")
        println()
    }
}
