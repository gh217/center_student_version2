
package Controller;


import Dao.TeacherDao;
import Dao.TeacherLevelDao;
import Model.TeacherLevel;
import Service.TeacherLevelImp;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class TeacherLevelControl {
    
    private Scanner input = new Scanner(System.in);
    private TeacherLevelImp ti = new TeacherLevelImp();
    PreparedStatement state;
    
    
    public void TeacherLevelConsole() throws Exception{
        System.out.println("\n\t\t\tadd level      --> 1 ");
        System.out.println("\t\t\tdelete level   --> 2 ");
        System.out.println("\t\t\tprint level    --> 3 ");
        System.out.println("\t\t\tupdate price   --> 4 ");
        System.out.println("\t\t\tupdate level   --> 5 ");
        
        switch(input.nextInt()){
            case 1 : this.insertTeacherlevel(); break;
            case 2 : this.deleteLevel(); break;
            case 3 : this.print(); break;
            case 4 : this.updatePrice(); break;
            case 5 : this.updateLevel(); break;
        }
    }
    
    private void insertTeacherlevel() throws Exception{
        TeacherLevel tele= new TeacherLevel();
        
        System.out.print("enter id teacher : ");
        int idT=input.nextInt();
        tele.setId(idT);
        
        TeacherDao td = new TeacherDao();
        
        if(td.print(idT)==false ){
            System.out.println("\t\t not found ");
            return;
        }    
        
        boolean flag=true;
        while(flag){
            System.out.println("\nenter 0 to exit");
            System.out.print("enter level      : ");
            int level=input.nextInt();
            if(level==0) return;
            tele.setLevel(level);

            System.out.print("enter price      : ");
            tele.setPrice(input.nextFloat());

            ti.insertTeacherLevel(tele);
         
            System.out.println("\n\t to add anoter course enter 1 to exit enter 0 ");
            flag=input.nextInt()==1;
        }
        
    }
    
    private void deleteLevel() throws Exception{
        System.out.print("enter id    : ");
        int id=input.nextInt();
        
        System.out.print("enter level : ");
        int level=input.nextInt();
        // if teacher found 
        if( TeacherLevelDao.checkIdLevel(id, level))
            ti.deleteLevel(id, level);
    }
    
    private void print() throws Exception{
        System.out.print("\nenter id teacher : ");
        ti.print(input.nextInt());
    }
    
    private void updatePrice() throws SQLException{
        System.out.print("enter id    : ");
        int id=input.nextInt();
        
        System.out.print("enter level : ");
        int level=input.nextInt();
        // if teacher found 
        if( TeacherLevelDao.checkIdLevel(id, level)){
            System.out.print("\nenter new price : ");
            ti.updateprice(id, input.nextFloat(), level);
        }
    }
    
    public void updateLevel() throws Exception{
        System.out.print("enter id    : ");
        int id=input.nextInt();
        
        System.out.print("enter level : ");
        int level=input.nextInt();
        
        if( TeacherLevelDao.checkIdLevel(id, level)){
            System.out.print("enter new level : ");
            ti.updateLevel(id, level,input.nextInt());
        }else
            System.out.println("\t not found this level");
    }
}
