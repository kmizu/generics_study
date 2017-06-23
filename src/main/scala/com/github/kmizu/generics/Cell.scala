package com.github.kmizu.generics


sealed trait Cell[+T] // <-- コレ
case class Cons[+T](head: T, tail: Cell[T]) extends Cell[T]
case object Empty extends Cell[Nothing]
