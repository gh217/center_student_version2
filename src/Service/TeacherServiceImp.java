package Service;

import Dao.TeacherDao;
import Model.Teacher;
import java.sql.SQLException;

public class TeacherServiceImp implements TeacherService{

    TeacherDao tedo = new TeacherDao();
    
    @Override
    public void insertTeacher(Teacher stu) throws SQLException {
        tedo.insertTeacher(stu);
    }

    @Override
    public boolean print(int id) throws Exception {
        return tedo.print(id);
    }

    @Override
    public void delete(int id) throws Exception {
        tedo.delete(id);
    }

    @Override
    public void updateName(int id, String newName) throws Exception {
        tedo.updateName(id, newName);
    }

    @Override
    public void updatePhone(int id, String newPhone) throws Exception {
        tedo.updatePhone(id, newPhone);
    }

    @Override
    public void updateSubject(int id, String newSubject) throws Exception {
        tedo.updateSubject(id, newSubject);
    }
    
    
}
