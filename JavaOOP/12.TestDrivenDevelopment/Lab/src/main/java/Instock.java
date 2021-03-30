import jdk.jshell.spi.ExecutionControl;

import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    private Map<String, Product> products;

    public Instock() {
        this.products = new LinkedHashMap<>();
    }

    @Override
    public Integer getCount() {
        return this.products.size();
    }

    @Override
    public Boolean contains(Product product) {
        for (String s : products.keySet()) {
            if (s.equals(product.getLabel())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Product product) {
        this.products.put(product.getLabel(), product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        if (!products.containsKey(product)) {
            throw new IllegalArgumentException();
        }
        products.get(product).setQuantity(quantity);
    }

    @Override
    public Product find(int index) {
        if (index < 0 || index >= products.size()) {
            throw new IndexOutOfBoundsException();
        }
        Product productToReturn = null;
        int count = 1;
        for (String searchingProduct : products.keySet()) {
            if (count == index) {
                productToReturn = products.get(searchingProduct);
                break;
            }
            count++;
        }
        return productToReturn;
    }

    @Override
    public Product findByLabel(String label) {
        if (!products.containsKey(label)) {
            throw new IllegalArgumentException();
        }
        Product productToReturned = null;
        for (Map.Entry<String, Product> product : products.entrySet()) {
            if (label.equals(product.getKey())) {
                productToReturned = product.getValue();
                break;
            }
        }
        return productToReturned;
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count < 1 || count > products.size()) {
            return new ArrayList<>();
        } else {
            return products.values().stream()
                    .sorted((p1, p2) -> p1.getLabel().compareTo(p2.getLabel()))
                    .limit(count)
                    .collect(Collectors.toList());
        }
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
