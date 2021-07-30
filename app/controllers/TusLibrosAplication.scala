package controllers

import models.Client
import play.api.mvc._

import javax.inject._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class TusLibrosAplication @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  private val CLIENT_ID_IS_NOT_VALID = "Client ID is not valid"
  private val CLIENT_PASSWORD_IS_NOT_VALID = "Client password is not valid"


  val clients: Map(String, String)

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def createCart(clientId: String, password: String) = Action{
    val client = Client(clientId, password)
    validateClientID(client)
    validateClientPassword(client)
    Ok(views.html.index("Your new application is ready."))
  }

  private def validateClientID(client: Client): Unit = {
    if(!client.isValidID()) throw new Exception(CLIENT_ID_IS_NOT_VALID)
  }

  private def validateClientPassword(client: Client): Unit = {
    if(!client.isValidPassword()) throw new Exception(CLIENT_PASSWORD_IS_NOT_VALID)
  }

}
