package com.github.kmizu.abstract_type

trait Function {
  type In
  type Out
  def apply(arg: In): Out
}
