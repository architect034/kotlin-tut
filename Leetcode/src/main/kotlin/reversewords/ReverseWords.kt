package reversewords

class ReverseWords {
    fun reverseWords(str: String): String {
        val listOfWords = str.split(" ").filter {
            return@filter it.length > 1
        } as MutableList<String>
        listOfWords.reverse()
        return listOfWords.joinToString(" ", "", "")
    }
}
