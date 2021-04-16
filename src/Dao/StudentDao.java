package Dao;

import Model.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class StudentDao {
    
    PreparedStatement state;
    
    public void insertStudent(Student stu) throws SQLException{
        String query="insert into student(id,name,phone,level) values(?,?,?,?)";
        state=DbConnect.connect().prepareStatement(query);
        state.setInt(1, stu.getId());
        state.setString(2, stu.getName());
        state.setString(3, stu.getPhone());
        state.setInt(4, stu.getLevel());
        state.execute();
        
        System.out.println("\ninsert done");
    }
    
    public void delete(int id ) throws Exception{
        String query="delete from student where id=?";
        state=DbConnect.connect().prepareStatement(query);
        state.setInt(1, id);
        state.execute();
        
        System.out.println("\ndelete done \n");
    }
    
    public boolean print(int id ) throws Exception{
        String query="select * from student where id =?";
        state=DbConnect.connect().prepareStatement(query);
        state.setInt(1, id);
        
        ResultSet result;
        result=state.executeQuery();
        if(result.next()==false ){
            System.out.println("\t\tthis stuednt not found");
            return false;
        }
        
        System.out.print("------------------------------------------------------------------------------------");
        System.out.println("\nId : " + result.getInt("id")+ " -*- name : " + result.getString("name")
            +" -*- phone : " + result.getString("phone") + " -*- level " + result.getInt("level"));
        System.out.println("------------------------------------------------------------------------------------");
        
        return true;
    }
    
    public void updateName(int id , String newName ) throws Exception{
   
        String query="update student set name=? where id=?";
        state=DbConnect.connect().prepareStatement(query);
        state.setString(1, newName);
        state.setInt(2, id);
        state.execute();
        
        System.out.println("\nupdate done\n");
    }
    
    public void updatePhone(int id , String newPhone ) throws Exception{
        String query="update student set phone=? where id=?";
        state=DbConnect.connect().prepareStatement(query);
        state.setString(1, newPhone);
        state.setInt(2, id);
        state.execute();
        
        System.out.println("\nupdate done");
    }
    
    public void updateLevel(int id , int newLevel) throws Exception{
        String query="update student set level=? where id=?";
        state=DbConnect.connect().prepareStatement(query);
        state.setInt(1, newLevel);
        state.setInt(2, id);
        state.execute();
        System.out.println("\nupdate done");
    }

}
