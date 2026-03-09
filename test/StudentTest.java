package processoSeletivo.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import src.Student;  

public class StudentTest {

    @Test
    void activeStudentWithoutUffMailCanCreate() {
        Student student = new Student("Laura", "105457", "9999", "laura@gmail.com", null, "Ativo");
        assertTrue(student.canCreateUffMail());
    }

    @Test
    void inactiveStudentCannotCreateUffMail() {
        Student student = new Student("Joao", "123", "999", "joao@gmail.com", null, "Inativo");
        assertFalse(student.canCreateUffMail());
    }

    @Test
    void activeStudentWithUffMailCannotCreateAnother() {
        Student student = new Student("Ana", "456", "888", "ana@gmail.com", "ana@id.uff.br", "Ativo");
        assertFalse(student.canCreateUffMail());
    }
}

