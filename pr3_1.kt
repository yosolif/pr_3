/*Симметричным массивом будет являться:
*    5 2 4 8 0
*    2 9 5 3 1
*    4 5 7 5 2
*    8 3 5 4 3
*    0 1 2 3 0     */
import java.util.*


fun main() {
    val scanner = Scanner(System.`in`)

    val rows = 5
    val cols = 5
    val array = Array(rows) { IntArray(cols) }

    println("Введите элементы для двумерного массива $rows x $cols:")

    for (i in 0 until rows) {
        for (j in 0 until cols) {
            print("Элемент [$i][$j]: ")
            array[i][j] = scanner.nextInt()
        }
    }

    val isSymmetric = isDiagonalSymmetric(array)

    if (isSymmetric) {
        println("Массив является симметричным относительно главной диагонали.")
    } else {
        println("Массив не является симметричным относительно главной диагонали.")
    }
}

fun isDiagonalSymmetric(array: Array<IntArray>): Boolean {
    val rows = array.size
    val cols = array[0].size

    for (i in 0 until rows) {
        for (j in i + 1 until cols) {
            if (array[i][j] != array[j][i]) {
                return false
            }
        }
    }

    return true
}