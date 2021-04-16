package Controller;

import Model.Teacher;
import Service.TeacherServiceImp;
import java.sql.SQLException;
import java.util.Scanner;

public class TeacherControl {

    private Scanner input = new Scanner(System.in);
    private TeacherServiceImp tese = new TeacherServiceImp();
    
    
    public void TeacherConsole() throws  Exception{
        System.out.println("\n\t\t\tadd new teacher     --> 1 ");
        System.out.println("\t\t\tprint data teacher  --> 2 ");
        System.out.println("\t\t\tdelete  teacher     --> 3 ");
        System.out.println("\t\t\tupdate name         --> 4 ");
        System.out.println("\t\t\tupdate phone        --> 5 ");
        System.out.println("\t\t\tupdate Subject      --> 6 ");
        
        switch(input.nextInt()){
            case 1 : this.insertTeacher(); break;
            case 2 : this.print(); break;
            case 3 : this.delete(); break;
            case 4 : this.updateName(); break;
            case 5 : this.updatePhone(); break;
            case 6 : this.updateSubject(); break;
        }
    }
    
    private void insertTeacher() throws SQLException{
        Teacher tea = new Teacher();
        System.out.print("\nenter id : ");
        int id=input.nextInt();
        if(id==0)return;
        tea.setId(id);
       
        // void problem next line and next
        Scanner in = new Scanner(System.in);
        System.out.print("enter name : ");
        tea.setName(in.nextLine());
        
        System.out.print("enter object : ");
        tea.setSubject(in.nextLine());
        
        System.out.println("have phone 1 no 0 ");
        if(input.nextInt()==1){
            System.out.print("enter phone : ");
            tea.setPhone(input.next()); 
            /// if number have char throw exception
            int x = Integer.parseInt(tea.getPhone());
        }else
            tea.setPhone(null);
        
        tese.insertTeacher(tea);
    }
     
    private boolean print() throws Exception{
        System.out.print("enter id : ");
        return tese.print(input.nextInt());
    }
    
    public boolean print(int id ) throws Exception{
        return tese.print(id);
    }
    
    private void delete() throws Exception{
        System.out.print("enter id to delete it : ");
        int id=input.nextInt();
        if( id==0) return;
        if(this.print(id))
            tese.delete(id);
        else
            System.out.println("\t\tthis teacher not found\n");
    }
    
    private void updateName() throws Exception{
        System.out.print("\nenter id : ");
        int id=input.nextInt();
        if( id==0) return;
        
        if(this.print(id)){
            Scanner in = new Scanner(System.in);
            System.out.print("enter new name : ");
            tese.updateName(id, in.nextLine());
        }else
            System.out.println("\t\tthis teacher not found\n");    
    }
    
    private void updatePhone() throws Exception{
        System.out.print("\nenter id : ");
        int id=input.nextInt();
        if( id==0) return;
        
        if(this.print(id)){
            System.out.print("enter new phone : ");
            Integer phone=input.nextInt();
            tese.updatePhone(id, phone.toString());
        }else
            System.out.println("\t\tthis teacher not found\n");    
    }
    
    private void updateSubject() throws Exception{
        System.out.print("\nenter id : ");
        int id=input.nextInt();
        if( id==0) return;
        
        if(this.print(id)){
            System.out.print("enter new Subject : ");
            Scanner in = new Scanner(System.in);
            tese.updateSubject(id, in.nextLine());
        }else
            System.out.println("\t\tthis teacher not found\n");    
    }
}
