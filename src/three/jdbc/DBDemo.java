package three.jdbc;

import java.sql.SQLException;
import java.util.List;

public class DBDemo {
    public static void main(String[] args) throws SQLException {

        CustomerSQLReader customerSQLReader = new CustomerSQLReader();
        List<Customer> customers = customerSQLReader.loadCustomers();
//        for(Customer customer : customers){
//            System.out.println(customer);
//        }
        customers.forEach ( customer -> System.out.println(customer));


    }
}
