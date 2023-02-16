package four.collection;

import three.jdbc.Customer;

import java.util.List;

public class CustomerDemo {
    public static void main(String[] args) {
       CustomerDao customerDao = new CustomerDao();
       Customer customer = customerDao.get(5);
       System.out.println(customer);
       List<Customer> customerList = customerDao.getAll();
       customerList.stream().forEach(customer1-> System.out.println(customer1));
    }
}

