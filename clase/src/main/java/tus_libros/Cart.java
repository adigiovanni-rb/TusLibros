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

import java.util.ArrayList;
import java.util.List;

public class Cart {

	public static final String QUANTITY_MUST_BE_STRICTLY_POSITIVE = "Quantity must be strictly positive";
	public static final String PRODUCT_MUST_BE_SOLD_BY_PUBLISHER = "Product must be sold by publisher";
	private final List<Object> catalog;

	private List<Object> products = new ArrayList();

	public Cart(List<Object> aCatalog) {
		catalog = aCatalog;
	}

	public boolean isEmpty() {
		return products.isEmpty();
	}

	public boolean contains(String aProduct) {
		return products.contains(aProduct);
	}

	public void addWithQuantity(String aProduct, int aQuantity) {
		assertValidQuantity(aQuantity);
		assertValidProduct(aProduct);

		for(int i = 1; i <= aQuantity; i++) {
			products.add(aProduct);
		}
		
	}

	private void assertValidProduct(String aProduct) {
		if(!catalog.contains(aProduct)) {
			throw new RuntimeException(PRODUCT_MUST_BE_SOLD_BY_PUBLISHER);
		}
	}

	private void assertValidQuantity(int aQuantity) {
		if(aQuantity <= 0) {
			throw new RuntimeException(QUANTITY_MUST_BE_STRICTLY_POSITIVE);
		}
	}

	public void add(String aProduct) {
		addWithQuantity(aProduct, 1);
		
	}

	public Long count(String aProduct) {
		return products.stream().filter(product -> product.equals(aProduct) ).count();
	}

	public Integer size() {
		return products.size();
	}

}