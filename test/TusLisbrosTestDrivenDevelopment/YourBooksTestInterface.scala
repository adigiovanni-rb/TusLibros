package TusLisbrosTestDrivenDevelopment

import models._
import org.scalatestplus.play.PlaySpec
import controllers.YourBooksApp
import org.mockito.ArgumentMatchers.any
import play.api.mvc.ControllerComponents

import java.text.SimpleDateFormat
import java.util.Calendar

class YourBooksTestInterface extends PlaySpec {

  private val CLIENT_ID_IS_NOT_VALID = "Client ID is not valid"

  "TusLibros system must have" must {
    val yourBooksFactory = new YourBooksFactory()
    val yourBooksApp = new YourBooksApp(any[ControllerComponents], yourBooksFactory.getClients())



    "Client ID is not valid" in {
      val clientIDNotValid = "notValidID"
      val passwordValid = "validPassword"
      val thrown = intercept[Exception] {
        yourBooksApp.createCart(clientIDNotValid, passwordValid)
      }
      thrown.getMessage mustBe CLIENT_ID_IS_NOT_VALID
    }

    "Client Password is not valid" in {
      val clientIDValid = "validID"
      val passwordNotValid = "notValidPassword"
      val thrown = intercept[Exception] {
        yourBooksApp.createCart(clientIDValid, passwordNotValid)
      }
      thrown.getMessage mustBe CLIENT_ID_IS_NOT_VALID
    }

    "se puede crear un carrito vacio --discart " in {
      false mustBe true
    }
  }
}


