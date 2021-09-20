@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая (2 балла)
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    val firstTwo = ((number / 100) % 10) + (number / 1000)
    val secondTwo = ((number % 100) / 10) + (number % 10)
    val b = firstTwo == secondTwo
    return b
}

/**
 * Простая (2 балла)
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean =
    (x1 == x2) || (y1 == y2) || (abs(x1 - y1) == abs(x2 - y2))



/**
 * Простая (2 балла)
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
    if (month <= 7 && month != 2 && month % 2 != 0) return 31
    else if (month <= 7 && month != 2 && month % 2 == 0) return 30
    else if (year % 100 == 0 && year % 400 != 0) return 28
    else if (month == 2 && year % 4 == 0) return 29
    else if (month == 2 && year % 4 != 0) return 28
    else if (month >= 8 && month % 2 == 0) return 31
    else return 30
}

/**
 * Простая (2 балла)
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean = r1 + sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) <= r2

/**
 * Средняя (3 балла)
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
    val ma = max(max(a, b), max(b, c))
    val mi = min(min(a, b), min(b, c))
    val sr =
        if (a != ma && a != mi) a
        else if (c != ma && c != mi) c
        else b
    val maWall = max(r, s)
    val miWall = min(r, s)
    return sr * mi <= maWall * miWall && sr <= maWall && mi <= miWall
}

