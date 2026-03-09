package src;

import java.util.ArrayList;
import java.util.List;

public class UffMail {

    private static final String DOIMAN = "@id.uff.br";

    
    public static List<String> emailGenerate(String name){

        String[] fullName = name.toLowerCase().split(" ");
        String firstName = fullName[0];
        String lastName = fullName[fullName.length - 1];
        
        List<String> uffMailOp = new ArrayList<>();

        uffMailOp.add(String.format("%s%s%s", firstName, lastName, DOIMAN));
        uffMailOp.add(String.format("%s%s%s", firstName.substring(0, 3), lastName,  DOIMAN));
        uffMailOp.add(String.format("%s%s%s", firstName.substring(0, 1), lastName, DOIMAN));

        if( fullName.length > 2){
            String middleName = fullName[1];
            uffMailOp.add(String.format("%s%s%s%s", firstName, middleName.substring(0,1 ), lastName.substring(0,1 ), DOIMAN));
            uffMailOp.add(String.format("%s_%s%s", middleName, firstName, DOIMAN));
        }else{
            uffMailOp.add(String.format("%s_%s%s", lastName, firstName, DOIMAN));
            uffMailOp.add(String.format("%s%s01%s", firstName, lastName, DOIMAN));
        }

        return uffMailOp;
    }
}

