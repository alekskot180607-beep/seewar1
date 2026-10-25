
fun createEmptyField(size: Int = 10): Array<CharArray> {
    return Array(size) { CharArray(size) { '.' } }
}

fun cellChar(cell: Char, showShips: Boolean): Char {
    if (!showShips && cell == '#') return '.'
    return cell
}

fun printField(field: Array<CharArray>, title: String, showShips: Boolean = true, debug: Boolean = false) {
    val size = field.size
    val header = if (debug) "=== $title (debug) ===" else "=== $title ==="
    println(header)

    if (debug) {
        val line = "   " + "+---".repeat(size) + "+"
        println(line)
        for (r in field.indices) {
            print("%2d ".format(r))
            for (c in field[r].indices) {
                print("| ${cellChar(field[r][c], showShips)} ")
            }
            println("|")
            println(line)
        }
    } else {
        print("   ")
        for (c in field.indices) print("$c ")
        println()
        for (r in field.indices) {
            print("$r  ")
            for (c in field[r].indices) {
                print("${cellChar(field[r][c], showShips)} ")
            }
            println()
        }
    }
}

fun printBothFields(player: Array<CharArray>, enemy: Array<CharArray>, showEnemyShips: Boolean = false) {
    if (player.size != enemy.size) {
        println("Ошибка: поля разного размера (${player.size} и ${enemy.size})")
        return
    }

    val size = player.size

    print("   === Ваше поле ===")
    print(" ".repeat(size * 2 + 6))
    println("=== Поле противника ===")

    print("   ")
    for (c in 0 until size) print("$c ")
    print("    ")
    for (c in 0 until size) print("$c ")
    println()

    for (r in 0 until size) {
        print("$r  ")
        for (c in 0 until size) {
            print("${cellChar(player[r][c], true)} ")
        }
        print("    ")
        print("$r  ")
        for (c in 0 until size) {
            print("${cellChar(enemy[r][c], showEnemyShips)} ")
        }
        println()
    }
}

fun printFields(fields: Array<Array<CharArray>>, titles: Array<String>, showShips: BooleanArray) {
    if (fields.size != titles.size || fields.size != showShips.size) {
        println("Ошибка: количество полей, заголовков и флагов не совпадает")
        return
    }

    val size = fields[0].size
    for (f in fields) {
        if (f.size != size) {
            println("Ошибка: поля разного размера")
            return
        }
    }

    for (i in titles.indices) print("=== ${titles[i]} ===" + " ".repeat(size * 2 + 4))
    println()

    print("   ")
    for (i in fields.indices) {
        for (c in 0 until size) print("$c ")
        print("    ")
    }
    println()

    for (r in 0 until size) {
        print("$r  ")
        for (i in fields.indices) {
            for (c in 0 until size) {
                print("${cellChar(fields[i][r][c], showShips[i])} ")
            }
            print("    ")
        }
        println()
    }
}

fun main() {
    val playerField = createEmptyField()
    playerField[3][2] = '#'
    playerField[3][3] = '#'
    playerField[3][4] = '#'
    playerField[3][5] = '#'

    val enemyField = createEmptyField()
    enemyField[5][7] = '#'
    enemyField[6][7] = '#'
    enemyField[7][7] = '#'
    enemyField[5][5] = 'X'
    enemyField[5][6] = 'O'

    printField(playerField, "Ваше поле")
    println()
    printField(enemyField, "Поле противника", showShips = false)

    println()
    val smallField = createEmptyField(8)
    printField(smallField, "Маленькое поле 8×8")

    println()
    val bigField = createEmptyField(12)
    printField(bigField, "Большое поле 12×12")

    println()
    val defaultField = createEmptyField()
    printField(defaultField, "Поле по умолчанию 10×10")

    println()
    printBothFields(playerField, enemyField)

    println()
    printField(playerField, "Ваше поле", debug = true)

    println()
    val thirdField = createEmptyField()
    thirdField[2][2] = 'X'
    val fields = arrayOf(playerField, enemyField, thirdField)
    val titles = arrayOf("Ваше поле", "Противник", "Третье")
    val show = booleanArrayOf(true, false, false)
    printFields(fields, titles, show)
}
