package domain;

import javax.persistence.*;

@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String no;
    private String type;

    public Phone() {
    }

    public Phone(String no, String type) {
        this.no = no;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Phone{" +
            "id=" + id +
            ", no='" + no + '\'' +
            ", type='" + type + '\'' +
            '}';
    }
}
