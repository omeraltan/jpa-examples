package domain;

import javax.persistence.*;

@Entity
@Table(name = "parking_space")
public class ParkingSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private int flat;
    private String location;
    // OneToOne Bi Directional ilişki oldu.
    // İlişkinin sahibi owning side -> Employee tarafıdır.
    // Foreign key bilgisi Employee tarafında yer alır.
    // Inverse Side -> ParkingSpace tarafıdır. Burada foreign key bilgisi yer almaz.
    @OneToOne(mappedBy = "parkingSpace", cascade = CascadeType.ALL)
    private Employee employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "ParkingSpace{" +
            "id=" + id +
            ", flat=" + flat +
            ", location='" + location + '\'' +
            ", employee=" + employee +
            '}';
    }
}

// 1 Çalışanın - 1 tane park alanı olsun.
// one-to-one bir ilişki/relationship
