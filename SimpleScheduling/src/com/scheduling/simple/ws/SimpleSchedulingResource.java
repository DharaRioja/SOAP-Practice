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
        if(studentId!=0 && !"?".equals(lastName) && !"?".equals(firstName))
        {   
            studentsMap.put(studentId, student);
        }
        else
        {
            throw new RuntimeException("Datos no validos");
        }
        
        return student;
    }
    
    public Class createClass(String code, String title, String description) {
        
        Class clas = new Class(code, title, description);
        if(!"".equals(code) && !"?".equals(title) && !"?".equals(description))
        {
            classesMap.put(code, clas);
        }
        else
        {
            throw new RuntimeException("Datos no validos");
        }
        return clas;
        
    }

    public Student retrieveStudent(int studentId) {
        Student s = studentsMap.get(studentId);
        if(s!=null)
        {
            return s;
        }
        else
        {
            throw new RuntimeException("No existe");
        }
    }
    
    public Class retrieveClass(String code){
        Class c = classesMap.get(code);
        if(c!=null)
        {
            return c;
        }
        else
        {
            throw new RuntimeException("No existe");
            
        } 
    }
    
    public void editStudent(int studentId, String lastName, String firstName){
        retrieveStudent(studentId).setLastName(lastName);
        retrieveStudent(studentId).setFirstName(firstName);   
    }
    
    public void editClass(String code, String title, String description){
        retrieveClass(code).setTitle(title);
        retrieveClass(code).setDescription(description);
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
        Student s=studentsMap.get(studentId);
        Class c=classesMap.get(code);
        if(s!=null & c!=null)
        {
            c.addId(studentId);
            s.addCode(code);
        }
        else
        {
            throw new RuntimeException("El estudiante o la clase no existe");
        }
        
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
    
    public List<Class> showClassesFromStudent(int studentId)
    {
        List<Class> c = new ArrayList<>();
        for(String code : retrieveStudent(studentId).getCodes())
        {
            c.add(retrieveClass(code));
        }
        return c;
    }
    
    public List<Student> showStudentsFromClass(String code)
    {
        List<Student> s = new ArrayList<>();
        for(int studentId : retrieveClass(code).getIds())
        {
            s.add(retrieveStudent(studentId));
        }
        return s;
    }
    
    public Student searchStudentForFirstName(String campo)
    {
        for(Student s: getStudents())
        {
            if(s.getFirstName().equals(campo))
            {
                return s;
            }
            else
            {
             
                throw new RuntimeException("Estudiante no encontrado");
                
            }
        }
        return null;
    }
    
    public Student searchStudentForLastName(String campo)
    {
        for(Student s: getStudents())
        {
            if(s.getLastName().equals(campo))
            {
                return s;
            }
            else
            {
             
                throw new RuntimeException("Estudiante no encontrado");
                
            }
        }
        return null;
    }

    public Class searchClassForTitle(String campo)
    { 
        for(Class c : getClasses())
        {
            if(c.getTitle().equals(campo))
            {
                return c;
            }
            else
            {
                throw new RuntimeException("Clase no encontrada");
            }
        }
        return null;
    }
    
       public Class searchClassForDescription(String campo)
    { 
        for(Class c : getClasses())
        {
            if(c.getDescription().equals(campo))
            {
                return c;
            }
            else
            {
                throw new RuntimeException("Clase no encontrada");
            }
        }
        return null;
    }
}
