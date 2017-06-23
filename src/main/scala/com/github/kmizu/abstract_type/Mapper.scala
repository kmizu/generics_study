package com.github.kmizu.abstract_type

trait Mapper {self =>
  type C <: TC
  type In
  type Out
  def map(target: C { type T = In })(fun: Function { type In = self.In; type Out = self.Out }): C{ type T = Out }
}

object Mapper {
  trait CellMapper extends Mapper {self =>
    override type C = Cell
    type In
    type Out
    def map(list: Cell{ type T = In })(fun: Function { type In = self.In; type Out = self.Out }): Cell { type T = Out } = list match {
      case x: Cons =>
        new Cons {
          type T = Out
          val head = fun.apply(x.head)
          val tail = map(x.tail)(fun)
        }
      case x: Empty =>
        new Empty {
          type T = Out
        }
    }
  }
}
