package question3;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

class Student {
  public String name;
  public String gender;

  public Student(String name, String gender) {
    this.name = name;
    this.gender = gender;
  }
}

@Repository
public class StudentRepository {
  @Autowired
  private JdbcTemplate template;

  @PostConstruct

  public void createTable() {
    template.execute("CREATE TABLE student(id bigint auto_increment primary key, name VARCHAR(50), gender VARCHAR(1))");
  }

  public void createStudent(String name, String gender) {
    template.update("INSERT INTO student(id, name, gender) VALUES (?,?,?)", null, name, gender);
  }

  public List<Student> findStudentByName(String nameStartsWith) {
    // Write your code here
    return template.query("SELECT name, gender FROM STUDENT WHERE name LIKE ?",
        (rs, rn) -> new Student(rs.getString("name"), rs.getString("gender")), nameStartsWith + "%");
  }
}
