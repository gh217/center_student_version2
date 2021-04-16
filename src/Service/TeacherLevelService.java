package Service;

import Model.TeacherLevel;
import java.sql.SQLException;

public interface TeacherLevelService {
    
    public void insertTeacherLevel(TeacherLevel tele) throws Exception;
    
    public void deleteLevel(int id , int level) throws Exception;
      
    public void print(int id) throws Exception;
    
    public void updateprice(int id , float newprice , int level) throws SQLException;
    
    public void updateLevel( int id ,int oldLevel, int newLevel ) throws SQLException;
}
