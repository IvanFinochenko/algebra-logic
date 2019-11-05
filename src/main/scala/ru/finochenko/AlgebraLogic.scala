package ru.finochenko

object AlgebraLogic {

  def isPredicate(operator: Operator, message: String): Boolean = {
    operator match {
      case Value(value)     => message.contains(value)
      case Not(op)          => !isPredicate(op, message)
      case And(left, right) => isPredicate(left, message) && isPredicate(right, message)
      case Or(left, right)  => isPredicate(left, message) || isPredicate(right, message)
    }
  }

  def parseOperator(predicate: String): Operator = {
    predicate.split(Operations[Or].string, 2) match {
      case Array(left, right) => Or(parseOperator(left), parseOperator(right))
      case _ =>
        predicate.split(Operations[And].string, 2) match {
          case Array(left, right) => And(parseOperator(left), parseOperator(right))
          case _ =>
            if (predicate.startsWith(Operations[Not].string))
              Not(Value(predicate.substring(3)))
            else
              Value(predicate)
        }
    }
  }

}
