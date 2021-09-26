@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import org.w3c.dom.NamedNodeMap
import kotlin.math.PI
import kotlin.math.sqrt
import kotlin.math.max
import kotlin.math.abs

// Урок 3: циклы
// Максимальное количество баллов = 9
// Рекомендуемое количество баллов = 7
// Вместе с предыдущими уроками = 16/21

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая (2 балла)
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var k = 0
    var number = n
    if (number == 0) return 1
    else {
        while (number > 0) {
            k++
            number /= 10
        }
    }
    return k
}

/**
 * Простая (2 балла)
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var fib1 = 1
    var fib2 = 1
    var fib3 = 1
    if (n < 3) return 1
    else {
        for (i in 3..n) {
            fib3 = fib1 + fib2
            fib1 = fib2
            fib2 = fib3
        }
        return fib3
    }

}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var minDel = 1
    for (d in 2..(n / 2)) {
        if (n % d == 0) {
            minDel = d
            break
        }
    }
    if (minDel == 1) return n
    return minDel
}
/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var maxDel = 1
    for (d in 1 until n) {
        if (n % d == 0) maxDel = max(maxDel, d)
    }
    return maxDel
}

/**
 * Простая (2 балла)
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var number = x
    var k = 0
    while (number != 1) {
        if (number % 2 == 0) number /= 2
        else number = 3 * number + 1
        k++
    }
    return k
}

/**
 * Средняя (3 балла)
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var nok = 0
    for (k in 1..(m * n) / 2) {
        if ((k % m == 0) && (k % n == 0)) {
            nok = k
            break
        }
    }
    if (nok == 0) nok = m * n
    return nok
}

/**
 * Средняя (3 балла)
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var flag = 0
    for (i in 2..m) {
        if ((m % i == 0) && (n % i == 0)) {
            flag = 1
            break
        }
    }
    return flag == 0
}

/**
 * Средняя (3 балла)
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var previousNumber = 0
    var tempNumber = 0
    var number = n
    while (number > 0) {
        previousNumber *= 10
        tempNumber = number % 10
        previousNumber += tempNumber
        number /= 10
    }
    return previousNumber
}

/**
 * Средняя (3 балла)
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    var number = n
    var n1 = n
    var k = 0
    var flag = 0
    var mn = 1
    if (n < 10) return true
    else {
        while (number > 0) {
            k++
            number /= 10
        }
        for (i in 1 until k) mn *= 10
        while (n1 > 0) {
            if (n1 % 10 != n1 / mn) {
                flag = 1
                break
            }
            n1 %= mn
            n1 /= 10
            mn /= 100
        }
        return flag == 0
    }
}
/**
 * Средняя (3 балла)
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var number = n
    var n1 = 0
    var k = 0
    var mn = 1
    var flag = 0
    if (n < 10) return false
    else {
        while (number > 0) {
            k++
            number /= 10
        }
        number = n
        for (i in 1 until k) mn *= 10
        while (number > 0) {
            n1 = number
            while (n1 > 0) {
                if ((n1 % 10) != (number % 10)) flag = 1
                n1 /= 10
            }
            number /= 10
        }
        return flag == 1
    }
}


fun exponentiation(n: Int, x: Int): Int {
    var x1 = 1.0
    for (i in 1..n) x1 *= x
    return x1.toInt()
}

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */

fun sin(x: Double, eps: Double): Double = TODO()


/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Сложная (4 балла)
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var z: Int
    var k = 1
    var m: Int
    var n1 = n
    var x: Int
    var x2: Int
    while (true) {
        x = k * k
        x2 = x
        z = 0
        while (x2 > 0) {
            z++
            x2 /= 10
        }
        if (n1 - z > 0) {
            n1 -= z
            k += 1
        } else if (n1 - z == 0) {
            m = x % 10
            k += 1
            return m
        } else {
            k += 1
            return (x / exponentiation(abs(n1 - z), 10)) % 10
        }
    }
}


/**
 * Сложная (5 баллов)
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int = TODO()
