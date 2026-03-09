
import org.junit.jupiter.api.Test;
import src.IO;
import src.Student;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

public class IOTest {

    private Map<String, Student> students;

    @BeforeEach
    void setup() throws IOException {
        File temp = File.createTempFile("alunos", ".csv");
        temp.deleteOnExit();
        Files.writeString(temp.toPath(),
            "nome,matricula,telefone,email,uffmail,status\n" +
            "Luiza Fernandes Ferreira,105794,99999,luiza@gmail.com,,Ativo\n"
        );
        students = IO.readStudents(temp.getAbsolutePath());
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


