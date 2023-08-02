import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository shopRepository = new ShopRepository();
    Product product1 = new Product(1, "Картина", 5_000);
    Product product2 = new Product(2, "Корзина", 2_000);
    Product product3 = new Product(3, "Картонка", 100);
    Product product4 = new Product(4, "Маленькая собачонка", 50_000);


    @BeforeEach
    public void setup() {

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        shopRepository.add(product4);

    }

    @Test
    public void shouldRemoveProductById() {
        shopRepository.remove(4);
        Product[] expected = {product1, product2, product3};
        Product[] actual = shopRepository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveProductNotFoundId() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.remove(5);
        });
    }
}