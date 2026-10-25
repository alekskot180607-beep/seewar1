
fun main() {
    val player = Player("Вы")
    val enemy = Player("Компьютер")

    // Расстановка
    player.placeShip(3, 2)
    player.placeShip(3, 3)
    player.placeShip(3, 4)
    player.placeShip(3, 5)

    enemy.placeShip(5, 7)
    enemy.placeShip(6, 7)
    enemy.placeShip(7, 7)

    // Выстрелы
    player.registerShot(true)
    player.registerShot(false)
    player.registerShot(true)

    // Читаем статистику через геттеры
    println("Выстрелов: ${player.shots}, Попаданий: ${player.hits}")
    println(player.status())

    // Проверка markShot
    player.markShot(5, 5, true)
    player.markShot(5, 6, false)
    enemy.markShot(2, 2, true)

    printBothFields(player, enemy)
}