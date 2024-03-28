package repository;

import domain.*;

public interface EmployeeRepository {
    public void save(Employee employee);
    public void insertDepartment(Department department);
    public void insertParkingSpace(ParkingSpace parkingSpace);
    public void insertPhone(Phone phone);
    public void insertProject(Project project);
}
