package edu.sch.dwitterserver.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity  //JPA가 관리하는 객체가 됨 (JDBC는 엔티티 안붙임)
public class Dwitter {  // Domain은 Table 구조와  동일하게

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name, message, image;

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "sdate")
    private LocalDateTime sdate;

    @PrePersist
    public void prePersist() {
        this.sdate = LocalDateTime.now(); // 생성 시 현재 시간 자동 설정
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDateTime getSdate() {
        return sdate;
    }

    public void setSdate(LocalDateTime sdate) {
        this.sdate = sdate;
    }
}
