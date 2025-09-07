package domain

data class TreeNode<T: Comparable<T>>(val value: T, var left: TreeNode<T>? = null, var right: TreeNode<T>? = null)

class BinarySearchTree<T : Comparable<T>>(var root: TreeNode<T>){
    //this is DFS
    fun traverse(node: TreeNode<T>){
        node.left?.let{
            traverse(it)
            println(it.value)
        }
        node.right?.let{
            traverse(it)
            println(it.value)
        }
    }

    fun breadthFirstSearch(){
        val queue: ArrayDeque<TreeNode<T>> = ArrayDeque()
        queue.addFirst(root)
        while(queue.isNotEmpty()){
            val currentNode = queue.removeLast()
            println(currentNode.value)
            currentNode.left?.let{
                queue.addFirst(it)
            }
            currentNode.right?.let{
                queue.addFirst(it)
            }
        }
    }

    fun breadthFirstSearchRec(queue: ArrayDeque<TreeNode<T>>){
        if(queue.isEmpty()){
            return
        }
        val currentNode = queue.removeLast()
        println(currentNode.value)
        currentNode.left?.let{
            queue.addFirst(it)
        }
        currentNode.right?.let{
            queue.addFirst(it)
        }
    }

    fun insert(value: T){
        recInsert(value, root)
    }
    private fun recInsert(value: T, node: TreeNode<T>){
        if(node.value > value){
            node.left?.let {
                recInsert(value, it)
            } ?: run{
                node.left = TreeNode<T>(value)
            }
        }else if(node.value < value) {
            node.right?.let{
                recInsert(value, it)
            } ?: run {
                node.right = TreeNode<T>(value)
            }
        }
    }

    fun search(value: T): TreeNode<T>?{
        return recSearch(value, root)
    }

    fun recSearch(value: T, node: TreeNode<T>): TreeNode<T>?{
        if(value == node.value){
            return node
        }else if(node.value >= value){
            node.left?.let {
                return recSearch(value, it)
            }
        }else if(node.value <= value) {
            node.right?.let{
                return recSearch(value, it)
            }
        }
        return null
    }

    fun delete(value: T): Boolean{
       return recDel(value, root)
    }

    private fun insertChildern(node: TreeNode<T>){
        node.left?.let{
            insert(it.value)
            insertChildern(it)
        }
        node.right?.let{
            insert(it.value)
            insertChildern(it)
        }
    }

    private fun recDel(value: T, node: TreeNode<T>): Boolean {
        if(node.value >= value){
            node.left?.let {
                if(it.value == value){
                    node.left = null
                    insertChildern(it)
                    return true
                }else{
                    return recDel(value, it)
                }
            }
        }else if(node.value <= value) {
            node.right?.let{
                if(it.value == value){
                    //should delete right
                    node.right = null
                    insertChildern(it)
                    return true
                }else{
                    return recDel(value, it)
                }
            }
        }
        return false
    }
}

//options for unbalanced -> RedBlack or AVL

/*
3
[[0,0,0,1,1,1,0,1,0,0]
,[1,1,0,0,0,1,0,1,1,1]
,[0,0,0,1,1,1,0,1,0,0]
,[0,1,1,0,0,0,1,0,1,0]
,[0,1,1,1,1,1,0,0,1,0]
,[0,0,1,0,1,1,1,1,0,1]
,[0,1,1,0,0,0,1,1,1,1]
,[0,0,1,0,0,1,0,1,0,1]
,[1,0,1,0,1,1,0,0,0,0]
,[0,0,0,0,1,1,0,0,0,1]]

4

[[0,1,1,0,0,0,0,1,1,0,0,0]
,[1,0,1,1,1,0,1,0,1,1,1,0]
,[1,1,0,1,0,0,1,1,0,1,1,1]
,[1,0,0,1,1,0,1,0,1,0,1,0]
,[1,0,0,0,0,1,0,0,1,1,0,1]
,[1,1,1,0,0,0,1,0,0,1,1,1]
,[1,1,1,0,0,0,0,1,0,1,0,1]
,[0,1,1,1,1,0,0,1,1,0,0,0]
,[0,1,0,1,0,1,0,1,0,0,0,1]
,[0,0,1,0,1,1,0,0,0,1,1,1]]
 */