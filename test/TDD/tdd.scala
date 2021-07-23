package TDD

import models.{Book, IProduct, ShoppingCar}
import org.scalatestplus.play.PlaySpec

class tdd extends PlaySpec {
  "TusLibros system must have" must {

    "Start shopping with an empty car" in {
      val shoppingCar = ShoppingCar()
      shoppingCar.isEmpty() mustBe true
    }

    "Add a new item and the car contain that" in {
      val shoppingCar = ShoppingCar()
      val item: IProduct = Book(name = "Harry Potter")
      shoppingCar.add(item)
      shoppingCar.contain(item) mustBe true
    }

  }
}


