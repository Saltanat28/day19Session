package peaksoft2.service;

import peaksoft2.enums.Gender;
import peaksoft2.models.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    // create table

    String creatTable() ;

    // save students
    String saveStudents(Student student);

    // find by studentsId
    Student findByStudentId(Long studentId);

    //find all
    List<Student> findAllStudents();

    // update students
    String updateStudent(Long studentId, Student newStudent);

    //delete
    String deleteByStudentId(Long studentID);
    List<Student> getAllStudentsSortByAge(String ascOrDesc);
    boolean checkByAge();
    String addColumnGender();
    Map<Gender, List<Student>> groupByGender();
    String deleteAllStudents();



}
