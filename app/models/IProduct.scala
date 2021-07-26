package models

sealed trait IProduct {
  val amount: Int
}

case class Book(
  amount: Int = 1,
  name: String) extends IProduct
