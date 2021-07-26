package models

sealed trait IProduct {
}

case class Book(name: String) extends IProduct
