import domain.MyLinkedList
import domain.Node
import domain.TreeNode
import java.util.LinkedList

object CommonStructures{

    //HASH MAP

    fun usageOfHash(){
        val hashMap: HashMap<String, Int> = hashMapOf()
        val hashMap2: HashMap<TreeNode<String>, Int> = HashMap(5)
        val treeNode = TreeNode("root", null, null)
        hashMap2.getOrPut(treeNode) {
            println("colocando valor no hashMap")
            1 }
        //como os parametros do node sao igual o de cima, uma nova instancia n eh criada.
        hashMap2.getOrElse(TreeNode("root", null, null)){
            println("tem a entrada Node no hashMap")
        }
        //como mudou parametro, um novo data class eh instanciado
        hashMap2.getOrElse(TreeNode("left", treeNode, null)){
            println("não tem a entrada Node no hashMap")
        }
        val recoveredNodeValue = hashMap2.remove(treeNode)
        println(recoveredNodeValue)
    }

    // Stack - FILO
    fun usageOfStack(){
        val stack: ArrayDeque<String> = ArrayDeque()
        stack.addLast("a")
        stack.addLast("b")
        stack.addLast("c")
        stack.addLast("d")
        stack.addLast("e")

        println(stack.removeLast())
        println(stack.removeLast())
        println(stack.removeLast())
        println(stack.last())
        println(stack.removeLast())
        println(stack.removeLast())
        println(stack.removeLastOrNull())
    }


    // Queue - FIFO
    fun usageOfQueue(){
        val stack: ArrayDeque<String> = ArrayDeque()
        stack.addFirst("a")
        stack.addFirst("b")
        stack.addFirst("c")
        stack.addFirst("d")
        stack.addFirst("e")

        println(stack.removeLast())
        println(stack.removeLast())
        println(stack.removeLast())
        println(stack.last())
        println(stack.removeLast())
        println(stack.removeLast())
        println(stack.removeLastOrNull())
    }

    // Linked List
    // kotlin default linked list is double linked and can be used to do stacks and queues as well
    fun usageOfLinkedList(){
        val operations = LinkedList<String>()
        operations.addLast("sacou 10")
        operations.addFirst("depositou 10")
    }

    fun usageOfManualLinkedList(){
        val linkedList = MyLinkedList(Node(10))
        linkedList.append(5)
        linkedList.append(16)
        linkedList.append(3)
        linkedList.append(6)
        linkedList.transverse()
        linkedList.prepend(1)
        linkedList.insert(3, 13)
        linkedList.transverse()
        println("\n result of remove :${linkedList.remove(4)}")
        linkedList.transverse()
    }
}
