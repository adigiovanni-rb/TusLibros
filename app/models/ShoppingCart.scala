package models

case class ShoppingCart() {

private var aListOfProducts = List[IProduct]()


  def contain(item: IProduct):Boolean = {
    aListOfProducts.contains(item)
  }

  def add(aItem: IProduct) = {
    aListOfProducts = aListOfProducts:+ aItem
  }

/*
  def addWithQuantity(aProduct: IProduct, aQuantity: Int) = {

    List(1,2,3) ::: List(4)
    aListOfProducts.appended(item)
    // alistOfProducts.::(item)
  }

 */

//  def find(item: IProduct): IProduct = {
//  item match {
//    case item: Book => alistOfProducts.find(item)
//  }
    List(1,2,3) ::: List(4)
//    alistOfProducts.
    // alistOfProducts.::(item)
//  }

  def isEmpty() : Boolean = {
    aListOfProducts.isEmpty
  }

}
