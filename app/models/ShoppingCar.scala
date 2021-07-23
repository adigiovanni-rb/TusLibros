package models

case class ShoppingCar() {

  private val alistOfProducts = List[IProduct]()

  def contain(item: IProduct):Boolean = {
    alistOfProducts.contains(item)
  }

  def add(item: IProduct) = {
    alistOfProducts.::(item)
  }

  def isEmpty() : Boolean = {
    alistOfProducts.isEmpty
  }

}
