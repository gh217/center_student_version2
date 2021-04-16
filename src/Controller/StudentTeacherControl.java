package Controller;

import Dao.StudentDao;
import Dao.StudentTeacherDao;
import Dao.TeacherDao;

import java.util.Scanner;

public class StudentTeacherControl {
    
    StudentTeacherDao stdo = new StudentTeacherDao();
    
    Scanner input = new Scanner(System.in);
    public void studentTeacherConsole() throws Exception{
        
        System.out.println("add new course --> 1");
        System.out.println("delete course  --> 2");
        
        switch(input.nextInt()){
            case 1 : this.insertStudentTeacher(); break;
            case 2 : this.deleteCourse(); break;
        }
    }
    
    protected void insertStudentTeacher() throws Exception {
        System.out.print("enter id student : ");
        int idS=input.nextInt();
        StudentDao st = new StudentDao();
        
        if( st.print(idS)==false )
            return;
        
        System.out.println("enter id teacher ");
        int idT=input.nextInt();
        TeacherDao td = new TeacherDao();
        
        if(td.print(idT)==true )
            stdo.insertStudentTeacher(idS, idT);
    }
    
    private void deleteCourse() throws Exception{
        System.out.print("enter id student : ");
        int idS=input.nextInt();
        StudentDao st = new StudentDao();
        
        if( st.print(idS)==false )
            return;
        
        System.out.println("enter id teacher ");
        int idT=input.nextInt();
        TeacherDao td = new TeacherDao();
        
        if(td.print(idT)==true )
            stdo.delete(idS, idT);
            
    }
    
}
