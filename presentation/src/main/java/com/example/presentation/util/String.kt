package com.example.presentation.util

import java.util.*

fun String.formatToTikiTemplate(): String {
    val output = StringBuilder()
    if (this.isNotEmpty()) {
        val arrayTemp = this.split(" ".toRegex()).filter { it != "" }
        val tempSize = arrayTemp.size
        when (tempSize) {
            1 -> {
                output.append(this)
            }
            2 -> {
                output.append("${arrayTemp[0]}\n${arrayTemp[1]}")
            }
            else -> {
                val customArrayTemp = mutableListOf<String>()
                customArrayTemp.addAll(arrayTemp)
                customArrayTemp.add(Random().nextInt((tempSize - 2)) + 1, "\n")
                customArrayTemp.forEach {
                    output.append("$it ")
                }
            }
        }
    }
    return output.toString()
}

fun String?.valueOrEmpty(): String {
    return this.valueOrDefault("")
}

fun String?.valueOrDefault(default: String): String {
    return this ?: default
}
