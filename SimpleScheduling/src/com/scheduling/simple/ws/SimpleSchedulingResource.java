/*
 * SimpleSchedulingResource.java
 */
package com.scheduling.simple.ws;

import com.scheduling.simple.model.Student;
import com.scheduling.simple.model.Class;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleSchedulingResource {
    
    private Map<Integer, Student> studentsMap;
    private Map<String, Class> classesMap;

    public SimpleSchedulingResource() {
        studentsMap = new HashMap<Integer, Student>();
        classesMap = new HashMap<String, Class>();
    }
    
    public Student createStudent(int studentId, String lastName, String firstName) {
        Student student = new Student(studentId, lastName, firstName);
        studentsMap.put(studentId, student);
        
        return student;
    }
    
    public Class createClass(String code, String title, String description) {
        
        Class clas = new Class(code, title, description);
        classesMap.put(code, clas);
        
        return clas;
        
    }

    public Student retrieveStudent(int studentId) {
        return studentsMap.get(studentId);
    }
    
    public Class retrieveClass(String code){
        return classesMap.get(code);
    }
    
    public void editStudent(int studentId, Student student){
        studentsMap.replace(studentId, student);
    }
    
    public void editClassTitle(String code, String title){
        classesMap.get(code).setTitle(title);
    }
    
    public void editClassDescription(String code, String description){
        classesMap.get(code).setDescription(description);
    }
    
    public void editStundentFirstName(int studentId, String firstName){
        studentsMap.get(studentId).setFirstName(firstName);
    }
    
    public void editStudentLastName(int studentId, String lastName){
        studentsMap.get(studentId).setLastName(lastName);
    }
    
    public void deleteStudent(int studentId)
    {
        studentsMap.remove(studentId);
    }
    
    public void deleteClass(String code)
    {
        classesMap.remove(code);
    }
    
    public void addStudentToClass(int studentId, String code)
    {
        classesMap.get(code).addId(studentId);
        studentsMap.get(studentId).addCode(code);
    }
    
    public List<Student> getStudents()
    {
        List<Student> students = new ArrayList<>(studentsMap.values());
        return students;
    }
    
    public List<Class> getClasses()
    {
        List<Class> classes = new ArrayList<>(classesMap.values());
        return classes;
    }
    
}
