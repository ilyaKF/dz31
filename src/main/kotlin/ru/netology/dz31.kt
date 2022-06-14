package ru.netology

fun main() {
    val allSeconds = 11*60
    println(agoToText(allSeconds))
}

fun agoToText(countSeconds: Int): String {
    return when (countSeconds) {
        in 0..60 -> "был(а) только что"
        in 61..60 * 60 -> "был(а) в сети ${countSeconds / 60} ${correctMessageForMinutes(countSeconds)} назад"
        in 60 * 60 + 1..24 * 60 * 60 -> "был(а) в сети ${countSeconds / (60 * 60)} ${correctMessageForHours(countSeconds)} назад"
        in 24 * 60 * 60 + 1..48 * 60 * 60 -> "был(а) в сети сегодня"
        in 48 * 60 * 60 + 1..62 * 60 * 60 -> "был(а) в сети вчера"
        else -> "был(а) в сети очень давно"
    }
}

fun correctMessageForMinutes (countSeconds: Int):String {
    return when (countSeconds / 60){
        1, 21, 31, 41, 51 -> "минуту"
        in 2 .. 4, in 22 .. 24, in 32 .. 34, in 42 .. 44, in 52 .. 54 -> "минуты"
        in 5 ..20, in 35 ..40, in 45 ..50, in 55 ..60 -> "минут"
        else -> ""
    }
}

fun correctMessageForHours (countSeconds: Int):String {
    return when (countSeconds / (60 * 60)){
        1, 21 -> "час"
        in 2 .. 4, in 22 ..24 -> "часа"
        in 5 ..20 -> "часов"
        else -> ""
    }
}