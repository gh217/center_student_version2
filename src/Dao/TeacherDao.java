package Dao;

import Model.Teacher;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDao {
    
    protected PreparedStatement state;
    
    public void insertTeacher(Teacher tea) throws SQLException{
        String query="insert into teacher(id,name,subject,phone) values(?,?,?,?)";
        state=DbConnect.connect().prepareStatement(query);
        state.setInt(1,tea.getId());
        state.setString(2, tea.getName());
        state.setString(3, tea.getSubject());
        state.setString(4,tea.getPhone());
        state.execute();
        
        System.out.println("\ninsert done ");
    }
    
    public boolean print(int id ) throws Exception{
        String query="select * from teacher where id =?";
        state=DbConnect.connect().prepareStatement(query);
        state.setInt(1, id);
        ResultSet result=state.executeQuery();
        
        if(result.next()==false )
            return false;
        
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Id : " + result.getInt("id")+ " --- name : " + result.getString("name") + 
            " --- subject : " + result.getString("subject") + " --- phone : " + result.getString("phone"));
        System.out.println("--------------------------------------------------------------------------------------");
        
        return true;
    }
    
    public void delete(int id ) throws Exception{
        String query="delete from teacher where id=?";
        state=DbConnect.connect().prepareStatement(query);
        state.setInt(1, id);
        state.execute();
        
        System.out.println("delete done ");
    }
    
    public void updateName(int id , String newName ) throws Exception{
        String query="update teacher set name=? where id=?";
        state=DbConnect.connect().prepareStatement(query);
        state.setString(1, newName);
        state.setInt(2, id);
        state.execute();
        
        System.out.println("update done");
    }
    
    public void updatePhone(int id , String newPhone ) throws Exception{
        String query="update teacher set phone=? where id=?";
        state=DbConnect.connect().prepareStatement(query);
        state.setString(1, newPhone);
        state.setInt(2, id);
        state.execute();
        
        System.out.println("\nupdate done\n");
    }
    
    public void updateSubject(int id , String newSubject ) throws Exception{
        String query="update teacher set subject=? where id=?";
        state=DbConnect.connect().prepareStatement(query);
        state.setString(1,newSubject);
        state.setInt(2, id);
        state.execute();
        
        System.out.println("\nupdate done\n");
    }    
}
