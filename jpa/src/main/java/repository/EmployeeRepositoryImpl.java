package repository;

import domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    @Override
    public List<Employee> queryEmployee() {
        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.salary between ?1 and ?2", Employee.class)
            .setParameter(1,4000)
            .setParameter(2,5000)
            ;
        List<Employee> empList = query.getResultList();
        empList.forEach(System.out::println);
        return empList;
    }

    @Override
    public List<Employee> queryEmployeeLike() {
        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.name LIKE 'cih%'", Employee.class);
        List<Employee> empList = query.getResultList();
        empList.forEach(System.out::println);
        return empList;
    }

    @Override
    public void insertAddress(Address address) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(address);
        transaction.commit();
    }

    @Override
    public List<Employee> queryEmployeeIn() {
        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.address.city IN('Sivas','Izmir')", Employee.class);
        List<Employee> empList = query.getResultList();
        empList.forEach(System.out::println);
        return empList;
    }

    @Override
    public void querySum() {
        TypedQuery<Long> query = entityManager.createQuery("select SUM(e.salary) from Employee e", Long.class);
        Long result = query.getSingleResult();
        System.out.println(result);
    }

    @Override
    public void queryCount() {
        TypedQuery<Long> query = entityManager.createQuery("select COUNT(e.id) from Employee e", Long.class);
        Long result = query.getSingleResult();
        System.out.println(result);
    }

    @Override
    public void queryAvg() {
        TypedQuery<Double> query = entityManager.createQuery("select AVG(e.salary) from Employee e", Double.class);
        Double result = query.getSingleResult();
        System.out.println(result);
    }

    @Override
    public void queryGroup() {
        TypedQuery<Object[]> query = entityManager.createQuery("select e.address.city, AVG(e.salary) from Employee e GROUP BY e.address.city", Object[].class);
        List<Object[]> empList = query.getResultList();
        for (Object[] element : empList){
            System.out.println(element[0] + " ," + element[1]);
        }
    }

    @Override
    public void queryHaving() {
        TypedQuery<Object[]> query = entityManager.createQuery("select e.address.city, AVG(e.salary) from Employee e GROUP BY e.address.city HAVING AVG(e.salary) > 4000", Object[].class);
        List<Object[]> empList = query.getResultList();
        for (Object[] element : empList){
            System.out.println(element[0] + " ," + element[1]);
        }
    }

    @Override
    public void queryOrder() {
        TypedQuery<Integer> query = entityManager.createQuery("select e.salary from Employee e ORDER BY e.salary DESC", Integer.class);
        List<Integer> empList = query.getResultList();
        empList.forEach(System.out::println);
    }

    /**
     *  1. EntityManager üzerinden getCriteriaBuilder metodunu çağırdık, CriteriaBuilder
     *  2. CriteriaQuery objesinin CriteriaBuilder aracılığı ile oluşturduk (createQuery)
     *  3. Sonrasında from metodunu çağırdık, geriye root döndü.
     *  4. select metodunu çağırdık
     *  5. entityManager üzerinden createQuery metodunu çağırdık.
     *  6. getResultList metodu ile sonuç döndü.
     */

    @Override
    public void queryEmployeeCriteriaAPI() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);

        query.select(root);

        TypedQuery<Employee> typedQ = entityManager.createQuery(query);
        typedQ.getResultList().forEach(System.out::println);
    }

    @Override
    public void queryEmployeeCriteriaAPIName() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> query = builder.createQuery(String.class);
        Root<Employee> root = query.from(Employee.class);

        query.select(root.get("name"));
        TypedQuery<String> typedQ = entityManager.createQuery(query);
        typedQ.getResultList().forEach(System.out::println);
    }

    @Override
    public void queryEmployeeCriteriaAPIMultipleArea() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = builder.createQuery(Tuple.class);
        Root<Employee> root = query.from(Employee.class);
        query.select(builder.tuple(root.get("name"), root.get("salary")));

        TypedQuery<Tuple> typedQ = entityManager.createQuery(query);
        List<Tuple> tupleList = typedQ.getResultList();
        for (Tuple t : tupleList){
            System.out.println(t.get(0) + ", " + t.get(1));
        }
    }

    @Override
    public void queryEmployeeCriteriaAPIMultiSelect() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> query = builder.createQuery(String.class);
        Root<Employee> root = query.from(Employee.class);
        query.select(root.get("address").get("state")).where(builder.equal(root.get("name"), "Murtaza"));
        TypedQuery<String> typedQ = entityManager.createQuery(query);
        System.out.println(typedQ.getSingleResult());
    }

    @Override
    public void queryEmployeeCriteriaAPIGreaterThan() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);

        query.select(root).where(builder.greaterThan(root.get("salary"), 4000));

        TypedQuery<Employee> typedQ = entityManager.createQuery(query);
        typedQ.getResultList().forEach(System.out::println);


    }

    @Override
    public void queryEmployeeCriteriaAPIBetween() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);

        query.select(root).where(builder.between(root.get("salary"),
            builder.parameter(Integer.class, "lowSalary"),
            builder.parameter(Integer.class, "highSalary")
        ));

        TypedQuery<Employee> typedQ = entityManager.createQuery(query)
            .setParameter("lowSalary", 4000)
            .setParameter("highSalary", 5000);
        typedQ.getResultList().forEach(System.out::println);
    }

}
