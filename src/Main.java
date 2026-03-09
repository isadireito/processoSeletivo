package src;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main{
        
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Digite sua matrícula:");
        String studentId = keyboard.next();

        Map<String, Student> listStudents = IO.readStudents("alunos.csv");

        Student student = listStudents.get(studentId);

        if(student == null || !(student.canCreateUffMail())){
            System.out.println("Erro ao criar UFFMail");
            keyboard.close();
            return;
        }

        List<String> optionsUffMail = UffMail.emailGenerate(student.getName());
        
        Menu.ShowOptions(student.getName(), optionsUffMail); //show and validid options
        int op = keyboard.nextInt();
        if(op < 1 || op > 5){
            System.out.println("Opção inválida! Insira novamente");
            op = keyboard.nextInt();
        }
        student.setUffMail(optionsUffMail.get(op - 1));



        IO.writeStudents("alunos.csv", listStudents); //att student file
        Menu.showConfirmation(student.getUffMail(), student.getPhone());
        
        keyboard.close();

    }
}