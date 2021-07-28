package models

case class ShoppingCart() {

private var aListOfProducts = List[IProduct]()


  def contain(item: IProduct):Boolean = {
    aListOfProducts.contains(item)
  }

  def add(aItem: IProduct) = {
    aListOfProducts = aListOfProducts:+ aItem
  }


  def addWithQuantity(aItem: IProduct, aQuantity: Int) = {
// validar que exista en catalago
    // validar cantidad mayor a 0
    for (_ <- 1 to aQuantity) {
      aListOfProducts = aListOfProducts:+ aItem
    }
  }

  def countUniqueItem(aItem: IProduct): Int = {
    aListOfProducts.filter(_.name.equals(aItem.name)).length
  }

  def isEmpty() : Boolean = {
    aListOfProducts.isEmpty
  }

}
