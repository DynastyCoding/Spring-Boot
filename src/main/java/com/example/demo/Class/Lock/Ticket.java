package com.example.demo.Class.Lock;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "remain")
    private int remain;

    @Version
    @Column(name = "version")
    private int version;

    public String getId(){
        return id;
    }

    public int getRemain(){
        return remain;
    }

    public int getVersion(){
        return version;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setRemain(int remain){
        this.remain = remain;
    }

    public void setVersion(int version){
        this.version = version;
    }


}
