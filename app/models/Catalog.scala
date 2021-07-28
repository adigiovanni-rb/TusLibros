package models

case class Catalog() {

  private var aListOfProductsInCatalog = List[IProduct]()

  def getList: List[IProduct] = {
    aListOfProductsInCatalog
  }

  def checkInCatalog(aItem: IProduct): Boolean = {
    !aListOfProductsInCatalog.find(_.name.equals(aItem.name)).isEmpty
  }

  def addValidItem(aItem: IProduct)= {
    aListOfProductsInCatalog = aListOfProductsInCatalog:+ aItem
  }

}