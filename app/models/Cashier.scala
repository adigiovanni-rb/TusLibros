package models

import java.util.Date

case class Cashier(){

def processSale(shoppingCart: ShoppingCart,
                   creditCard: CreditCard,
                   date: Date,
                   merchantProcessorDummy: MerchantProcessorDummy): Boolean = {
  validateShoppingCart(shoppingCart)
  true
}

 def validateShoppingCart(shoppingCart: ShoppingCart): Unit = {
   if(shoppingCart.isEmpty) throw new Exception("Carro de compras vacio")
  }


}