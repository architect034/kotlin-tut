package isisomorphic

class IsIsomorphic {
    private fun getMappingString(s: String): String {
        val hashMap: HashMap<Char, Int> = HashMap()
        val mappingArray: MutableList<Int> = mutableListOf()
        var curr = 0
        for (c in s) {
            if (!hashMap.containsKey(c)) {
                hashMap[c] = curr++
            }
            mappingArray.add(hashMap.getOrDefault(c, 0))
        }
        return mappingArray.joinToString()
    }
    fun isIsomorphic(s: String, t: String): Boolean = getMappingString(s) == getMappingString(t)
}
