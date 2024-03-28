package test;

import domain.Employee;
import domain.Phone;
import domain.Project;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

public class EmployeeTest5 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
        EntityManager entityManager = emf.createEntityManager();
        EmployeeRepository repository = new EmployeeRepositoryImpl(entityManager);

        Employee employee1 = new Employee();
        employee1.setName("Cihan");
        employee1.setSurname("Güllü");
        employee1.setSalary(5000);

        Employee employee2 = new Employee();
        employee2.setName("Murat");
        employee2.setSurname("Toraman");
        employee2.setSalary(5000);

        Employee employee3 = new Employee();
        employee3.setName("İlker");
        employee3.setSurname("Özdal");
        employee3.setSalary(15000);

        repository.save(employee1);
        repository.save(employee2);
        repository.save(employee3);

        Project project1 = new Project("Çılgın Proje V1");
        Project project2 = new Project("Çılgın Proje V2");
        Project project3 = new Project("Çılgın Proje V3");

        repository.insertProject(project1);
        repository.insertProject(project2);
        repository.insertProject(project3);

        entityManager.getTransaction().begin();
        employee1.getProjects().add(project1);
        employee1.getProjects().add(project3);
        employee2.getProjects().add(project2);
        employee3.getProjects().add(project1);
        employee3.getProjects().add(project2);
        employee3.getProjects().add(project3);
        entityManager.getTransaction().commit();

    }
}
