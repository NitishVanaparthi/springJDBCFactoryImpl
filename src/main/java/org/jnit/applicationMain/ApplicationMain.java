package org.jnit.applicationMain;

import java.util.List;

import org.jnit.springDataEntities.Customers;
import org.jnit.springRepositories.CustomerRepository;
import org.jnit.springRepositories.CustomerRepositoyImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationMain {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		CustomerRepository custRepo = context.getBean(CustomerRepositoyImpl.class);
		// System.out.println(custRepo.findNameById(411));
		// ((ClassPathXmlApplicationContext) context).close();
		// System.out.println(custRepo.findRowById(411).getCity());

		// List<Customers> customers =
		// custRepo.findCustomersByCity("Lewisville");
		// for (Customers customersDetails : customers) {
		// System.out.println(customersDetails.getCustomerName());
		// }

		/*
		 * Customers customers = custRepo.findUsingInlineById("1");
		 * System.out.println(customers.toString());
		 * System.out.println(customers.getAddress1());
		 */

		/*
		 * List<Customers> customers =
		 * custRepo.findCustomersByCity("Lewisville"); for (Customers customers2
		 * : customers) { System.out.println(customers2.getCustomerName()); for
		 * (Orders order : customers2.getOrders()) {
		 * System.out.println(order.getOrderName()); } }
		 */
		((ClassPathXmlApplicationContext) context).close();
	}

}
