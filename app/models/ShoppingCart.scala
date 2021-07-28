package models

case class ShoppingCart() {

  private var aListOfProducts = List[IProduct]()
  private var aCatalog: Catalog = Catalog()

  def getListProducts(): List[IProduct] = aListOfProducts

  def addCatalog(catalog: Catalog): Unit ={
    aCatalog = catalog
  }

  def contain(item: IProduct):Boolean = {
    aListOfProducts.contains(item)
  }

  def add(aItem: IProduct) = {
    validateInCatalog(aItem)
    aListOfProducts = aListOfProducts :+ aItem
  }

  def addWithQuantity(aItem: IProduct, aQuantity: Int) = {

    validateQuantity(aQuantity)
    validateInCatalog(aItem)
    for (_ <- 1 to aQuantity) {
          aListOfProducts = aListOfProducts:+ aItem
    }
  }


  def validateQuantity(aQuantity: Int): Unit = {
    if(aQuantity<0) throw new Exception(s"Cantidad: $aQuantity no permitida")
  }

  def validateInCatalog(aItem: IProduct): Unit = {
    if(!aCatalog.checkInCatalog(aItem)) throw new Exception(s"No existe item: ${aItem.name} en catalago")
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
