package repository;

import domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository{
    private EntityManager entityManager;

    public EmployeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Employee employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee);
        transaction.commit();
    }

    @Override
    public void insertDepartment(Department department) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(department);
        transaction.commit();
    }

    @Override
    public void insertParkingSpace(ParkingSpace parkingSpace) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(parkingSpace);
        transaction.commit();
    }

    @Override
    public void insertPhone(Phone phone) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(phone);
        transaction.commit();
    }

    @Override
    public void insertProject(Project project) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(project);
        transaction.commit();
    }

    public List<Employee> findAllEmployees(){
        TypedQuery<Employee> typedQuery = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
        return typedQuery.getResultList();
    }

    public List<String> findAllEmployeesName(){
        TypedQuery<String> typedQuery = entityManager.createQuery("SELECT e.name FROM Employee e", String.class);
        return typedQuery.getResultList();
    }

    // Positional Binding
    public List<String> findAllEmployeesNameGreaterThanSalary(int salary){
        TypedQuery<String> typedQuery = entityManager.createQuery("SELECT e.name FROM Employee e WHERE e.salary > ?1", String.class).setParameter(1,salary);
        return typedQuery.getResultList();
    }

    // Named Parameter
//    public List<String> findAllEmployeesNameGreaterThanSalary(int salary){
//        TypedQuery<String> typedQuery = entityManager.createQuery("SELECT e.name FROM Employee e WHERE e.salary > :paramSalary", String.class).setParameter("paramSalary",salary);
//        return typedQuery.getResultList();
//    }

    @Override
    public List<Employee> findAllEmployeesByNamedQuery() {
        TypedQuery<Employee> typedQuery = entityManager.createNamedQuery("Employee.findAllEmployees", Employee.class);
        return typedQuery.getResultList();
    }

    /**
     * getSingleResult eğer query sonucu boş gelirse / null gelirse bu durumda Exception fırlatır
     * javax.persistence.NoResultException:
     * getResultList bir sonuç bulamazsa geriye boş liste döner.
     */
    public Employee findByIdNamedQuery(int id){
        TypedQuery<Employee> typedQuery = entityManager.createNamedQuery("Employee.findById", Employee.class);
        typedQuery.setParameter("paramId", id);
        return typedQuery.getSingleResult();
    }

}
