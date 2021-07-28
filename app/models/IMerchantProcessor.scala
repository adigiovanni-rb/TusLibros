package models

trait IMerchantProcessor {
  def execute
}

case class MerchantProcessorDown() extends IMerchantProcessor {
  override def execute(): Unit = {
    throw new Exception("El servicio MerchantProcessor esta caido")
  }
}

case class MerchantProcessor() extends IMerchantProcessor {

  override def execute: Unit = ???


}
