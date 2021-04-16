package Dao;

import Model.TeacherLevel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherLevelDao {
    
    private PreparedStatement state;
    
    public void insertTeacherLevel(TeacherLevel tele) throws Exception{
        String query = "insert into teacher_level(id_teacher,level,price) values(?,?,?)";
        state=DbConnect.connect().prepareStatement(query);
        state.setInt(1, tele.getId());
        state.setInt(2, tele.getLevel());
        state.setFloat(3, tele.getPrice());
        state.execute();
        System.out.println("\t\t\tinsert done");
    }
    
    public void deleteLevel(int id , int level) throws Exception{
        String query="delete from teacher_level where id_teacher=? and level=?";
        state=DbConnect.connect().prepareStatement(query);
        state.setInt(1, id);
        state.setInt(2, level);
        state.execute();
        System.out.println("\t\t\tdelete done ");
    }
    
    public void print(int id) throws Exception {
        String query="select * from teacher_level where id_teacher=?";
        state=DbConnect.connect().prepareStatement(query);
        state.setInt(1, id);
        ResultSet result;
        result=state.executeQuery();
        boolean flag=true;
        
        while(result.next()){
            if(flag){
                TeacherDao tdo = new TeacherDao();
                tdo.print(id);
            }
            System.out.println("-----------------------------------------------------------------");    
            System.out.println("\t level : " + result.getInt("level")+"\t price : " + result.getFloat("price") );
            System.out.println("-----------------------------------------------------------------");   
            
            flag=false;
        }
    }
    
    public void updateprice(int id , float newprice , int level) throws SQLException{
        String query="update teacher_level set price=? where id_teacher=? and level =?";
        state=DbConnect.connect().prepareStatement(query);
        state.setFloat(1, newprice);
        state.setInt(2, id);
        state.setFloat(3, level);
        state.execute();
        
        System.out.println("\t\tupdate done");
    }
    
    public void updateLevel( int id ,int oldLevel, int newLevel ) throws SQLException{
        String query="update teacher_level set level =?  where id_teacher=? and level =?";
        state=DbConnect.connect().prepareStatement(query);
        state.setInt(1, newLevel);
        state.setInt(2, id);
        state.setInt(3, oldLevel);
        state.execute();
        
        System.out.println("\t\tupdate done");
    }
    
    /// check if the id and level found or not
    public static boolean checkIdLevel(int id , int level) throws SQLException{
        String query="select * from teacher_level where id_teacher=? and level=?";
        PreparedStatement state;
        state=DbConnect.connect().prepareStatement(query);
        state.setInt(1, id);
        state.setInt(2, level);
        ResultSet result = state.executeQuery();
        
        if( result.next()){
            System.out.println("id : " + result.getInt("id_teacher") + " -*- level : " + result.getInt("level")
            +" -*- price : " + result.getFloat("price"));
            return true;
        }
        return false;
    }
}
