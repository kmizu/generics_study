package com.github.kmizu.abstract_type

abstract class Functor {
  type C <: TC
  type In
  type Out
  def map(container: C { type T = In})(f: In => Out): C { type T = Out}
}
object Functor {
  abstract class CellFunctor extends Functor {self =>
    type C = Cell
    def map(container: Cell { type T = In })(f: In => Out): Cell { type T = Out } = {
      new Mapper.CellMapper {
        override type In = self.In
        override type Out = self.Out
      }.map(container)(new Function {
        override type In = self.In
        override type Out = self.Out
        def apply(arg: In): Out = f(arg)
      })
    }
  }
}