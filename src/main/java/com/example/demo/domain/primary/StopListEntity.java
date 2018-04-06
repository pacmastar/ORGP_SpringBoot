package com.example.demo.domain.primary;

import javax.persistence.*;

@Entity
@Table(name = "blacklist")
public class StopListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    public long id;

    @Column(name = "card_num")
    public String uid;

    @Column(name = "reason")
    public int reason;

    @Override
    public String toString() {
        return "StopListEntity{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", reason=" + reason +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getReason() {
        return reason;
    }

    public void setReason(int reason) {
        this.reason = reason;
    }
}
