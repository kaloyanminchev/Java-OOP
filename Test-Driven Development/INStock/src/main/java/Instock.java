import jdk.jshell.spi.ExecutionControl;

import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {
    private Map<String, Product> products;

    public Instock() {
        this.products = new LinkedHashMap<>();
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public void add(Product product) {
        this.products.put(product.getLabel(), product);
    }

    @Override
    public boolean contains(Product product) {
        return this.products.containsKey(product.getLabel());
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        if (!this.products.containsKey(product)) {
            throw new IllegalArgumentException();
        }
        this.products.get(product).setQuantity(quantity);
    }

    @Override
    public Product find(int index) {
        return this.products
                .entrySet()
                .stream()
                .skip(index)
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(IndexOutOfBoundsException::new);
    }

    @Override
    public Product findByLabel(String label) {
        if (!this.products.containsKey(label)) {
            throw new IllegalArgumentException();
        }
        return this.products.get(label);
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        Iterable<Product> foundProducts = null;
        if (count <= this.products.size()) {
            foundProducts = this.products
                    .values()
                    .stream()
                    .sorted(Product::compareTo)
                    .limit(count)
                    .collect(Collectors.toList());
        }
        return foundProducts == null ? new ArrayList<>() : foundProducts;
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<Product> iterator() {
        throw new UnsupportedOperationException();
    }
}
