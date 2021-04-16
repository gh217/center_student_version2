
package Service;


public interface StudentTeacherService {
    
    public void insertStudentTeacher(int idStudnet , int idTeacher) throws Exception;
    
    public void delete(int idS , int idT) throws Exception;
    
}
