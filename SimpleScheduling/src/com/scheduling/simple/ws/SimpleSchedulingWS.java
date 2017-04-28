/*
 * SimpleSchedulingWS.java
 */
package com.scheduling.simple.ws;

import com.scheduling.simple.model.Student;
import com.scheduling.simple.model.Class;
import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class SimpleSchedulingWS {
    
    private final SimpleSchedulingResource resource = new SimpleSchedulingResource();
    
    /**
     * Creates a new student.
     * @param studentId Integer
     * @param lastName String
     * @param firstName String
     * @return 
     */
    public Student createStudent(@WebParam(name = "studentId") int studentId, 
            @WebParam(name = "lastName") String lastName, 
            @WebParam(name = "firstName") String firstName) {
        return resource.createStudent(studentId, lastName, firstName);
    }
    
    /**
     * Return a student based on its studentId.
     * @param studentId Integer
     * @return 
     */
    public Student retrieveStudent(@WebParam(name = "studentId") int studentId) {
        return resource.retrieveStudent(studentId);
    }
    
     /**
     * Creates a new class.
     * @param code String
     * @param title String
     * @param description String
     * @return 
     */
   public Class createClass(@WebParam(name = "code") String code, 
            @WebParam(name = "title") String title, 
            @WebParam(name = "description") String description) 
    {
        return resource.createClass(code, title, description);
    }
   
   
    /**
     * Return a class based on its code.
     * @param code String
     * @return 
     */
    
    
    public Class retrieveClass(@WebParam(name = "code") String code) {
        return resource.retrieveClass(code);
    }
    
    public void addStudentToClass(@WebParam(name = "studentId") int studentId,
            @WebParam(name = "code") String code){
        resource.addStudentToClass(studentId, code);
    }
    
    public void deleteStudent(@WebParam(name= "studentId") int studentId)
    {
        resource.deleteStudent(studentId);
    }
    
    public void deleteClass(@WebParam(name = "code") String code)
    {
        resource.deleteClass(code);
    }
    
    public List<Student> getStudents()
    {
        return resource.getStudents();
    }
    
    public List<Class> getClasses()
    {
        return resource.getClasses();
    }
    
     public void editStudent(@WebParam(name = "studentId") int studentId,
             @WebParam(name = "lastName") String lastName,
             @WebParam(name = "firtsName") String firstName)
    {
        resource.editStudent(studentId,lastName,firstName);
    }
     
    public void editClass(@WebParam(name = "code") String code,
            @WebParam(name = "title") String title,
            @WebParam(name = "description") String description)
    {
        resource.editClass(code, title, description);
    }
    
    public List<Class> showClassesFromStudent(@WebParam(name = "studentdId") int studentId)
    {
        return resource.showClassesFromStudent(studentId);
    }
    
    public List<Student> showStudentsFromClass(@WebParam(name = "code") String code)
    {
        return resource.showStudentsFromClass(code);
    }
    
    public Student searchStudentForLastName(@WebParam(name = "lastName") String lastName)
    {
        return resource.searchStudentForLastName(lastName);
    }
    
    public Student searchStudentForFirstName(@WebParam(name = "firstName") String firstName)
    {
        return resource.searchStudentForFirstName(firstName);
    }
    
    public Class searchClassForTitle(@WebParam(name = "title") String title)
    {
        return resource.searchClassForTitle(title);
    }
    
    public Class searchClassForDescription(@WebParam(name = "description") String description)
    {
        return resource.searchClassForDescription(description);
    }
  

}
