/*
 * Student.java
 */
package com.scheduling.simple.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Student")
public class Student {
    
    @XmlElement(name = "studentId")
    private int studentId;
    @XmlElement(name = "lastName")
    private String lastName;
    @XmlElement(name = "firstName")
    private String firstName;
    // add and objetList of 
    @XmlElement(name = "codes")
    private List<String> codes;
    public Student() {
    }
    
    public Student(int studentId, String lastName, String firstName) {
        this.studentId = studentId;
        this.lastName = lastName;
        this.firstName = firstName;
        codes = new ArrayList<String>();
    }
    
    /**
     * @return the studentId
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void addCode(String code)
    {
        codes.add(code);
    }
    
    public List<String> getCodes()
    {
        return codes;
    }
}
