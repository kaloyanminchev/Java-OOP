import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InstockTest {

    private static final String[] LABELS = {"A", "B", "C", "D", "E"};

    private static final Product PRODUCT = new Product("Cosmos", 3.14, 42);
    private Instock instock;


    @Before
    public void setUp() {
        this.instock = new Instock();
    }

    @Test
    public void instockGetCountShouldReturnZeroOnEmptyInstock() {
        int count = this.instock.getCount();
        assertEquals(0, count);
    }

    @Test
    public void addingProductShouldIncreaseCount() {
        this.instock.add(PRODUCT);
        assertEquals(1, this.instock.getCount());
    }

    @Test
    public void containsShouldReturnTrueWhenProductIsPresent() {
        this.instock.add(PRODUCT);
        assertTrue(this.instock.contains(PRODUCT));
    }

    @Test
    public void containsShouldReturnFalseWhenProductIsAbsent() {
        assertFalse(this.instock.contains(PRODUCT));
    }

    @Test
    public void findShouldReturnCorrectProductAccordingToInsertionOrder() {
        fillWithProducts();
        int order = LABELS.length / 2;
        Product returnedProduct = this.instock.find(order);
        assertEquals(LABELS[order], returnedProduct.getLabel());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void findWithInvalidIndexShouldThrowException() {
        fillWithProducts();
        this.instock.find(LABELS.length);
    }

    private void fillWithProducts() {
        for (int i = 0; i < LABELS.length; i++) {
            this.instock.add(new Product(LABELS[i], 12, i));
        }
    }

    @Test
    public void shouldChangeQuantityOfProductWithGivenAmountWhenProductIsPresent() {
        this.instock.add(PRODUCT);
        this.instock.changeQuantity(PRODUCT.getLabel(), 20);

        assertEquals(20, PRODUCT.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenProductIsAbsent() {
        this.instock.add(PRODUCT);
        this.instock.changeQuantity(PRODUCT.getLabel() + "123", 20);
    }

    @Test
    public void shouldReturnProductIfPresent() {
        this.instock.add(PRODUCT);
        Product testProduct = this.instock.findByLabel(PRODUCT.getLabel());

        assertEquals(PRODUCT, testProduct);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfProductIsAbsent() {
        this.instock.add(PRODUCT);
        this.instock.findByLabel(PRODUCT.getLabel() + "123");
    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnEmptyCollectionWithOutOfRangeArgument() {
        fillWithProducts();
        Iterable<Product> products
                = this.instock.findFirstByAlphabeticalOrder(LABELS.length + 1);

        int count = 0;
        for (Product product : products) {
            count++;
        }

        assertEquals(0, count);
    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnCorrectCountOfProducts() {
        fillWithProducts();
        Iterable<Product> products
                = this.instock.findFirstByAlphabeticalOrder(LABELS.length);
        int count = 0;
        for (Product product : products) {
            count++;
        }

        assertEquals(LABELS.length, count);
    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnCorrectCountOfProductsWhenCountIsLessThanSize() {
        fillWithProducts();
        int count = LABELS.length / 2;

        Iterable<Product> products
                = this.instock.findFirstByAlphabeticalOrder(count);

        int counter = 0;
        for (Product product : products) {
            counter++;
        }

        assertEquals(count, counter);
    }

}