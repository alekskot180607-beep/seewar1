fun main() {

    val player = Player()
    player.name = "терминатор"

    player.registerShot(true)
    player.registerShot(false)
    player.registerShot(true)

    println(player.status())
    // Ожидается: Игрок терминатор: палуб осталось 20, выстрелов 3, попаданий 2, точность 66.7%

    player.takeDamage()
    player.takeDamage()
    println(player.shipsLeft)    // 18
    println(player.isAlive())    // true

    player.reset()
    println(player.status())
    //ождается: Игрок Вы: палуб осталось 20, выстрелов 0, попаданий 0, точность 0.0%

    // два игрока и печать
    val enemy = Player()
    enemy.name = "Компьютер"

    // ставим корабли
    player.field[3][2] = '#'
    player.field[3][3] = '#'
    enemy.field[5][7] = '#'
    enemy.field[5][5] = 'X'

    println()
    printBothFields(player, enemy)

    println()
    player.printStats()
    enemy.printStats()
}