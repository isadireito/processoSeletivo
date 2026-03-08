package processoSeletivo.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import src.Student;  

public class StudentTest {

    @Test
    void trueIfStudentsIsOn() {
        Student student = new Student("Laura", "105457", "9999", "laura@gmail.com", null, "Ativo");
        assertTrue(student.canCreateUffMail());
    }

    @Test
    void cantCreateUffMail() {
        Student student = new Student("Joao", "123", "999", "joao@gmail.com", null, "Inativo");
        assertFalse(student.canCreateUffMail());
    }
}

