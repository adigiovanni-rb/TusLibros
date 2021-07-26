package models

case class ShoppingCart() {

  private var alistOfProducts = List[IProduct]()

  def contain(item: IProduct):Boolean = {
    alistOfProducts.contains(item)
  }

  def add(item: IProduct) = {

    List(1,2,3) ::: List(4)
    alistOfProducts = alistOfProducts.appended(item)
    // alistOfProducts.::(item)
  }

  def find(item: IProduct): IProduct = {
  item match {
    case item: Book => alistOfProducts.find(item)
  }
    List(1,2,3) ::: List(4)
    alistOfProducts.find(item)
    // alistOfProducts.::(item)
  }

  def isEmpty() : Boolean = {
    alistOfProducts.isEmpty
  }

}
