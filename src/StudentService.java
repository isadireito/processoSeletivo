package src;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class StudentService {
    
    private Map<String, Student> liststudents;
    private String fileName;

    public StudentService(String fileName) throws IOException {
        this.fileName = fileName;
        this.liststudents = IO.readStudents(fileName);
    }

    public Student findStudent(String studentId) {
        return this.liststudents.get(studentId);
    }

    public List<String> generateOptions(String name) {
        return UffMail.emailGenerate(name);
    }

    public void assignUffMail(Student student, String uffMail) {
        student.setUffMail(uffMail);
        IO.writeStudents(fileName, liststudents);
    }
}