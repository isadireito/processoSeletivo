

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import src.UffMail;

public class UffMailTest {
    
    @Test
    void fiveOptionsGenerate(){
        List<String> students = UffMail.emailGenerate("Luiza Fernandes Ferreira");
        assertEquals(5, students.size());
    }

    @Test
    void domainIsCorrect(){
        List<String> students = UffMail.emailGenerate("Luiza Fernandes Ferreira");
        for(String student : students ){
            assertTrue(student.endsWith("@id.uff.br"));
        }
    }

    @Test
    void optionsContainStudentName(){
        List<String> students = UffMail.emailGenerate("Luiza Fernandes Ferreira");
        boolean containStudentName = students.stream()
                .anyMatch(s -> s.contains("luiza") || s.contains("fernandes") || s.contains("ferreira"));
            assertTrue(containStudentName);
    }

}
