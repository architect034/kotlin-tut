package minwindow

class MinWindow {
    fun minWindow(s: String, t: String): String {
        val hashOfT: HashMap<Char, Int> = hashMapOf()
        for (c in t) hashOfT[c] = hashOfT.getOrDefault(c, 0) + 1
        var start = 0
        var end = -1
        var ans = s.length
        val hashOfS: HashMap<Char, Int> = hashMapOf()
        var ansPair: Pair<Int, Int>? = null
        while (true) {
            println("$start $end")
            hashOfT.forEach { (key, value) -> println("T $key $value") }
            hashOfS.forEach { (key, value) -> println("S $key $value") }
            var containsAll = true
            for (entry in hashOfT) {
                if (hashOfS.getOrDefault(entry.key, -1) != entry.value) {
                    containsAll = false
                    break
                }
            }
            if (containsAll) {
                if (ans > (end - start + 1)) {
                    ans = end - start + 1
                    ansPair = Pair(start, end + 1)
                }
                hashOfS[s[start]] = hashOfS.getOrDefault(s[start], 0) - 1
                start++
            } else {
                end++
                if (end == s.length) break
                hashOfS[s[end]] = hashOfS.getOrDefault(s[end], 0) + 1
            }
        }
        ansPair?.let {
            return s.substring(it.first, it.second)
        }
        return ""
    }
}
