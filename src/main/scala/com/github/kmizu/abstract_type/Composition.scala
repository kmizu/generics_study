package com.github.kmizu.abstract_type

abstract class Composition extends Function {self =>
  type Middle
  type In
  type Out
  def f: Function { type In = self.In; type Out = self.Middle}
  def g: Function { type In = self.Middle; type Out = self.Out}
  def apply(in: In): Out = {
    g(f(in))
  }
}
object Composition {self =>
  val f = new Function { type In = Int; type Out = Int
    override def apply(arg: Int): Int = arg + 2
  }
  val g = new Function { type In = Int; type Out = Int
    override def apply(arg: Int): Int = arg * 2
  }
  val c = new Composition {
    type Middle = Int
    type In = Int
    type Out = Int
    def f = self.f
    def g = self.g
  }

  def main(args: Array[String]): Unit = {
    println(c(3))
  }
}
