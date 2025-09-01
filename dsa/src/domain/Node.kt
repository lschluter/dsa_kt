package domain

data class Node<T>(val value: T, var next: Node<T>? = null, var prev:Node<T>? = null)
