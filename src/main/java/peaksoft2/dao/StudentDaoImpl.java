package peaksoft2.dao;

import peaksoft2.config.DatabaseConnection;
import peaksoft2.enums.Gender;
import peaksoft2.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements StudentDao{
    private Connection connection;
    public StudentDaoImpl() throws SQLException {
            this.connection= DatabaseConnection.getConnection();

    }
    @Override
    public void creatTable() {
        String query = """
              create table  if not exists students(
              id serial primary key,
              name varchar not null,
              age smallInt not null) ;
              """;
      try {
        Statement statement = connection.createStatement();
            statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
      }

    @Override
    public void saveStudents(Student student) {
        String sqlQuery = """
        insert into students(name, age) values (?,?)
        """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setString(1,student.getName());
            preparedStatement.setByte(2,student.getAge());
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Student findByStudentId(Long studentId) {
        String query = """
                select * from students where id = ?;
               
                """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1,studentId);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student = new Student();
            while (resultSet.next()) {
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getByte(3));
                return student;
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Student> findAllStudents() {
        List<Student> allStudent = new ArrayList<>();
        String query = """
                select * from students;
                """;
        try (    Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query);){
            while (resultSet.next()){
                    Student student = new Student();
                    student.setId(resultSet.getLong("id"));
                    student.setName(resultSet.getString(2));
                    student.setAge(resultSet.getByte(3));
                    allStudent.add(student);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        return allStudent;
    }

    @Override
    public void updateStudent(Long studentId, Student newStudent) {
        String query = """
                update students
                set name = ?,
                age = ?
                where id = ?;
                
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, newStudent.getName());
            preparedStatement.setByte(2,newStudent.getAge());
            preparedStatement.setLong(3, studentId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteByStudentId(Long studentID) {
        String query = """
                delete from students where id = ?;
                """;
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setLong(1, studentID);
                preparedStatement.execute();
                System.out.println("Student successfully deleted!");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    @Override
    public List<Student> getAllStudentsSortByAge(String ascOrDesc) {
        List<Student> students = new ArrayList<>();
        String query1 = """
                select * from students order by age;
                """;
        String query2 = """
                select * from students order by age desc; 
                """;
        String query = "";

        if(ascOrDesc.equals("asc")) query=query1;
        else if(ascOrDesc.equals("desc")) {
            query=query2;
        }
        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                students.add(new Student(resultSet.getLong("id"),resultSet.getString(2),resultSet.getByte(3)));
            }
            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean checkByAge() {
        String sql = """
                select * from students where age = 18;
                """;

        try(Statement statement = connection.createStatement()) {
            boolean resultSet = statement.execute(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public void addColumnGender() {
        String sql = """
                alter table students add column gender varchar(50);
                """;
        try(Statement statement = connection.createStatement()) {


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Map<Gender, List<Student>> groupByGender() {
        return null;
    }

    @Override
    public void deleteAllStudents() {


    }


}

