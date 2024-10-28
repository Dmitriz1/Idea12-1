import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void shouldRemoveExistingProduct() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 100);
        repository.add(product1);

        repository.remove(1);

        Assertions.assertArrayEquals(new Product[0], repository.findAll());
    }

    @Test
    public void shouldThrowNotFoundExceptionWhenRemovingNonExistentProduct() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 100);
        repository.add(product1);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.remove(2);
        });
    }
}