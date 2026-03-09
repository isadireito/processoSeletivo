package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class IO {

    public static Map<String, Student> readStudents(String fileName) throws IOException {
        
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

        }
        return listStudent;
    }

    public static void writeStudents(String fileName, Map<String, Student> listStudents){

        if(!listStudents.isEmpty()){
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){

                bw.write("nome,matricula,telefone,email,uffmail,status\n");

                for(Student studants: listStudents.values()){
                    bw.write(String.format("%s,%s,%s,%s,%s,%s\n",
                        studants.getName(),
                        studants.getStudentId(),
                        studants.getPhone(),
                        studants.getEmail(),
                        studants.getUffMail() == null ? "" : studants.getUffMail(),
                        studants.getStatus()
                    ));
                }

            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
