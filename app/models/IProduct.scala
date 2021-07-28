package models

sealed trait IProduct {
  val name: String
  val price: BigDecimal
}

case class Book(name: String, price: BigDecimal) extends IProduct
