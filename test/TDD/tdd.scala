package TDD

import models.{Book, IProduct, ShoppingCart}
import org.scalatestplus.play.PlaySpec

class tdd extends PlaySpec {
  "TusLibros system must have" must {

    "Start shopping with an empty cart" in {
      val aShoppingCart = ShoppingCart()
      aShoppingCart.isEmpty() mustBe true
    }

    "Add a new item and the cart contain that" in {
      val aItem: IProduct = Book(name = "Harry Potter")
      val aShoppingCart = ShoppingCart()
      aShoppingCart.add(aItem)
      aShoppingCart.contain(aItem) mustBe true
    }

    "Add two items and the cart contain that" in {
      val aItem: IProduct = Book(name = "Harry Potter")
      val aItem2: IProduct = Book(name = "Señor de los Anillos")
      val aShoppingCart = ShoppingCart()
      aShoppingCart.add(aItem)
      aShoppingCart.add(aItem2)
      aShoppingCart.contain(aItem) && aShoppingCart.contain(aItem2) mustBe true
    }

    "Add more than one item of the same product and the cart contains it" in {
      val aQuantity = 2
      val aItem: IProduct = Book(name = "Harry Potter")
      val aShoppingCart = ShoppingCart()
      aShoppingCart.addWithQuantity(aItem,aQuantity)
      aShoppingCart.countUniqueItem(aItem) mustBe aQuantity
    }

    "Add more than one item of the same product at different times and the cart contains it" in {
      val aQuantity = 2
      val aItem: IProduct = Book(name = "Harry Potter")
      val aShoppingCart = ShoppingCart()
      aShoppingCart.addWithQuantity(aItem,aQuantity)
      aShoppingCart.addWithQuantity(aItem,aQuantity)
      aShoppingCart.countUniqueItem(aItem) mustBe (aQuantity*2)
    }

    /*

    los test que segun hay

6. No puedo agregar libros que no pertenecen a la editorial
7. Sólo puedo agregar cantidades estrictamente positivas de libros


POR SUMAR

no se pueda hacer checkout de un carrito vacio
no se pueda hacer checkout de una tarjeta vencida
el cajero calcule el total a cobrar correctamente


     */




  }
}


