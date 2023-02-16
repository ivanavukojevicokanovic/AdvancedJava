package five.collection;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Productdemo {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
//        System.out.println(productDao.getAll());
        List<Product> productList = new ArrayList<>();
        productList = productDao.getAll();
        productList.stream().filter(product -> product.getQuantityInStock() > 20 ).forEach(product -> System.out.println(product));
//                System.out.println(productDao.get(5));
//                Product product = new Product();
//                product.setName("Cokolada");
//                product.setQuantityInStock(8);
//                product.setUnitPrice(BigDecimal.valueOf(15.3));
//                product.setProductId(13);
//                productDao.create(product);
//                Product productNew = new Product();
//                productNew.setProductId(12);
//                productDao.update(productNew);



    }
}
