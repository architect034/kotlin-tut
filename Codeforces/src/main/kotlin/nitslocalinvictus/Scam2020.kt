package nitslocalinvictus

class Scam2020 {
    private val parent = Array(100001) { index -> index }
    private val size = Array(100001) { 1 }
    private fun root(index: Int): Int {
        var newIndex = index
        while (newIndex != parent[newIndex]) {
            newIndex = parent[parent[newIndex]]
        }
        return newIndex
    }

    private fun union(node1: Int, node2: Int) {
        val rootNode1 = root(node1)
        val rootNode2 = root(node2)
        if (rootNode1 == rootNode2) {
            return
        }
        if (size[rootNode1] > size[rootNode2]) {
            parent[rootNode2] = rootNode1
            size[rootNode1] += size[rootNode2]
            size[rootNode2] = 0
        } else {
            parent[rootNode1] = rootNode2
            size[rootNode2] += size[rootNode1]
            size[rootNode1] = 0
        }
    }

    fun solve() {
        val noOfAccounts = readLine()!!.toInt()
        val accountNames = readLine()!!.split(" ").map { it }
        val mapAccountNamesToNumbers: HashMap<String, Int> = HashMap()
        accountNames.forEachIndexed { index, s -> mapAccountNamesToNumbers[s] = index }
        val m = readLine()!!.toInt()
        val connections: MutableList<Pair<Int, Int>> = mutableListOf()
        for (i in 0 until m) {
            val inp = readLine()!!.split(" ").map {
                return@map it
            }
            connections.add(Pair(mapAccountNamesToNumbers[inp[0]]!!, mapAccountNamesToNumbers[inp[1]]!!))
        }
        val sameAccountsCount = readLine()!!.toInt()
        val sameAccountsGraph: MutableList<Pair<Int, Int>> = mutableListOf()
        for (i in 0 until sameAccountsCount) {
            val inp = readLine()!!.split(" ").map {
                return@map it
            }
            sameAccountsGraph.add(Pair(mapAccountNamesToNumbers[inp[0]]!!, mapAccountNamesToNumbers[inp[1]]!!))
        }
        sameAccountsGraph.forEach {
            union(it.first, it.second)
        }
        val setOfLinksForAccounts: Array<MutableSet<Int>> = Array(noOfAccounts) { mutableSetOf() }
        for (i in 0 until m) {
            val fromAccount = root(connections[i].first)
            val toAccount = root(connections[i].second)
            if (fromAccount == toAccount) continue
            setOfLinksForAccounts[fromAccount].add(toAccount)
        }
        var noOfAccountsAfterMerge = 0
        var noOfConnectionsAfterMerge = 0
        for (i in 0 until noOfAccounts) {
            if (size[i] > 0) {
                noOfAccountsAfterMerge++
            }
        }
        setOfLinksForAccounts.forEach {
            if (it.size > 0) {
                noOfConnectionsAfterMerge += it.size
            }
        }
        println("$noOfAccountsAfterMerge $noOfConnectionsAfterMerge")
    }
}

fun main() {
    Scam2020().solve()
}
