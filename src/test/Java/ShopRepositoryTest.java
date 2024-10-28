import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    void shouldRemoveExistingProduct() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 100);
        Product product2 = new Product(2, "Product 2", 200);
        repository.add(product1);
        repository.add(product2);

        repository.remove(1);

        Product[] products = repository.findAll();
        assertEquals(1, products.length);
        assertEquals(product2, products[0]);
    }

    @Test
    void shouldThrowNotFoundExceptionWhenRemovingNonExistentProduct() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 100);
        repository.add(product1);

        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            repository.remove(2);
        });

        assertEquals("Element with id: 2 not found", exception.getMessage());
    }
}