package peaksoft2.service;

import peaksoft2.dao.StudentDao;
import peaksoft2.dao.StudentDaoImpl;
import peaksoft2.enums.Gender;
import peaksoft2.models.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class StudentServicImpl implements StudentService {

    StudentDao studentDao = new StudentDaoImpl();

    public StudentServicImpl() throws SQLException {
    }

    @Override
    public String creatTable()  {
        try {
            studentDao.creatTable();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Successfully created!";
    }

    @Override
    public String saveStudents(Student student) {
        studentDao.saveStudents(student);
        return "Successfully saved";
    }

    @Override
    public Student findByStudentId(Long studentId) {
        return studentDao.findByStudentId(studentId);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentDao.findAllStudents();

    }

    @Override
    public String updateStudent(Long studentId, Student newStudent) {
        studentDao.updateStudent(studentId,newStudent);
        return "Successfully updated!";
    }

    @Override
    public String deleteByStudentId(Long studentID) {
        studentDao.deleteByStudentId(1L);
        return "Successfully deleted.";
    }

    @Override
    public List<Student> getAllStudentsSortByAge(String ascOrDesc) {
        return studentDao.getAllStudentsSortByAge(ascOrDesc);
    }

    @Override
    public boolean checkByAge() {
        return false;
    }

    @Override
    public String addColumnGender() {
   return null;
    }

    @Override
    public Map<Gender, List<Student>> groupByGender() {
        return null;
    }

    @Override
    public String deleteAllStudents() {
return null;
    }


}
