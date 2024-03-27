package domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Employee_New_Name")
public class Employee {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    // MYSQL için SEQUENCE adında bir tablo oluşur.
    // SEQ_NAME SEQ_COUNT kolonları
    // ROW/RECORF -> SEQ_GEN default allocation 50

    //@GeneratedValue(strategy = GenerationType.TABLE)
    // SEQUENCE tablosu oluşur.
    // ROW/RECORD -> SEQ_GEN_TABLE

    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    // MYSQL'de Sequence kavramı yerine AUTO_INCREMENT kavramı vardır.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public String toString() {
        return "Employee{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            ", salary=" + salary +
            ", employeeType=" + employeeType +
            '}';
    }
}
