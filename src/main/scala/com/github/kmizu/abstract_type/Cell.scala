package com.github.kmizu.abstract_type

abstract class Cell extends TC {self =>
  type T
  def head: self.T
  def tail: Cell { type T = self.T }
}
abstract class Cons extends Cell {self =>
  type T
  def head: self.T
  def tail: Cell { type T = self.T }
  override def toString(): String = head + " :: " + tail
}
abstract class Empty extends Cell {self =>
  type T
  def head: self.T = throw new NoSuchMethodException("Empty.head")
  def tail: Cell { type T = self.T } = throw new NoSuchMethodException("Empty.tail")

  override def toString(): String = "Empty"
}
