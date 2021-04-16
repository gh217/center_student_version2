package Service;

import Model.Teacher;
import java.sql.SQLException;

public interface TeacherService {
    
    public void insertTeacher(Teacher stu) throws SQLException;
    public boolean print(int id ) throws Exception;
    public void delete(int id ) throws Exception;
    public void updateName(int id , String newName ) throws Exception;
    public void updatePhone(int id , String newPhone ) throws Exception;
    public void updateSubject(int id , String newSubject ) throws Exception;
}
