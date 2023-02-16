package five.collection;

import five.connection.ConnectionPool;
import four.collection.Dao;
import three.jdbc.Customer;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements Dao<Product> {
    private String newUrl = URL;
    ConnectionPool connectionPool = ConnectionPool.getinstance();

    @Override
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        try(    Connection connection = connectionPool.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products");
                ResultSet resultSet = preparedStatement.executeQuery();)
        {while (resultSet.next()){
            Product product = new Product();
            product.setProductId(resultSet.getInt("product_id"));
            product.setName(resultSet.getString("name"));
            product.setQuantityInStock(resultSet.getInt("quantity_in_stock"));
            product.setUnitPrice(resultSet.getBigDecimal("unit_price"));
            productList.add(product);
        }
        connectionPool.releaseConnection(connection);

        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }

        return productList;
    }

    @Override

    public Product get(long primaryKey) {

        Product product = new Product();
        try{
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE product_id = ?;");
            preparedStatement.setLong(1, primaryKey);
            ResultSet resultSet = preparedStatement.executeQuery();
            connectionPool.releaseConnection(connection);

            if(resultSet.next()){
            product.setProductId(resultSet.getInt("product_id"));
            product.setName(resultSet.getString("name"));
            product.setQuantityInStock(resultSet.getInt("quantity_in_stock"));
            product.setUnitPrice(resultSet.getBigDecimal("unit_price"));}

        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return product;
    }

    @Override
    public void create(Product entity) {
        try
        {   Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = ConnectionPool.getinstance().getConnection().prepareStatement("INSERT INTO products VALUES(?,?,?,?);");
            preparedStatement.setString(2,entity.getName());
            preparedStatement.setInt(3, entity.getQuantityInStock());
            preparedStatement.setBigDecimal(4, entity.getUnitPrice());
            preparedStatement.setLong(1, entity.getProductId());
            preparedStatement.execute();


        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Product update(Product entity) {
        try
        {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE products SET name = 'Coca Cola' WHERE product_id = ?");
            preparedStatement.setLong(1, entity.getProductId());
            preparedStatement.execute();
            connectionPool.releaseConnection(connection);

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void delete(Product entity) {

    }


}
