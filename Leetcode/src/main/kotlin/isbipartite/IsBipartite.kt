package isbipartite

class IsBipartite {
    lateinit var adjList: Array<IntArray>
    var color: MutableList<Int> = MutableList(101) { -1 }
    var isPossible = true
    private fun dfs(u: Int, p: Int, c: Int) {
        color[u] = c
        for (v in adjList[u]) {
            if (v == p) continue
            if (color[v] == -1) {
                dfs(v, u, (c + 1) % 2)
            } else if ((c + 1) % 2 != color[v]) {
                isPossible = false
                return
            }
        }
    }
    fun isBipartite(graph: Array<IntArray>): Boolean {
        adjList = graph
        for (nodeValue in graph.indices) {
            if (color[nodeValue] == -1) {
                dfs(nodeValue, -1, 0)
            }
            if (!isPossible) return isPossible
        }
        return isPossible
    }
}
