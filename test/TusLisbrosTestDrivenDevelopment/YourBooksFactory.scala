package TusLisbrosTestDrivenDevelopment

case class YourBooksFactory() {

  def getClients(): Map[String, String] = {
    val clientIDInBD = "validID"
    val clientPasswordInBD = "validPassword"
    val mapClients = Map[String, String]()
    mapClients + (clientIDInBD -> clientPasswordInBD)
  }
}
