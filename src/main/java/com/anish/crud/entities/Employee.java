package com.anish.crud.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
//@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "First Name is mandatory")
    private String firstName;

    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    @NotBlank(message = "Gender is mandatory")
    private String gender;

    @NotBlank(message = "Date Of Birth is mandatory")
    private String dateOfBirth;

    @NotBlank(message = "Department is mandatory")
    private String department;

    public Employee() {
    }

    public Employee(long id, @NotBlank(message = "First Name is mandatory") String firstName, @NotBlank(message = "Last Name is mandatory") String lastName, @NotBlank(message = "Gender is mandatory") String gender, @NotBlank(message = "Date Of Birth is mandatory") String dateOfBirth, @NotBlank(message = "Department is mandatory") String department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
