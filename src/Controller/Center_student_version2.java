package Controller;

import java.util.Scanner;


public class Center_student_version2 {
   
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        
        StudentControl stco = new StudentControl();
        TeacherControl tea = new TeacherControl();
        TeacherLevelControl tlc = new TeacherLevelControl();
        StudentTeacherControl stc = new StudentTeacherControl();
        boolean flag=true;
        
        try {
            while(flag){
                flag=false;
                
                // student or teacher
                int choose=start();
            
                switch(choose){
                   // student
                    case 1 : {
                        switch(studentChoose()){
                            case 1 : stco.studentConsole(); break;  // personal
                            case 2 : stc.studentTeacherConsole(); break;
                        }
                    }break;
                    case 2: {
                        switch(TeacherChoose()){
                            case 1 : tea.TeacherConsole(); break;  // personal
                            case 2 : tlc.TeacherLevelConsole(); break;
                        }
                    }break;
                }
                
                if(mainMenu())
                    flag=true;
                System.out.println("");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }       
    }
    
    public static int start(){
        System.err.println("\t\t\tstudent ---> 1");
        System.err.println("\t\t\tteacher ---> 2");
        return input.nextInt();
    }
    
    /// go to main menu or exit
    public static boolean mainMenu(){
        System.out.println("\n\t\t\tmain menu --> 1 ");
        System.out.println("\t\t\t   exit   --> 0 ");   
        return input.nextInt()==1;
    }
    
    public static int studentChoose(){
        System.err.println("\npersonal information  ---> 1 ");
        System.err.println("student level         ---> 2 ");
        return input.nextInt();
    }
    
    public static int TeacherChoose(){
        System.err.println("\npersonal information ---> 1 ");
        System.err.println("teacher level        ---> 2 ");
        return input.nextInt();
    }
}
