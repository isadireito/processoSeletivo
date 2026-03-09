
import org.junit.jupiter.api.Test;
import src.IO;
import src.Student;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;

public class IOTest {

    @Test
    void readAllStudentsCSV() {
        HashMap<String, Student> students = IO.readStudents("alunos.csv");
        assertFalse(students.isEmpty());
    }

    @Test
    void foundStudentForId() {
        HashMap<String, Student> students = IO.readStudents("alunos.csv");
        Student student = students.get("105794");
        assertNotNull(student);
        assertEquals("Luiza Fernandes Ferreira", student.getName());
    }

    @Test
    void returnNullIfIdNotExists() {
        HashMap<String, Student> students = IO.readStudents("alunos.csv");
        assertNull(students.get("000000"));
    }
}


