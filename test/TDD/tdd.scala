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



    /*

    los test que segun hay
    1. Comienzo shopping con carrito vacío
2. Agrego un libro y el carrito lo contiene
3. Agrego 2 o más libros diferentes y los contiene


4. Agrego más de 1 ejemplar al mismo y los contiene
5. Agrego un libro más de una vez y los contiene
6. No puedo agregar libros que no pertenecen a la editorial
7. Sólo puedo agregar cantidades estrictamente positivas de libros


POR SUMAR

no se pueda hacer checkout de un carrito vacio
no se pueda hacer checkout de una tarjeta vencida
el cajero calcule el total a cobrar correctamente


     */




  }
}


