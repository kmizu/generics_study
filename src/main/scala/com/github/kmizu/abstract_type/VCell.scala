package com.github.kmizu.abstract_type

abstract class VCell {self =>
  type T
  def head: self.T
  def tail: VCell { type T <: self.T }
}

abstract class VCons extends VCell {self =>
  type T
  def head: self.T
  def tail: VCell { type T <: self.T }
  override def toString(): String = head + " :: " + tail
}

class VEmpty extends VCell {self =>
  type T = Nothing
  def head: self.T = throw new NoSuchMethodException("Empty.head")
  def tail: VCell { type T = self.T } = throw new NoSuchMethodException("Empty.tail")

  override def toString(): String = "Empty"
}
