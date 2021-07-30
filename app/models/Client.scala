package models

case class Client(clientId: String, password: String) {

  /*
  Esto seria lo que me devlveria la DB
   */
  val clientIDinBD = "validID"
  val clientPasswordinBD = "validPassword"
   /*
  Estos dos metodos deberian ser del repositorio, es decir que crearia el objeto cliente y lo validaria
   */
  def isValidID(): Boolean = clientId.equals(clientIDinBD)

  def isValidPassword(): Boolean = password.equals(clientPasswordinBD)

}
