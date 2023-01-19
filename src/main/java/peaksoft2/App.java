package peaksoft2;

import peaksoft2.models.Student;
import peaksoft2.service.StudentServicImpl;
import peaksoft2.service.StudentService;

import java.sql.SQLException;


/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws SQLException {
        StudentService studentService = new StudentServicImpl();
       // System.out.println(studentService.creatTable());
       // System.out.println(studentService.creatTable());
//        System.out.println(studentService.saveStudents(new Student("Azimbek", (byte) 14)));
//        System.out.println(studentService.saveStudents(new Student("Alibek", (byte) 12)));
//        System.out.println(studentService.saveStudents(new Student("Aygerim", (byte) 15)));
//        System.out.println(studentService.saveStudents(new Student("Nuriza", (byte) 19)));
      //  System.out.println(studentService.findByStudentId(1L));
      //  System.out.println(studentService.findAllStudents());
//        System.out.println(studentService.updateStudent(1L, new Student("Zhiydegul eje", (byte)18)));
//        System.out.println(studentService.deleteByStudentId(1L));
        System.out.println(studentService.getAllStudentsSortByAge("asc"));
    }
}
