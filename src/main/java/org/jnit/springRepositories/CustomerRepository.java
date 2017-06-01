package org.jnit.springRepositories;

import java.util.List;

import org.jnit.springDataEntities.Customers;

public interface CustomerRepository extends Repo<Customers> {
	
	public  Customers findUsingInlineById(int customerId); 
	
	public String findNameById(int customerId);

	public Customers findRowById(int customerId);

	public List<Customers> findCustomersByCity(String city);
	
	public List<Customers> findOrdersFromCustomers(int customerId);

}
