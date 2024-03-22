import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void shouldAllProductsAdded() {
        Product product1 = new Product(1, "Хлеб", 100);
        Product product2 = new Product(3, "Молоко", 150);
        ShopRepository shop = new ShopRepository();
        shop.add(product1);
        shop.add(product2);
        Product[] expected = {product1, product2};
        Product[] actual = shop.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        Product product1 = new Product(1, "Хлеб", 100);
        Product product2 = new Product(3, "Молоко", 150);
        ShopRepository shop = new ShopRepository();
        shop.add(product1);
        shop.add(product2);
        shop.findById(3);
        Product[] expected = {product2};
        Product[] actual = shop.findAll();

    }


    @Test
    public void shouldRemoveByNonExistentId() {
        Product product1 = new Product(1, "Хлеб", 100);
        Product product2 = new Product(3, "Молоко", 150);
        ShopRepository shop = new ShopRepository();
        shop.add(product1);
        shop.add(product2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            shop.remove(100);
        });

    }

    @Test
    public void shouldRemoveById() {
        Product product1 = new Product(1, "Хлеб", 100);
        Product product2 = new Product(3, "Молоко", 150);
        ShopRepository shop = new ShopRepository();
        shop.add(product1);
        shop.add(product2);
        shop.remove(3);
        Product[] expected = {product1};
        Product[] actual = shop.findAll();
    }
}
