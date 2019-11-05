package ru.finochenko

sealed trait Operator
final case class Value(value: String) extends Operator
final case class Not(operator: Operator) extends Operator
final case class And(left: Operator, right: Operator) extends Operator
final case class Or(left: Operator, right: Operator) extends Operator
