package tus_libros;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.List;

public class TestObjectsFactory {
    public TestObjectsFactory() {
    }

    Cart emptyCart() {
        return new Cart(catalog());
    }

    List<Object> catalog() {
        return Arrays.asList(validProduct(), anotherValidProduct());
    }

    String validProduct() {
        return "valid product";
    }

    String anotherValidProduct() {
        return "another valid product";
    }

    String invalidProduct() {
        return "invalid product";
    }

    void assertThrowsRuntimeException(Executable aBlock, String message) {
        Exception exception = Assertions.assertThrows(RuntimeException.class, aBlock, message);
        Assertions.assertEquals(message, exception.getMessage());
    }
}