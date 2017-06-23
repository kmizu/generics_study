package com.github.kmizu.abstract_type

trait Function {
  type In
  type Out
  def apply(arg: In): Out
}
object Function {
  val f: Function { type In >: String; type Out <: String} = new Function {
    type In = Any
    type Out = String
    def apply(arg: Any): String = arg.toString
  }
}
