package com.github.kmizu.abstract_type

import com.github.kmizu.abstract_type

object Main {
  def useCell(): Unit = {
    val cell: Cell { type T = String} =
      new Cons { type T = String
        def head = "A"
        def tail = new Cons { type T = String
          def head = "B"
          def tail = new Empty { type T = String }
        }
      }
    println(cell)
  }

  def useVCell(): Unit = {
    val vcell: VCell{ type T <: Any } =
      new VCons { type T = Int
        def head = 1
        def tail = new VCons { type T = Int
          def head = 2
          def tail = new VEmpty
        }
      }
    println(vcell)
  }

  def useFunctor(): Unit = {
    val cell: Cell { type T = String} =
      new Cons { type T = String
        def head = "A"
        def tail = new Cons { type T = String
          def head = "B"
          def tail = new Empty { type T = String }
        }
      }
    class FunctorUser {self =>
      type Fnc <: Functor
      type Con <: TC
      type In = String
      type Out = String
      def useFunctor(container: Con { type T = String })
                    (f: String => String)
                    (implicit functor: Fnc { type C = Con; type In = String; type Out = String })
      : Con { type T = String } = {
        functor.map(container)(f)
      }
    }
    object CellFunctorUser extends FunctorUser{self =>
      override type Fnc = Functor.CellFunctor
      override type Con = Cell
      implicit val functor = (new Functor.CellFunctor {
        override type In = String
        override type Out = String
      })
      val result = useFunctor(cell)(x => x * 3)
      println(result)
    }
    println(CellFunctorUser.result)
  }


  def main(args: Array[String]): Unit = {
    useCell()
    useVCell()
    useFunctor()
  }
}
