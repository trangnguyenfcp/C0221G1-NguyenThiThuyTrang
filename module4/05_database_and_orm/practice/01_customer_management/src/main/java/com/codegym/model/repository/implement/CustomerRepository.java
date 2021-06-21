package com.codegym.model.repository.implement;


import com.codegym.model.entity.Customer;
import com.codegym.model.repository.ICustomerRepository;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class CustomerRepository implements ICustomerRepository {
    @Override
    public List<Customer> findAll() {
        return BaseRepository.entityManager.createQuery("SELECT s " +
                "FROM Customer AS s", Customer.class).getResultList();
    }

    @Override
    public Customer findOne(Long id) {
        return BaseRepository.entityManager.find(Customer.class, id);
    }

    @Override
    public void save(Customer customer) throws Exception {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
                entityTransaction.begin();
                BaseRepository.entityManager.merge(customer);
                entityTransaction.commit();
    }

    @Override
    public List<Customer> save(List<Customer> customers) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<Customer> findAll(List<Long> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public void delete(List<Customer> customers) {

    }

    @Override
    public void deleteAll() {

    }
}
