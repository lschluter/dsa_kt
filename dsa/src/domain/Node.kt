package domain

data class Node<T>(val value: T, var next: Node<T>? = null, var prev:Node<T>? = null)

class MyLinkedList<T>(var head: Node<T>){
    var tail = head
    var length = 1

    fun append(value: T){
        val newNode = Node(value)
        tail.next = newNode
        tail = newNode
        length ++
    }

    fun prepend(value: T){
        val newNode = Node(value, head)
        head = newNode
        length ++

    }

    fun removeFirst(): T{
        head.next?.let{
            val result = head
            head = it
            return result.value
        }
        throw NullPointerException()
    }

    fun transverse(){
        var next:Node<T>? = head
        println("\ntransverse \n length: $length")
        while(next != null){
            print("value: ${next.value} --> ")
            next = next.next ?: return
        }
    }

    fun transverseToIndex(index: Int, onIterate: () -> Unit, onFound: () -> Unit){
        for(i in 0..<length){
            if(i == index){
                onFound()
                return
            }else{
                onIterate()
            }
        }
    }

    fun remove(index: Int): T{
        if(index !in 0..<length){
            throw Throwable("Invalid index")
        }

        var actual = head
        var prev = head
        transverseToIndex(index, {
            prev = actual
            actual = actual.next!!
        }, {
            prev.next = actual.next
            length --
        })
        return actual.value
    }

    fun insert(index: Int, value: T){
        if(index == 0){
            prepend(value)
        }

        if(index == length-1){
            append(value)
        }

        var actual = head
        var prev = head
        transverseToIndex(index, onFound = {
            val newNode = Node(value, actual)
            prev.next = newNode
            length ++},
            onIterate = {
            prev = actual
            actual = actual.next!!
        })
    }
}