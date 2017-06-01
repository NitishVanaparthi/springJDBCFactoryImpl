package org.jnit.springRepositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.jnit.springDataEntities.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author nitishvanaparthi
 *
 */
@Repository
public class CustomerRepositoyImpl implements CustomerRepository {

	private JdbcTemplate template;

	@Autowired
	public CustomerRepositoyImpl(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

	private static final String CUSTOMER_COLUMNS = " customerId, customerName, sex, Address1, Address2, city ";
	private static final String ORDER_COLUMNS = " orderId, orderName, orderDate, orderIsPossible, orderDescription ";

	private static final String FIND_QUERY = "select customerName from customers where customersId=?";
	private static final String FIND_BY_ID_QUERY = "select" + CUSTOMER_COLUMNS + "from customers where customersId=?";
	private static final String FIND_BY_STATE_QUERY = "select" + CUSTOMER_COLUMNS + "," +ORDER_COLUMNS + "from customers where city=?";
	private static final String FIND_BY_STATE_QUERY_RESULTSET = "select" + CUSTOMER_COLUMNS + ORDER_COLUMNS
			+ "from customers c1 join orders o1" + "on r1.customersId=o1.customersId" + "where state=?";

	/*
	 * Result set exractors extract data method will be invoked once once per
	 * excution of query our responsibility to map an object once for result set
	 * one object
	 */
	@Override
	public List<Customers> findOrdersFromCustomers(int customerId) {
		return this.template.query(FIND_BY_STATE_QUERY_RESULTSET, new Object[] { customerId },
				new CustomersAndOrderResultSetExtractor());
	}

	/*
	 * when you wanted to extract single row single column it can not return
	 * multiple columns
	 */
	@Override
	public String findNameById(int customerId) {
		return this.template.queryForObject(FIND_QUERY, new Object[] { customerId }, String.class);
	}

	/*
	 * this method CustomerRepositoryRowMapper which implements RowMapper and
	 * returns List
	 */
	@Override
	public List<Customers> findCustomersByCity(String city) {

		return this.template.query(FIND_BY_STATE_QUERY, new Object[] { city }, new CustomerRepositoryRowMapper());

	}

	/*
	 * inline rowmapper for extracting multiple columns this can not return list
	 */

	@Override
	public Customers findUsingInlineById(int customerId) {
		return template.queryForObject(FIND_BY_ID_QUERY, new Object[] { customerId }, new RowMapper<Customers>() {

			@Override
			public Customers mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customers customer = new Customers();
				customer.setCustomerId(rs.getInt("customerId"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setSex(rs.getString("sex"));
				customer.setAddress1(rs.getString("Address1"));
				customer.setAddress2(rs.getString("Address2"));
				customer.setCity(rs.getString("city"));
				return customer;
			}

		});
	}

	@Override
	public Customers findRowById(int customerId) {

		return this.template.queryForObject(FIND_BY_ID_QUERY, new Object[] { customerId },
				new CustomerRepositoryRowMapper());
	}

	/*
	 * Inner static class implenting rowMapper and providing body to its method
	 * for findCustomersByCity for returning a list
	 */
	private static class CustomerRepositoryRowMapper implements RowMapper<Customers> {

		@Override
		public Customers mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customers customer = new Customers();
			customer.setCustomerId(rs.getInt("customerId"));
			customer.setCustomerName(rs.getString("customerName"));
			customer.setSex(rs.getString("sex"));
			customer.setAddress1(rs.getString("Address1"));
			customer.setAddress2(rs.getString("Address2"));
			customer.setCity(rs.getString("city"));
			return customer;
		}

	}

	@Override
	public void insert(Customers entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Customers entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Customers entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Customers findById() {
		return null;
	}

}
