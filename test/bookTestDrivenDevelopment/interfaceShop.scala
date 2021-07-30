package bookTestDrivenDevelopment

import models._
import org.scalatestplus.play.PlaySpec
import controllers.TusLibrosAplication
import org.mockito.ArgumentMatchers.any
import play.api.mvc.ControllerComponents

import java.text.SimpleDateFormat
import java.util.Calendar

class interfaceShop extends PlaySpec {

  private val CLIENT_ID_IS_NOT_VALID = "Client ID is not valid"

  "TusLibros system must have" must {
    val tusLibrosAplication = new TusLibrosAplication(factory.clients())



    "Client ID is not valid" in {
      val clientIDNotValid = "notValidID"
      val passwordValid = "validPassword"
      val thrown = intercept[Exception] {
        tusLibrosAplication.createCart(clientIDNotValid, passwordValid)
      }
      thrown.getMessage mustBe CLIENT_ID_IS_NOT_VALID
    }

    "Client Password is not valid" in {
      val clientIDValid = "validID"
      val passwordNotValid = "notValidPassword"
      val thrown = intercept[Exception] {
        tusLibrosAplication.createCart(clientIDValid, passwordNotValid)
      }
      thrown.getMessage mustBe CLIENT_ID_IS_NOT_VALID
    }

    "se puede crear un carrito vacio --discart " in {
      false mustBe true
    }
  }
}


