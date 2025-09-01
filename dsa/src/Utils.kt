import domain.BinarySearchTree
import domain.MyLinkedList
import domain.Node
import domain.TreeNode
import java.util.Comparator
import java.util.LinkedList
import java.util.PriorityQueue

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

    // Stack - LIFO - put in on end (first or last) and get from the same end
    fun usageOfStack(){
        val stack: ArrayDeque<String> = ArrayDeque()
        stack.addFirst("a")
        stack.addFirst("b")
        stack.addFirst("c")
        stack.addFirst("d")
        stack.addFirst("e")

        println(stack.removeFirst())
        println(stack.removeFirst())
        println(stack.removeFirst())
        println(stack.first())
        println(stack.removeFirst())
        println(stack.removeFirst())
        println(stack.removeFirstOrNull())
    }


    // Queue - FIFO - put in on end (first or last) and get from the oposite end
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
        linkedList.prepend(1)
        linkedList.transverse()
        linkedList.insert(3, 13)
        linkedList.transverBackwards()
        linkedList.transverse()
        println("reverse")
        linkedList.reverse()
        linkedList.transverBackwards()
        linkedList.transverse()
        linkedList.removeLast()
        linkedList.removeFirst()
        linkedList.transverse()
        linkedList.transverBackwards()
    }

    fun usageOfMyBST(){
        val tree = BinarySearchTree<Int>(TreeNode(9))
        tree.insert(4)
        tree.insert(6)
        tree.insert(20)
        tree.insert(170)
        tree.insert(15)
        tree.insert(1)
        tree.traverse(tree.root)
        println(tree.search(3)?.value)
        println(tree.delete(4))
        tree.traverse(tree.root)
    }

    // PRIORITY QUEUE
    fun usageOfPriorityQueue(){
        val priorityQueue = PriorityQueue<Int>()
        priorityQueue.add(10)
        priorityQueue.add(6)
        priorityQueue.add(3)
        println(priorityQueue.first())


        val priorityQueueMax = PriorityQueue<Int>(Comparator.reverseOrder())
        priorityQueueMax.add(10)
        priorityQueueMax.add(6)
        priorityQueueMax.add(3)
        println(priorityQueueMax.first())

    }

}
