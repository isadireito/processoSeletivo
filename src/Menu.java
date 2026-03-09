package src;

import java.util.List;

public class Menu {


    public static void ShowOptions(String name, List<String> optionsUffMail ){
        System.out.printf("%s, por favor escolha uma das opções abaixo para o seu UFFMail\n", name);
        for (int i = 0; i < optionsUffMail.size(); i++) {
            System.out.printf("%d - %s%n", i + 1, optionsUffMail.get(i));
        }
    }

    public static void showConfirmation(String uffMail, String phone) {
        System.out.printf("%nA criação de seu e-mail (%s) será feita nos próximos minutos.%n", uffMail);
        System.out.printf("Um SMS foi enviado para %s com a sua senha de acesso.%n", phone);
    }
}
