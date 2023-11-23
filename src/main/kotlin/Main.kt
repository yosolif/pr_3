import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    println("Введите количество строк в двумерном массиве:")
    val rows = scanner.nextInt()

    println("Введите количество столбцов в двумерном массиве:")
    val cols = scanner.nextInt()

    val array = Array(rows) { IntArray(cols) }

    val digitSet = mutableSetOf<Int>()

    for (i in 0 until rows) {
        for (j in 0 until cols) {
            print("Введите трехзначное число для [$i][$j]: ")
            val number = scanner.nextInt()
            array[i][j] = number

            // Разбираем число на цифры и добавляем их в множество
            val digits = getDigits(number)
            digitSet.addAll(digits)
        }
    }

    println("Двумерный массив:")
    for (row in array) {
        println(row.joinToString("\t"))
    }

    println("В массиве использовано ${digitSet.size} различных цифр")
}

fun getDigits(number: Int): Set<Int> {
    val digits = mutableSetOf<Int>()
    var n = number

    while (n > 0) {
        val digit = n % 10
        digits.add(digit)
        n /= 10
    }

    return digits
}