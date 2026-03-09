package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class IO {

    public static Map<String, Student> readStudents(String fileName){
        
        Map<String, Student> listStudent = new HashMap<>();

        try(BufferedReader bf = new BufferedReader(new FileReader(fileName))){

            String line = bf.readLine();

            while( (line = bf.readLine()) != null ){
                String[] cols = line.split(",");

               if( cols.length == 6){     
                    Student student = new Student(cols[0].trim(), cols[1], cols[2], cols[3], cols[4], cols[5]);
                    listStudent.put(cols[1], student);
                }
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        return listStudent;
    }
}
