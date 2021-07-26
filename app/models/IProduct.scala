package models

trait IProduct {
  var amount: Int = 1
}

case class Book(name: String) extends IProduct
