package src;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {


    public static void showOptions(String name, List<String> optionsUffMail ){
        String[] fullName = name.split(" ");
        System.out.printf("%s, por favor escolha uma das opções abaixo para o seu UFFMail\n", fullName[0]);
        for (int i = 0; i < optionsUffMail.size(); i++) {
            System.out.printf("%d - %s%n", i + 1, optionsUffMail.get(i));
        }
    }

    public static int getValidOption(Scanner keyboard, int optionsMaxUffMail) {
        int op;
        while(true){
            try {
                op = keyboard.nextInt();
                if(op >= 1 && op <= optionsMaxUffMail) break;
                System.out.println("Opção inválida! Insira novamente");
            } catch(InputMismatchException e) {
                System.out.println("Digite apenas números!");
                keyboard.next(); 
            }
        }
        return op;
    }

    public static void showConfirmation(String uffMail, String phone) {
        System.out.printf("%nA criação de seu e-mail (%s) será feita nos próximos minutos.%n", uffMail);
        System.out.printf("Um SMS foi enviado para %s com a sua senha de acesso.%n", phone);
    }

}
