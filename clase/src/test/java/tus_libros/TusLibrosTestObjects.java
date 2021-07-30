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

import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TusLibrosTestObjects {
	
	public Cart emptyCart() {
		return new Cart(catalog());
	}

	public Map<String, Double> catalog() {
		Map<String, Double> aMap = new Hashtable();
		aMap.put(validProduct(), validProductPrice());
		aMap.put(anotherValidProduct(), anotherValidProductPrice());
		return aMap;
	}

	public Double anotherValidProductPrice() {
		return 20.0;
	}

	public String validProduct() {
		return "valid product";
	}
	
	public String anotherValidProduct() {
		return "another valid product";
	}

	public String invalidProduct() {
		return "invalid prodict";
	}

	public double validProductPrice() {
		return 10.0;
	}

	public List<Object> emptySalesBook() {
		return new ArrayList();
	}

	public CreditCard expiredCreditCard() {
		return new CreditCard(YearMonth.from(now().minusMonths(1)));
	}

	public LocalDate now() {
		return LocalDate.now();
	}

	public CreditCard notExpiredCreditCard() {
		return new CreditCard(YearMonth.from(now().plusMonths(1)));
	}

    public MerchantProcessor merchantProcessorDummy() {
		return new MerchantProcessorDummy();
    }

	void assertThrowsRuntimeException(Executable aBlock, String message) {
		Exception exception = assertThrows(RuntimeException.class, aBlock, message);
		assertEquals(message, exception.getMessage());
	}
}
