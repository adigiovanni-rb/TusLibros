package models

case class ShoppingCart() {

private var aListOfProducts = List[IProduct]()
private var aCatalog: Catalog = Catalog()

  def addCatalog(catalog: Catalog): Unit ={
    aCatalog = catalog
  }

  def contain(item: IProduct):Boolean = {
    aListOfProducts.contains(item)
  }

  def add(aItem: IProduct) = {
      aCatalog.checkInCatalog(aItem) match {
        case true => aListOfProducts = aListOfProducts :+ aItem
        case false => throw new Exception(s"No existe item: ${aItem.name} en catalago")
    }
  }




  def addWithQuantity(aItem: IProduct, aQuantity: Int) = {

    aCatalog.checkInCatalog(aItem) match {
      case true => {
        for (_ <- 1 to aQuantity) {
          aListOfProducts = aListOfProducts:+ aItem
        }
      }
      case false => throw new Exception(s"No existe item: ${aItem.name} en catalago")
    }
      }

  def countUniqueItem(aItem: IProduct): Int = {
    aListOfProducts.filter(_.name.equals(aItem.name)).length
  }

  def checkItemInCart(aItem: IProduct): Boolean = {
    !aListOfProducts.find(_.name.equals(aItem.name)).isEmpty
  }

  def isEmpty() : Boolean = {
    aListOfProducts.isEmpty
  }

}
