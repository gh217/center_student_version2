package Controller;

import Model.Student;
import Service.StudentServiceImp;
import java.util.Scanner;


public class StudentControl {
    
    private Scanner input = new Scanner(System.in);
    private StudentServiceImp stsr = new StudentServiceImp();
    
    
    public void studentConsole() throws Exception{
        System.out.println("\n\t\t\tadd new student   --> 1 ");
        System.out.println("\t\t\tdelete student   ---> 2 ");
        System.out.println("\t\t\tprint student    ---> 3 ");
        System.out.println("\t\t\tupdate name      ---> 4 ");
        System.out.println("\t\t\tupdate phone     ---> 5 ");
        System.out.println("\t\t\tupdate level     ---> 6 ");
        
        switch(input.nextInt()){
            case 1 : this.insertStudent(); break;
            case 2 : this.delete(); break;
            case 3 : this.print(); break;
            case 4 : this.updateName(); break;
            case 5 : this.updatePhone(); break;
            case 6 : this.updateLevel(); break;
        }
    }
    
    
    private void insertStudent() throws Exception{
        
        System.out.println("\n ----**** add new student ****----");
        Student stu = new Student();
        System.out.print("enter id   : ");
        stu.setId(input.nextInt());
        
        // to check if 
        if( stu.getId()==0)
            return;
        
        Scanner in = new Scanner(System.in);
        System.out.print("enter name  : ");
        stu.setName(in.nextLine());
        
        System.out.print("enter level : ");
        stu.setLevel(input.nextInt());
        
        System.out.println("have phone 1 no 0 ");
        if(input.nextInt()==1){
            System.out.print("enter phone : ");
            stu.setPhone(input.next());
            
            /// if number have char throw exception
            int x = Integer.parseInt(stu.getPhone());
        }else
            stu.setPhone(null);
     
        stsr.insertStudent(stu);
    }
 
    private void delete()throws Exception{

        System.out.println("\n ----**** delete student ****----");

        System.out.println("enter id : ");
        stsr.delete(input.nextInt());
    }
    
    private void print() throws Exception{
        System.out.println("\nenter id : ");
        stsr.print(input.nextInt());
    }
    
    private void print(int id ) throws Exception{
        stsr.print(id);
    }
    
    public void updateName() throws Exception{
        System.out.print("\nenter id of student : ");
        int id=input.nextInt();
        this.print(id);
        
        Scanner in = new Scanner(System.in);
        System.out.print("enter new name : ");
        stsr.updateName(id, in.nextLine());
    }
    
    public void updatePhone() throws Exception {
        System.out.print("\nenter id of student : ");
        int id=input.nextInt();
        this.print(id);
        
        System.out.print("enter new phone : ");
        /// if number have char throw exception
        String phone=input.next();
        
        int x = Integer.parseInt(phone);
        stsr.updatePhone(id,phone);
    }
    
    public void updateLevel() throws Exception{
        System.out.println("\nenter id of student : ");
        int id=input.nextInt();
        this.print(id);
        
        System.out.println("\nente new level : ");
        stsr.updateLevel(id, input.nextInt());
    }
}
