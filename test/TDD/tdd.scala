package TDD

import models.{Book, IProduct, ShoppingCar}
import org.scalatestplus.play.PlaySpec

class tdd extends PlaySpec {
  "TusLibros system must have" must {

    "Start shopping with an empty car" in {
      val aShoppingCar = ShoppingCar()
      aShoppingCar.isEmpty() mustBe true
    }

    "Add a new item and the car contain that" in {
      val aShoppingCar = ShoppingCar()
      val aItem: IProduct = Book(name = "Harry Potter")
      aShoppingCar.add(aItem)
      aShoppingCar.contain(aItem) mustBe true
    }

    "Add two items and the car contain that" in {
      val aShoppingCar = ShoppingCar()
      val aItem: IProduct = Book(name = "Harry Potter")
      val aItem2: IProduct = Book(name = "Señor de los Anillos")
      aShoppingCar.add(aItem)
      aShoppingCar.add(aItem2)
      aShoppingCar.contain(aItem) && aShoppingCar.contain(aItem2) mustBe true
    }

    "Agrego más de 1 ejemplar al mismo y los contiene" in {
      val aShoppingCar = ShoppingCar()
      val aItem: IProduct = Book(name = "Harry Potter")
      aItem.amount = 2
      aShoppingCar.add(aItem)
      aShoppingCar.find(aItem).amount = 2 mustBe true
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


