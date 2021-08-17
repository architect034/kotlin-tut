package nitslocalinvictus

class Pointers {
    companion object {
        var pointsTo = 0
        fun changePointer() {
            pointsTo++
            pointsTo %= 2
        }

        fun resetPointer() {
            pointsTo = 0
        }
    }
}

fun getNewPerm(perm: MutableList<Int>): MutableList<Int> {
    val hash = Array(perm.size + 1) { 0 }
    for (index in perm.indices) {
        hash[perm[index]] = index + 1
    }
    val newPerm = MutableList(perm.size) { 0 }
    for (index in perm.indices) {
        newPerm[index] = hash[index + 1]
    }
    return newPerm
}

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

fun main() {
    val input = readLine()!!.split(" ").map {
        return@map it.toInt()
    }
    val n = input[0]
    var noOfOperations = input[1]
    var perm = readLine()!!.split(" ").map {
        return@map it.toInt()
    } as MutableList<Int>

    while (noOfOperations-- > 0) {
        val op = readLine()!!.split(" ").map {
            return@map it.toInt()
        }
        if (op[0] == 1) {
            Pointers.changePointer()
        } else {
            if (Pointers.pointsTo != 0) {
                perm = getNewPerm(perm)
            }
            perm.swap(op[1] - 1, op[2] - 1)
            Pointers.resetPointer()
        }
    }
    if (Pointers.pointsTo != 0) {
        perm = getNewPerm(perm)
    }
    for (value in perm) {
        print("$value ")
    }
    println()
}
