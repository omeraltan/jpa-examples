package domain;

import javax.persistence.*;
import java.util.*;

@Entity
//@Table(name = "Employee_New_Name")
@NamedQuery(name = "Employee.findAllEmployees", query = "SELECT e FROM Employee e")
@NamedQueries({
    @NamedQuery(name = "Employee.findById", query = "select e from Employee e where e.id = :paramId"),
    @NamedQuery(name = "Employee.findByName", query = "select e from Employee e where e.name = :name")
})
public class Employee {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    // MYSQL için SEQUENCE adında bir tablo oluşur.
    // SEQ_NAME SEQ_COUNT kolonları
    // ROW/RECORF -> SEQ_GEN default allocation 50

    //@GeneratedValue(strategy = GenerationType.TABLE)
    // SEQUENCE tablosu oluşur.
    // ROW/RECORD -> SEQ_GEN_TABLE

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    // MYSQL'de Sequence kavramı yerine AUTO_INCREMENT kavramı vardır.
    // @TableGenerator(name = "EMP_GEN")
    // @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "EMP_GEN")
    //@TableGenerator(name = "EMP_GEN_DETAILED", table = "KEY_GEN", pkColumnName = "ID_NAME", valueColumnName = "COUNT", initialValue = 1000)
    //@GeneratedValue(generator = "EMP_GEN_DETAILED")
    @Column(name="emp_id")
    private int id;
    @Column(name = "emp_name")
    private String name;
    @Column(name = "emp_surname")
    private String surname;
    @Column(name = "emp_salary")
    private int salary;
    @Column(name = "emp_type")
    // varsayılan olarak ennumdaki ordinal sırasına göre veritabanına değer kaydeder.
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "emp_image")
    @Lob
    private byte[] image;
    // Many -> Employee
    // One  -> Department
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    @OneToOne
    @JoinColumn(name = "ps_id", unique = true)
    private ParkingSpace parkingSpace;

    @OneToMany
    //@JoinTable(name = "EMP_PHN", joinColumns = @JoinColumn(name = "EMP_ID"),inverseJoinColumns = @JoinColumn(name = "PHN_ID"))
    @JoinColumn(name = "EMP_ID")
    private List<Phone> phones = new ArrayList<>();

    @ManyToMany
    // ManyToMany İlişkide ayrı bir tablo olmak zorundadır.
    @JoinTable(name = "EMP_PR", joinColumns = @JoinColumn(name = "EMP_ID"), inverseJoinColumns = @JoinColumn(name = "PR_ID"))
    private List<Project> projects = new ArrayList<>();
    @ElementCollection
    @CollectionTable(name = "EMP_EMAILS", joinColumns = @JoinColumn(name = "EMP_ID"))
    @Column(name = "EMAIL_ADDRESS")
    private List<String> emails;
    @ElementCollection
    @CollectionTable(name = "EMP_PHN_MAP", joinColumns = @JoinColumn(name = "EMP_ID"))
    @MapKeyColumn(name = "PHN_TYPE")
    @Column(name = "PHN_NUM")
    private Map<String,String> phoneNumbers;

    public Employee() {
    }

    public Employee(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public Map<String, String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Map<String, String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "Employee{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            ", salary=" + salary +
            ", employeeType=" + employeeType +
            ", startDate=" + startDate +
            ", image=" + Arrays.toString(image) +
            ", department=" + department +
            '}';
    }
}
