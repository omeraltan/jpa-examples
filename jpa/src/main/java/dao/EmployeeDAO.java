package dao;

import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class EmployeeDAO {
    private EntityManager entityManager;

    public EmployeeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveEmployee(Employee employee){
        // programatic transaction
        // veritabanına insert işlemi, update işlemi bir transaction arasında olması gereklidir.
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee);
        transaction.commit();
    }

    public Employee findEmployeeById(int id){
        // read işleminde transactiona gerek yoktur.
        return entityManager.find(Employee.class, id);
    }

    public List<Employee> findAllEmployees(){
        // transaction'a gerek yok!
        // JPQL grameri
        Query query = entityManager.createQuery("SELECT e FROM Employee e");
        return query.getResultList();
    }

    public void removeEmployee(int id){
        // delete/remove işlemi transaction arasında olmalı
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(findEmployeeById(id));
        transaction.commit();
    }

    public Employee raiseSalary(int id, int raise){
        // JPA da bir transaction arasında Entity güncellersek bu durum veritabanına yansır.
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Employee foundEmployee = findEmployeeById(id);
        if (foundEmployee != null){
            foundEmployee.setSalary(foundEmployee.getSalary() + raise);
        }
        transaction.commit();
        return foundEmployee;
    }
}
