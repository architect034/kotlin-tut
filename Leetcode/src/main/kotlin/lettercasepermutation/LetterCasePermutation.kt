package lettercasepermutation

import java.lang.StringBuilder

class LetterCasePermutation {
    private val listOfStrings: MutableList<String> = mutableListOf()
    private fun solve(str: StringBuilder, index: Int) {
        if (index == str.length) {
            listOfStrings.add(str.toString())
            return
        }
        if (str[index] in 'a'..'z') {
            solve(str, index + 1)
            str[index] = str[index].toUpperCase()
            solve(str, index + 1)
            str[index] = str[index].toLowerCase()
        } else {
            solve(str, index + 1)
        }
    }
    fun letterCasePermutation(S: String): List<String> {
        solve(StringBuilder(S.toLowerCase()), 0)
        return listOfStrings
    }
}
