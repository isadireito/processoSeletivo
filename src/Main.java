package src;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main{
        
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        try{
            StudentService studentService = new StudentService("alunos.csv");
            System.out.println("Digite sua matrícula:");
            Student student = studentService.findStudent(keyboard.next());

            if(student == null){
                System.out.println("Erro ao criar UFFMail, aluno não matriculado");
                return;
            }else if(!(student.canCreateUffMail())){
                System.out.println("Erro ao criar UFFMail, aluno inativo ou já possui UFFMail!");
                return;
            }
            
            List<String> optionsUffMail = studentService.generateOptions(student.getName());
            Menu.showOptions(student.getName(), optionsUffMail);

            int op = Menu.getValidOption(keyboard, optionsUffMail.size());
            student.setUffMail(optionsUffMail.get(op - 1));

            studentService.assignUffMail(student, optionsUffMail.get(op - 1));
            Menu.showConfirmation(student.getUffMail(), student.getPhone());


        }catch(IOException e){
            System.err.println("Erro: arquivo 'alunos.csv' não encontrado.");
            System.exit(1);

        }finally{
            keyboard.close();
        }

    }
}