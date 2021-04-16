
package Dao;

import java.sql.PreparedStatement;


public class StudentTeacherDao {
    private PreparedStatement state;
    
    public void insertStudentTeacher(int idStudnet , int idTeacher) throws Exception {
        String query="insert into student_teacher (id_student,id_teacher) values(?,?)";
        state=DbConnect.connect().prepareStatement(query);
        state.setInt(1, idStudnet);
        state.setInt(2, idTeacher);
        state.execute();
        System.out.println("\n\t\t add done");
    }
    
    public void delete(int idS , int idT) throws Exception{
        String query="delete from student_teacher  where id_student=? and id_teacher=?";
        state=DbConnect.connect().prepareStatement(query);
        state.setInt(1, idS);
        state.setInt(2,idT );
        state.execute();
        System.out.println("\n\t\tdelete done ");
    }
    
}
