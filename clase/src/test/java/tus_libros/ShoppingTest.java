package tus_libros;

/*
 * Developed by 10Pines SRL
 * License:
 * This work is licensed under the
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-sa/3.0/
 * or send a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View,
 * California, 94041, USA.
 *
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static tus_libros.Cart.PRODUCT_MUST_BE_SOLD_BY_PUBLISHER;
import static tus_libros.Cart.QUANTITY_MUST_BE_STRICTLY_POSITIVE;

class ShoppingTest {

	private final TestObjectsFactory factory = new TestObjectsFactory();

	@Test
	 void mustBeginWithEmptyCart() {
		Cart cart = factory.emptyCart();
		
		assertTrue(cart.isEmpty());
	}
	
	@Test
	void cartContainsAddedProduct() {
		Cart cart = factory.emptyCart();
		
		cart.add(factory.validProduct());
		
		assertFalse(cart.isEmpty());
		assertTrue(cart.contains(factory.validProduct()));
	}
	
	@Test
	void canAddMoreThanOneItemOfSameProductsAtTheSameTime() {
		Cart cart = factory.emptyCart();
		
		cart.addWithQuantity(factory.validProduct(), 2);
		
		assertFalse(cart.isEmpty());
		assertEquals(2, cart.count(factory.validProduct()));
	}
	
	@Test
	void cartCanContainManyProducts() {
		Cart cart = factory.emptyCart();
		
		cart.addWithQuantity(factory.validProduct(), 2);
		cart.addWithQuantity(factory.validProduct(), 3);
		
		assertFalse(cart.isEmpty());
		assertEquals(5, cart.count(factory.validProduct()));
	}
	
	@Test
	void canAddManyDifferentProductsAtTheSameTime() {
		Cart cart = factory.emptyCart();
		
		cart.addWithQuantity(factory.validProduct(), 2);
		cart.addWithQuantity(factory.anotherValidProduct(), 3);
		
		assertFalse(cart.isEmpty());
		assertEquals(2, cart.count(factory.validProduct()));
		assertEquals(3, cart.count(factory.anotherValidProduct()));
		assertEquals(5, cart.size());
	}
	
	@Test
	void quantityToAddMustBeStrictlyPositive() {
		Cart cart = factory.emptyCart();

		factory.assertThrowsRuntimeException(() -> cart.addWithQuantity(factory.validProduct(), 0),
				QUANTITY_MUST_BE_STRICTLY_POSITIVE);
	}

	@Test
	void productToAddMustBeSellByPublisher() {
		Cart cart = factory.emptyCart();

		factory.assertThrowsRuntimeException(() -> cart.addWithQuantity(factory.invalidProduct(), 1),
				PRODUCT_MUST_BE_SOLD_BY_PUBLISHER);
	}

}
