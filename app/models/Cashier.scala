package models

import java.util.Date

case class Cashier(
  shoppingCart: ShoppingCart,
  creditCard: CreditCard,
  date: Date,
  merchantProcessor: IMerchantProcessor){

  def checkout(): Boolean = {
    validateShoppingCart(shoppingCart)
    validateCreditCard(creditCard, date)
    true
  }

  def checkTotalPrice(shoppingCart: ShoppingCart): BigDecimal = {
    var total: BigDecimal = BigDecimal(0)

    var value = shoppingCart
      .getListProducts()
      .map(x => total.+(x.price))
      .reduce(_ + _)

    value
  }

  protected def validateShoppingCart(shoppingCart: ShoppingCart): Unit = {
    if(shoppingCart.isEmpty) throw new Exception("Carro de compras vacio")
  }

  protected def validateCreditCard(creditCard: CreditCard, date: Date): Unit = {
     if(creditCard.dueDate.before(date)) throw new Exception("Tarjeta de crédito vencida.")
  }

}