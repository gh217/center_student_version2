package Service;

import Dao.StudentTeacherDao;

public class StudentTeacherServiceImp implements StudentTeacherService{

    StudentTeacherDao stdo = new StudentTeacherDao();
    
    @Override
    public void insertStudentTeacher(int idStudnet , int idTeacher) throws Exception {
      stdo.insertStudentTeacher(idStudnet , idTeacher);
    }

    @Override
    public void delete(int idS, int idT) throws Exception {
        stdo.delete(idS, idT);
    }
    
}
