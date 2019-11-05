package ru.finochenko

trait Operations[A <: Operator] {
  def string: String
}

object Operations {
  def apply[A <: Operator: Operations]: Operations[A] = implicitly[Operations[A]]

  implicit object NotOperations extends Operations[Not] {
    override def string: String = "NOT"
  }

  implicit object OrOperations extends Operations[Or] {
    override def string: String = "OR"
  }

  implicit object AndOperations extends Operations[And] {
    override def string: String = "AND"
  }

}
