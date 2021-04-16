package Service;

import Dao.TeacherLevelDao;
import Model.TeacherLevel;
import java.sql.SQLException;

public class TeacherLevelImp implements TeacherLevelService{

    TeacherLevelDao teleda = new TeacherLevelDao();
    
    @Override
    public void insertTeacherLevel(TeacherLevel tele) throws Exception {
        teleda.insertTeacherLevel(tele);
    }

    @Override
    public void deleteLevel(int id, int level) throws Exception {
        teleda.deleteLevel(id, level);
    }

    @Override
    public void print(int id) throws Exception {
        teleda.print(id);
    }

    @Override
    public void updateprice(int id, float newprice, int level) throws SQLException {
        teleda.updateprice(id, newprice, level);
    }

    @Override
    public void updateLevel(int id, int oldLevel, int newLevel) throws SQLException {
        teleda.updateLevel(id, oldLevel, newLevel);
    }
    
}
