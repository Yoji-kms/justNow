package ru.netology

fun main() {
    printAgo(from = 25, till = 26)
    printAgo(from = 61, till = 60 * 60, step = 60)
    printAgo(from = 60 * 60 + 1, till = 24 * 60 * 60, step = 60 * 60)
    printAgo(from = 24 * 60 * 60 + 1, till = 5 * 24 * 60 * 60, step = 24 * 60 * 60)
}

fun agoToText(secondsAgo: Int): String? {
    val minutesAgo = secondsAgo / 60
    val hoursAgo = minutesAgo / 60
    if (secondsAgo >= 0) {
        when (secondsAgo) {
            in 0..60 -> return "только что"
            in 61..60 * 60 -> return when {
                minutesAgo % 10 == 1 && minutesAgo % 100 != 11 -> "$minutesAgo минуту назад"
                (minutesAgo % 10 == 2 && minutesAgo % 100 != 12) ||
                        (minutesAgo % 10 == 3 && minutesAgo % 100 != 13) ||
                        (minutesAgo % 10 == 4 && minutesAgo % 100 != 14) -> "$minutesAgo минуты назад"
                else -> "$minutesAgo минут назад"
            }
            in 60 * 60 + 1..24 * 60 * 60 -> return when {
                hoursAgo % 10 == 1 && hoursAgo % 100 != 11 -> "$hoursAgo час назад"
                (hoursAgo % 10 == 2 && hoursAgo % 100 != 12) ||
                        (hoursAgo % 10 == 3 && hoursAgo % 100 != 13) ||
                        (hoursAgo % 10 == 4 && hoursAgo % 100 != 14) -> "$hoursAgo часа назад"
                else -> "$hoursAgo часов назад"
            }
            in 24 * 60 * 60 + 1..2 * 24 * 60 * 60 -> return "сегодня"
            in 2 * 24 * 60 * 60 + 1..3 * 24 * 60 * 60 -> return "вчера"
            else -> return "давно"
        }
    } else return null
}

fun printAgo(from: Int, till: Int, step: Int = 1) {
    for (i: Int in from..till step step) {
        val agoText = agoToText(i)
        println("был(-а) $agoText")
    }
}