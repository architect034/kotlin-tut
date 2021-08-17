package lettercombinations

import java.lang.StringBuilder

class letterCombinations {

    var ans: MutableList<String> = mutableListOf()

    lateinit var str: String

    private fun giveAllLettersMappedToNumber(digit: Char): List<Char> {
        return when (digit) {
            '2' -> listOf('a', 'b', 'c')
            '3' -> listOf('d', 'e', 'f')
            '4' -> listOf('g', 'h', 'i')
            '5' -> listOf('j', 'k', 'l')
            '6' -> listOf('m', 'n', 'o')
            '7' -> listOf('p', 'q', 'r', 's')
            '8' -> listOf('t', 'u', 'v')
            '9' -> listOf('w', 'x', 'y', 'z')
            else -> listOf()
        }
    }

    private fun solve(position: Int, calculated: StringBuilder) {
        if (position == str.length) {
            calculated.replace("\\s".toRegex(), "").let {
                if (it.length == str.length) {
                    this.ans.add(it.toString())
                }
            }
            return
        }
        for (i in position..str.lastIndex) {
            giveAllLettersMappedToNumber(str[position]).map {
                var temp = calculated[position]
                calculated[position] = it
                solve(i + 1, calculated)
                calculated[position] = temp
            }
        }
    }

    fun letterCombinations(digits: String): List<String> {
        str = digits
        solve(0, StringBuilder("  "))
        return ans
    }
}
