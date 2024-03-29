package repository;

import domain.*;

import java.util.List;

public interface EmployeeRepository {
    public void save(Employee employee);
    public void insertDepartment(Department department);
    public void insertParkingSpace(ParkingSpace parkingSpace);
    public void insertPhone(Phone phone);
    public void insertProject(Project project);
    public List<Employee> findAllEmployees();
    public List<String> findAllEmployeesName();
    public List<String> findAllEmployeesNameGreaterThanSalary(int salary);
    public List<Employee> findAllEmployeesByNamedQuery();
    public Employee findByIdNamedQuery(int id);
}
