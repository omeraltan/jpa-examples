package test;

import domain.Address;
import domain.Department;
import domain.Employee;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeTest12 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
        EntityManager entityManager = emf.createEntityManager();
        EmployeeRepository repository = new EmployeeRepositoryImpl(entityManager);

        Employee employee = new Employee();
        employee.setName("Cihan");
        employee.setSurname("Güllü");
        employee.setSalary(5000);

        Employee employee2 = new Employee();
        employee2.setName("Murat");
        employee2.setSurname("Toraman");
        employee2.setSalary(4000);

        Employee employee3 = new Employee();
        employee3.setName("Alpay");
        employee3.setSurname("Tirasoglu");
        employee3.setSalary(3000);

        Employee employee4 = new Employee();
        employee4.setName("Murtaza");
        employee4.setSurname("Samancı");
        employee4.setSalary(1234);

        Address address1 = new Address("Street1","Istanbul","Marmara","34000");
        Address address2 = new Address("Street2","Istanbul","Ic","58000");
        Address address3 = new Address("Street3","Izmir","Ege","35000");
        Address address4 = new Address("Street4","Edirne","Marmara","22000");

        Department department = new Department("IT Department");


        repository.insertAddress(address1);
        repository.insertAddress(address2);
        repository.insertAddress(address3);
        repository.insertAddress(address4);

        employee.setAddress(address1);
        employee2.setAddress(address2);
        employee3.setAddress(address3);
        employee4.setAddress(address4);

        repository.save(employee);
        repository.save(employee2);
        repository.save(employee3);
        repository.save(employee4);

        System.out.println("--- query in ---");
        repository.queryEmployeeIn();

        System.out.println("--- query sum ---");
        repository.querySum();

        System.out.println("--- query count ---");
        repository.queryCount();

        System.out.println("--- query avg ---");
        repository.queryAvg();

        System.out.println("--- query group ---");
        repository.queryGroup();

        System.out.println("--- query having ---");
        repository.queryHaving();

        System.out.println("--- query order ---");
        repository.queryOrder();

        System.out.println("--- query Criteria ---");
        repository.queryEmployeeCriteriaAPI();

        System.out.println("--- query Criteria Name ---");
        repository.queryEmployeeCriteriaAPIName();

        System.out.println("--- query Criteria with tuple ---");
        repository.queryEmployeeCriteriaAPIMultipleArea();

        System.out.println("--- query Criteria Multiple select ---");
        repository.queryEmployeeCriteriaAPIMultiSelect();

        System.out.println("--- query Criteria GreaterThan ---");
        repository.queryEmployeeCriteriaAPIGreaterThan();

        System.out.println("--- query Criteria Between ---");
        repository.queryEmployeeCriteriaAPIBetween();

        entityManager.close();
        emf.close();
    }
}
