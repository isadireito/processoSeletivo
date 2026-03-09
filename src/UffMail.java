package src;

import java.util.ArrayList;
import java.util.List;

public class UffMail {
    public static List<String> emailGenerate(String name){

        String[] fullName = name.toLowerCase().split(" ");
        String firstName = fullName[0];
        String lastName = fullName[fullName.length - 1];
        
        List<String> uffMailOp = new ArrayList<>();

        uffMailOp.add(String.format("%s%s@id.uff.br", firstName, lastName));
        uffMailOp.add(String.format("%s%s@id.uff.br", firstName.substring(0, 3), lastName));
        uffMailOp.add(String.format("%s%s@id.uff.br", firstName.substring(0, 1), lastName));

        if( fullName.length > 2){
            String middleName = fullName[1];
            uffMailOp.add(String.format("%s%s%s@id.uff.br", firstName, middleName.substring(0,1 ), lastName.substring(0,1 )));
            uffMailOp.add(String.format("%s_%s@id.uff.br", middleName, firstName));
        }else{
            uffMailOp.add(String.format("%s_%s@id.uff.br", lastName, firstName));
            uffMailOp.add(String.format("%s%s01@id.uff.br", firstName, lastName));
        }

        return uffMailOp;
    }
}

