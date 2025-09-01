package domain

class Graph<T: Comparable<T>>(var numberOfNodes:Int = 0){
    //adjacent list
    val adjacentList = mutableMapOf<T, MutableList<T>>()

    fun addVertex(node: T){
        adjacentList[node] = mutableListOf()
        numberOfNodes ++
    }

    fun addEdge(node1: T, node2: T){
        adjacentList[node1]?.add(node2)
        adjacentList[node2]?.add(node1)
    }

    fun showConnections(){
        adjacentList.forEach {
            print("node: ${it.key} ")
            println("connections: ${it.value.joinToString(",")}")
        }
    }
}