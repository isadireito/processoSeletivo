package src;

import java.util.ArrayList;
import java.util.List;

public class UffMail {

    private static final String DOMAIN = "@id.uff.br";

    
    public static List<String> emailGenerate(String name){

        String[] fullName = name.toLowerCase().split(" ");
        String firstName = fullName[0];
        String lastName = fullName[fullName.length - 1];
        
        List<String> uffMailOp = new ArrayList<>();

        uffMailOp.add(String.format("%s%s%s", firstName, lastName, DOMAIN));
        uffMailOp.add(String.format("%s%s%s", firstName.substring(0, 3), lastName,  DOMAIN));
        uffMailOp.add(String.format("%s%s%s", firstName.substring(0, 1), lastName, DOMAIN));

        if( fullName.length > 2){
            String middleName = fullName[1];
            uffMailOp.add(String.format("%s%s%s%s", firstName, middleName.substring(0,1 ), lastName.substring(0,1 ), DOMAIN));
            uffMailOp.add(String.format("%s_%s%s", middleName, firstName, DOMAIN));
        }else{
            uffMailOp.add(String.format("%s_%s%s", lastName, firstName, DOMAIN));
            uffMailOp.add(String.format("%s%s01%s", firstName, lastName, DOMAIN));
        }

        return uffMailOp;
    }
}

