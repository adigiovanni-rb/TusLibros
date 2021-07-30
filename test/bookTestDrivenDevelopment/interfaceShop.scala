package bookTestDrivenDevelopment

import models._
import org.scalatestplus.play.PlaySpec
import controllers.BookController
import org.mockito.ArgumentMatchers.any
import play.api.mvc.ControllerComponents

import java.text.SimpleDateFormat
import java.util.Calendar

class interfaceShop extends PlaySpec {
  "TusLibros system must have" must {

    "carrito con password incorrecta" in {
      false mustBe true
    }

    "Client ID is not valid" in {

      val bookController = BookController(any[ControllerComponents])

      false mustBe true
    }

    "se puede crear un carrito vacio --discart " in {
      false mustBe true
    }

  }
}


