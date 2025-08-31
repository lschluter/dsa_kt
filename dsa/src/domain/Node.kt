package domain

data class Node<T>(val value: T, var next: Node<T>? = null, var prev:Node<T>? = null)

class MyLinkedList<T>(var head: Node<T>){
    var tail = head
    var length = 1

    fun append(value: T){
        val newNode = Node(value, prev = tail)
        tail.next = newNode
        tail = newNode
        length ++
    }

    fun prepend(value: T){
        val newNode = Node(value, head)
        head.prev = newNode
        head = newNode
        length ++

    }

    fun removeFirst(): T{
        head.next?.let{
            val result = head
            it.prev = null
            head = it
            return result.value
        }
        throw NullPointerException()
    }


    fun removeLast(): T{
        tail.prev?.let{
            val result = tail
            it.next = null
            tail = it
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


    fun transverBackwards(){
        var prev:Node<T>? = tail
        println("\ntransverse backwards \n length: $length")
        while(prev != null){
            print("value: ${prev.value} --> ")
            prev = prev.prev ?: return
        }
    }

    fun reverse(){
        if(head.next == null){
            return
        }
        var actual: Node<T>? = head
        val newHead = tail
        tail = head
        while(actual != null){
            val prev = actual.prev
            val next = actual.next
            actual.prev = next
            actual.next = prev
            actual = next
        }
        head = newHead
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
        transverseToIndex(index, {
            actual = actual.next!!
        }, {
            actual.prev!!.next = actual.next
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
        transverseToIndex(index, onFound = {
            val prev = actual.prev
            val newNode = Node(value, next = actual, prev=prev)
            actual.prev = newNode
            prev!!.next = newNode
            length ++},
            onIterate = {
            actual = actual.next!!
        })
    }
}