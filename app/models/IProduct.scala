package models

sealed trait IProduct {
  val name: String
}

case class Book(name: String) extends IProduct
