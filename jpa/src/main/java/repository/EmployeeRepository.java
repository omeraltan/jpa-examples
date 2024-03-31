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
    public List<Employee> queryEmployee();
    public List<Employee> queryEmployeeLike();
    public void insertAddress(Address address);
    public List<Employee> queryEmployeeIn();
    public void querySum();
    public void queryCount();
    public void queryAvg();
    public void queryGroup();
    public void queryHaving();
    public void queryOrder();
    public void queryEmployeeCriteriaAPI();
    public void queryEmployeeCriteriaAPIName();
    public void queryEmployeeCriteriaAPIMultipleArea();
    public void queryEmployeeCriteriaAPIMultiSelect();
    public void queryEmployeeCriteriaAPIGreaterThan();
    public void queryEmployeeCriteriaAPIBetween();
}
