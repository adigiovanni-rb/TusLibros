package TDD

import models.{Book, Catalog, IProduct, ShoppingCart}
import org.junit.Assert.assertThrows
import org.mockito.ArgumentMatchers.any
import org.scalatest.Matchers.assertThrows
import org.scalatestplus.play.PlaySpec

class tdd extends PlaySpec {
  "TusLibros system must have" must {
    val aCatalog = Catalog()
    val aItemValid: IProduct = Book(name = "Harry Potter")
    val anotherItemValid: IProduct = Book(name = "Señor de los Anillos")
    aCatalog.addValidItem(aItemValid)
    aCatalog.addValidItem(anotherItemValid)


    "Start shopping with an empty cart" in {
      val aEmptyShoppingCart = ShoppingCart()
      aEmptyShoppingCart.isEmpty() mustBe true
    }

    "Add a new item and the cart contain that" in {
      val aShoppingCart = ShoppingCart()
      aShoppingCart.addCatalog(aCatalog)
      aShoppingCart.add(aItemValid)
      aShoppingCart.contain(aItemValid) mustBe true
    }

    "Add two items and the cart contain that" in {
      val aShoppingCart = ShoppingCart()
      aShoppingCart.addCatalog(aCatalog)
      aShoppingCart.add(aItemValid)
      aShoppingCart.add(anotherItemValid)
      aShoppingCart.contain(aItemValid) && aShoppingCart.contain(anotherItemValid) mustBe true
    }

    "Add more than one item of the same product and the cart contains it" in {
      val aQuantity = 2
      val aItem: IProduct = Book(name = "Harry Potter")
      val aShoppingCart = ShoppingCart()
      aShoppingCart.addCatalog(aCatalog)
      aShoppingCart.addWithQuantity(aItem,aQuantity)
      aShoppingCart.countUniqueItem(aItem) mustBe aQuantity
    }

    "Add more than one item of the same product at different times and the cart contains it" in {
      val aQuantity = 2
      val aItem: IProduct = Book(name = "Harry Potter")
      val aShoppingCart = ShoppingCart()
      aShoppingCart.addCatalog(aCatalog)
      aShoppingCart.addWithQuantity(aItem,aQuantity)
      aShoppingCart.addWithQuantity(aItem,aQuantity)
      aShoppingCart.countUniqueItem(aItem) mustBe (aQuantity*2)
    }

    "I cannot add books that do not belong to the publisher" in {
      val aInvalidItem: IProduct = Book(name = "TU no vas")
      val aShoppingCart = ShoppingCart()
      aShoppingCart.addCatalog(aCatalog)
      val thrown = intercept[Exception] {
        aShoppingCart.add(aInvalidItem)
      }
      thrown.getMessage mustBe s"No existe item: ${aInvalidItem.name} en catalago"
 }





    /*

    los test que segun hay

6.
7. Sólo puedo agregar cantidades estrictamente positivas de libros


POR SUMAR

no se pueda hacer checkout de un carrito vacio
no se pueda hacer checkout de una tarjeta vencida
el cajero calcule el total a cobrar correctamente


     */




  }
}


