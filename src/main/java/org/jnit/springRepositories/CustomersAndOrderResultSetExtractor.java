package org.jnit.springRepositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jnit.springDataEntities.Customers;
import org.jnit.springDataEntities.Orders;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class CustomersAndOrderResultSetExtractor implements ResultSetExtractor<List<Customers>> {

	@Override
	public List<Customers> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Customers> cities = new HashMap<Integer, Customers>();
		Customers customer;

		while (rs.next()) {
			int id = rs.getInt("customerId");
			customer = cities.get(id);

			if (customer == null) {
				customer = new Customers();
				customer.setCustomerId(rs.getInt("customersId"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setSex(rs.getString("sex"));
				customer.setAddress1(rs.getString("Address1"));
				customer.setAddress2(rs.getString("Address2"));
				customer.setCity(rs.getString("city"));
			}

			int orderId = rs.getInt("orderId");
			if (orderId > 0) {
				Orders order = new Orders();
				order.setOrderId(rs.getInt("orderId"));
				order.setOrderDescription(rs.getString("orderDescription"));
				order.setOrderIsAvailable(rs.getString("orderIsAvailable"));
				order.setOrderName(rs.getString("orderName"));
				order.setOrderDate(rs.getDate("orderDate"));

				customer.getOrders().add(order);

			}

			cities.put(id, customer);
			return new ArrayList<Customers>(cities.values());
		}

		return null;
	}

}
