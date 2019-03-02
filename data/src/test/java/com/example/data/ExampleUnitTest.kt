package com.example.data

import org.junit.Test

import org.junit.Assert.*
import java.lang.StringBuilder

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val s = "ThuyetDuong Dep trai"
        println(s.TikiFormat())
    }

    private fun String.TikiFormat(): String {
        val output = StringBuilder()
        if (this.isNotEmpty() && this.contains(" ")) {
            this.split(" ".toRegex()).forEachIndexed { index, it ->
                if (index == 0) {
                    output.append(it + "\n")
                }else
                output.append(" $it")
            }
        } else {
            output.append(this)
        }
        return output.toString()
    }
}