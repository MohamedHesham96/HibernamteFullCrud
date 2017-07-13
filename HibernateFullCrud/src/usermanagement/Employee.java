/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagement;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author H
 */
@Entity
@Table(name = "Employees")
public class Employee implements Serializable{

    private int id;
    private String username;
    private String password;
    private String email;

    private EmployeeInfo info;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(length = 50, nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(length = 32, nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(length = 100, nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public EmployeeInfo getInfo() {
        return info;
    }

    public void setInfo(EmployeeInfo info) {
        this.info = info;
    }

}
