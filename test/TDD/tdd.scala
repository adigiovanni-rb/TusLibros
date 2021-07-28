package TDD

import models.{Book, Cashier, Catalog, CreditCard, IProduct, MerchantProcessor, MerchantProcessorDown, ShoppingCart}
import org.scalatestplus.play.PlaySpec

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.{Calendar, Date}

class tdd extends PlaySpec {
  "TusLibros system must have" must {
    val aCatalog = Catalog()
    val aValidItem: IProduct = Book(name = "Harry Potter", price = BigDecimal(250.0))
    val anotherValidItem: IProduct = Book(name = "Señor de los Anillos", price = BigDecimal(500.0))
    aCatalog.addValidItem(aValidItem)
    aCatalog.addValidItem(anotherValidItem)
    val merchantProcessor = MerchantProcessor()
    val formatDate = new SimpleDateFormat("yyyy-MM-dd")
    val validDueDate = formatDate.parse("2025-01-12")
    val creditCard = CreditCard(validDueDate)
    val calendar = Calendar.getInstance()

    "Start shopping with an empty cart" in {
      val aEmptyShoppingCart = ShoppingCart()
      aEmptyShoppingCart.isEmpty() mustBe true
    }

    "Add a new item and the cart contain that" in {
      val aShoppingCart = ShoppingCart()
      aShoppingCart.addCatalog(aCatalog)
      aShoppingCart.add(aValidItem)
      aShoppingCart.contain(aValidItem) mustBe true
    }

    "Add two items and the cart contain that" in {
      val aShoppingCart = ShoppingCart()
      aShoppingCart.addCatalog(aCatalog)
      aShoppingCart.add(aValidItem)
      aShoppingCart.add(anotherValidItem)
      aShoppingCart.contain(aValidItem) && aShoppingCart.contain(anotherValidItem) mustBe true
    }

    "Add more than one item of the same product and the cart contains it" in {
      val aQuantity = 2
      val aShoppingCart = ShoppingCart()
      aShoppingCart.addCatalog(aCatalog)
      aShoppingCart.addWithQuantity(aValidItem,aQuantity)
      aShoppingCart.countUniqueItem(aValidItem) mustBe aQuantity
    }

    "Add more than one item of the same product at different times and the cart contains it" in {
      val aQuantity = 2
      val aShoppingCart = ShoppingCart()
      aShoppingCart.addCatalog(aCatalog)
      aShoppingCart.addWithQuantity(aValidItem,aQuantity)
      aShoppingCart.addWithQuantity(aValidItem,aQuantity)
      aShoppingCart.countUniqueItem(aValidItem) mustBe (aQuantity*2)
    }

    "I cannot add books that do not belong to the publisher" in {
      val aInvalidItem: IProduct = Book(name = "TU no vas", price = BigDecimal(300.00))
      val aShoppingCart = ShoppingCart()
      aShoppingCart.addCatalog(aCatalog)
      val thrown = intercept[Exception] {
        aShoppingCart.add(aInvalidItem)
      }
      thrown.getMessage mustBe s"No existe item: ${aInvalidItem.name} en catalago"
 }

    "I can only add strictly positive amounts of books" in {
      val aQuantity = -1
      val aShoppingCart = ShoppingCart()
      aShoppingCart.addCatalog(aCatalog)
      val thrown = intercept[Exception] {
        aShoppingCart.addWithQuantity(aValidItem, aQuantity)
      }
      thrown.getMessage mustBe s"Cantidad: $aQuantity no permitida"
    }

    "An empty cart cannot be checked out"in {
        val aEmptyShoppingCart = ShoppingCart()
        val cashier = Cashier(aEmptyShoppingCart, creditCard, calendar.getTime, merchantProcessor)
        val thrown = intercept[Exception] {
              cashier.checkout()
          }
        thrown.getMessage mustBe "Carro de compras vacio"
    }

    "no se pueda hacer checkout de una tarjeta vencida"in {
      val aShoppingCart = ShoppingCart()
      aShoppingCart.addCatalog(aCatalog)
      aShoppingCart.add(aValidItem)

      val invalidDueDate = formatDate.parse("2021-06-28")
      val invalidCreditCard = creditCard.copy(dueDate = invalidDueDate)

      val cashier = Cashier(aShoppingCart, invalidCreditCard, calendar.getTime, merchantProcessor)

      val thrown = intercept[Exception] {
        cashier.checkout()
      }
      thrown.getMessage mustBe "Tarjeta de crédito vencida."
    }

    "el cajero calcule el total a cobrar correctamente"in {
      val aShoppingCart = ShoppingCart()
      aShoppingCart.addCatalog(aCatalog)
      aShoppingCart.add(anotherValidItem)
      aShoppingCart.addWithQuantity(aValidItem,2)

      val cashier = Cashier(aShoppingCart, creditCard, calendar.getTime, merchantProcessor)

      cashier.checkTotalPrice(aShoppingCart) mustBe BigDecimal(1000.0)
    }

    "no se puede hacer checkout con el merchanse procesor caido"in {
      val merchantProcessorDown = MerchantProcessorDown()
      val aShoppingCart = ShoppingCart()
      aShoppingCart.addCatalog(aCatalog)
      aShoppingCart.add(anotherValidItem)
      aShoppingCart.addWithQuantity(aValidItem,2)
      val cashier = Cashier(aShoppingCart, creditCard, calendar.getTime, merchantProcessorDown)

      val thrown = intercept[Exception] {
        cashier.checkout()
      }
      thrown.getMessage mustBe "El servicio MerchantProcessor esta caido"
    }

    "no se puede implementar con tarjeta robada" in {
      true mustBe false
    }

    "merchan proccesor recibe todo correctamenet" in {
      true mustBe false
    }




  }
}


