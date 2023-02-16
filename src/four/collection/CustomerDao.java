package four.collection;

import three.jdbc.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements Dao<Customer> {

    @Override
    public List<Customer> getAll() {
        List<Customer> customerList = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers;");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getInt("customer_id"));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setLastName(resultSet.getString("last_name"));
                customer.setAddress(resultSet.getString("address"));
                customer.setCity(resultSet.getString("city"));
                customer.setState(resultSet.getString("state"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setPoints(resultSet.getInt("points"));
//            String[] birthValues = resultSet.getString("birth_date").split("-");
//            customer.setBirthdate(LocalDate.of(Integer.parseInt(birthValues[0]), Integer.parseInt(birthValues[1]), Integer.parseInt(birthValues[2])));
                customer.setBirthdate(resultSet.getDate("birth_date").toLocalDate());

                customerList.add(customer);
            }
       }
        catch (SQLException e){
            System.out.println("Failed connection");
        }
        return customerList;
    }

    @Override
    public Customer get(long primaryKey) {
        Customer customer = new Customer();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);)
        {
            PreparedStatement statement = connection.prepareStatement("Select * FROM customers WHERE customer_id =?");
            statement.setLong(1, primaryKey);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                customer.setCustomerId(resultSet.getInt("customer_id"));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setLastName(resultSet.getString("last_name"));
                customer.setAddress(resultSet.getString("address"));
                customer.setCity(resultSet.getString("city"));
                customer.setState(resultSet.getString("state"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setPoints(resultSet.getInt("points"));
//            String[] birthValues = resultSet.getString("birth_date").split("-");
//            customer.setBirthdate(LocalDate.of(Integer.parseInt(birthValues[0]), Integer.parseInt(birthValues[1]), Integer.parseInt(birthValues[2])));
                customer.setBirthdate(resultSet.getDate("birth_date").toLocalDate());
            }
        }
        catch (SQLException e){
            System.out.println("Failed Connection");
        }
        return customer;
    }

    @Override
    public void create(Customer entity) {

    }

    @Override
    public Customer update(Customer entity) {
        return null;
    }

    @Override
    public void delete(Customer entity) {

    }
}
