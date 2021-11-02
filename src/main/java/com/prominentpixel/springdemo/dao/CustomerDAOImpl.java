package com.prominentpixel.springdemo.dao;

import com.prominentpixel.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // need to inject session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create query
        Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);

        // execute query and get result list
        List<Customer> customers = query.getResultList();

        // return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {

        // need current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/update the customer
        currentSession.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int theId) {
        // get current session
        Session currentSession = sessionFactory.getCurrentSession();

        // get customer from database and return it
        return currentSession.get(Customer.class, theId);
    }

    @Override
    public void deleteCustomer(int theId) {

        // get current session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete customer from database
        Query query = currentSession.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", theId);
        query.executeUpdate();
    }
}
