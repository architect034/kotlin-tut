package numrescueboats

class NumRescueBoats {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()
        var answer = 0
        var startIndex = 0
        var endIndex = people.lastIndex
        while (startIndex <= endIndex) {
            if ((people[startIndex] + people[endIndex]) <= limit) {
                startIndex++
                endIndex--
                answer++
            } else {
                endIndex--
                answer++
            }
        }
        return answer
    }
}
