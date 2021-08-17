package mapsum

class MapSum() {
    /** Initialize your data structure here. */
    private val hashMap: HashMap<String, Int> = HashMap()
    private val wholeMap: HashMap<String, Int> = HashMap()

    fun insert(key: String, value: Int) {
        var str = ""
        if (wholeMap.containsKey(key)) {
            for (c in key) {
                str += c
                hashMap[str] = hashMap[str]!! - wholeMap.getOrDefault(key, 0)
            }
            wholeMap[key] = value
        }
        str = ""
        for (c in key) {
            str += c
            hashMap[str] = hashMap.getOrDefault(str, 0) + value
        }
    }

    fun sum(prefix: String): Int {
        return hashMap.getOrDefault(prefix, 0)
    }
}
