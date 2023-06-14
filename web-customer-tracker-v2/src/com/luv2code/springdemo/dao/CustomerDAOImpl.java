package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.util.SortUtils;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	//	@Transactional
	//  @Transactional moved to service layer	
	public List<Customer> getCustomers(String sortField) {

		String field="lastName";
		if(sortField!=null && sortField.trim().length()!=0) {
			int sortKey=Integer.parseInt(sortField);
			field=sortKey==SortUtils.FIRST_NAME.getValue()?"firstName":
					sortKey==SortUtils.LAST_NAME.getValue()?"lastName":"email";
		}
		
		//get current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();

		//create a query to get all customers sorted by lastName
		Query<Customer> theQuery=
				currentSession.createQuery("from Customer order by "+field,Customer.class);

		//execute query and get result list
		List<Customer> customers=theQuery.getResultList();

		//return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		//get current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();

		//save customer to db
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int id) {

		Session currentSession=sessionFactory.getCurrentSession();

		Customer theCustomer=currentSession.get(Customer.class, id);

		return theCustomer;
	}

	@Override
	public void deleteCustomer(int id) {
		//get hibernate session
		Session currentSession=sessionFactory.getCurrentSession();

		//create query for delete
		Query<Customer> theQuery=currentSession.createQuery("delete from Customer where id=:customerId",Customer.class);
		theQuery.setParameter("customerId", id);

		theQuery.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Customer> theQuery = null;

		//
		// only search by name if theSearchName is not empty
		//
		if (theSearchName != null && theSearchName.trim().length() > 0) {
			// search for firstName or lastName ... case insensitive
			theQuery =currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
		}
		else {
			// theSearchName is empty ... so just get all customers
			theQuery =currentSession.createQuery("from Customer", Customer.class);            
		}

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();

		// return the results        
		return customers;

	}
}
