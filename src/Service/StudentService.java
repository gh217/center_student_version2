package Service;

import Model.Student;
import java.sql.SQLException;

public interface StudentService {
    

    public void insertStudent(Student stu) throws SQLException;
    public void delete(int id ) throws Exception;
    public void print(int id ) throws Exception;
    public void updateName(int id , String newName ) throws Exception;
    public void updatePhone(int id , String newPhone ) throws Exception;
    public void updateLevel(int id , int newLevel) throws Exception;
    
}
