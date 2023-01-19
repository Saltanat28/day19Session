package peaksoft2.dao;

import peaksoft2.enums.Gender;
import peaksoft2.models.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    // create table
    void creatTable();

    // save students
    void saveStudents(Student student);

    // find by studentsId
    Student findByStudentId(Long studentId);

    //find all
    List<Student> findAllStudents();

    // update students
    void updateStudent(Long studentId, Student newStudent);

    //delete
    void deleteByStudentId(Long studentID);

    List<Student> getAllStudentsSortByAge(String ascOrDesc);
    boolean checkByAge();
    void addColumnGender();
    Map<Gender, List<Student>> groupByGender();
    void deleteAllStudents();

}
