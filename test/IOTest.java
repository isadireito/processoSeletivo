
import org.junit.jupiter.api.Test;
import src.IO;
import src.Student;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import java.util.Map;

public class IOTest {

    private Map<String, Student> students;

    @BeforeEach
    void setup() {
        students = IO.readStudents("alunos.csv");
    }

    @Test
    void readAllStudentsCSV() {
        assertFalse(students.isEmpty());
    }

    @Test
    void foundStudentForId() {
        Student student = students.get("105794");
        assertNotNull(student);
        assertEquals("Luiza Fernandes Ferreira", student.getName());
    }

    @Test
    void returnNullIfIdNotExists() {
        assertNull(students.get("000000"));
    }
}


