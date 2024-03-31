package test;

import domain.Address;
import domain.Employee;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeTest11 {
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
        employee3.setName("Murtaza");
        employee3.setSurname("Samancı");
        employee3.setSalary(1234);

        Address address1 = new Address("Street1","Istanbul","Marmara","34000");
        Address address2 = new Address("Street2","Sivas","Ic","58000");
        Address address3 = new Address("Street3","Izmir","Ege","35000");
        Address address4 = new Address("Street4","Edirne","Marmara","22000");

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

        System.out.println("--- query like ---");
        repository.queryEmployeeLike();

        entityManager.close();
        emf.close();
    }
}
