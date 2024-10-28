import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    private ShopRepository repository;

    @BeforeEach
    void setUp() {
        repository = new ShopRepository();

        Product product1 = new Product(1, "Product 1", 100);
        Product product2 = new Product(2, "Product 2", 200);

        repository.add(product1);
        repository.add(product2);

    }


    @Test
    void testRemoveExistingProduct() {
        repository.remove(1);
        assertNull(repository.findById(1));
        assertNotNull(repository.findById(2));
    }


    @Test
    void testRemoveNonExistentProduct() {


        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            repository.remove(3);
        });
        assertEquals("Element with id: 3 not found", exception.getMessage());

    }
}