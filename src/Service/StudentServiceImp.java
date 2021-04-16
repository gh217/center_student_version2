package Service;

import Dao.StudentDao;
import Model.Student;
import java.sql.SQLException;

public class StudentServiceImp implements StudentService{

    StudentDao stdo = new StudentDao();
     
    @Override
    public void insertStudent(Student stu) throws SQLException {
       
        stdo.insertStudent(stu);
    }
    
    @Override
    public void delete(int id ) throws Exception{
        stdo.delete(id);
    }

    @Override
    public void print(int id) throws Exception {
        stdo.print(id);
    }

    @Override
    public void updateName(int id, String newName) throws Exception {
        stdo.updateName(id, newName);
    }

    @Override
    public void updatePhone(int id, String newPhone) throws Exception {
        stdo.updatePhone(id, newPhone);
    }

    @Override
    public void updateLevel(int id, int newLevel) throws Exception {
        stdo.updateLevel(id, newLevel);
    }
    
    
   
}
