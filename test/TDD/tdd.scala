package TDD

import models.{Book, IProduct, ShoppingCart}
import org.scalatestplus.play.PlaySpec

class tdd extends PlaySpec {
  "TusLibros system must have" must {

    "Start shopping with an empty cart" in {
      val aShoppingCart = ShoppingCart(List())
      aShoppingCart.isEmpty() mustBe true
    }

    "Add a new item and the cart contain that" in {
      val aItem: IProduct = Book(name = "Harry Potter")
      val books = List(aItem)
      val aShoppingCart = ShoppingCart(books)

//      aShoppingCart.add(aItem)
      aShoppingCart.contain(aItem) mustBe true
    }

    "Add two items and the cart contain that" in {
      val aItem: IProduct = Book(name = "Harry Potter")
      val aItem2: IProduct = Book(name = "Señor de los Anillos")
      val books = List(aItem, aItem2)
      val aShoppingCart = ShoppingCart(books)

      aShoppingCart.contain(aItem) && aShoppingCart.contain(aItem2) mustBe true
    }

    "Agrego más de 1 ejemplar al mismo y los contiene" in {
      val amount = 2
      val aItem: IProduct = Book(name = "Harry Potter", amount = amount)
      val books = List(aItem)

      val aShoppingCart = ShoppingCart(books)

      aShoppingCart.add(aItem)
      aShoppingCart.alistOfProducts.head.amount mustBe amount
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



     */




  }
}


