import domain.Node

object CommonStructures{

    //HASH MAP
    val hashMap: HashMap<String, Int> = hashMapOf()
    val hashMap2: HashMap<Node, Int> = HashMap(5)

    fun usageOfHash(){
        val node = Node(null, null)
        hashMap2.getOrPut(node) {
            println("colocando valor no hashMap")
            1 }
        //como os parametros do node sao igual o de cima, uma nova instancia n eh criada.
        hashMap2.getOrElse(Node(null, null)){
            println("tem a entrada Node no hashMap")
        }
        //como mudou parametro, um novo data class eh instanciado
        hashMap2.getOrElse(Node(node, null)){
            println("não tem a entrada Node no hashMap")
        }
        val recoveredNodeValue = hashMap2.remove(node)
        println(recoveredNodeValue)
    }

    // Stack
}
