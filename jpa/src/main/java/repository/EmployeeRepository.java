package repository;

import domain.Department;
import domain.Employee;
import domain.ParkingSpace;

public interface EmployeeRepository {
    public void save(Employee employee);
    public void insertDepartment(Department department);
    public void insertParkingSpace(ParkingSpace parkingSpace);
}
