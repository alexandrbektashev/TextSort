import com.sun.jdi.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String input = "roles:\n" +
                "Городничий\n" +
                "Аммос Федорович\n" +
                "Артемий Филиппович\n" +
                "Лука Лукич\n" +
                "textLines:\n" +
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.\n" +
                "Аммос Федорович: Как ревизор?\n" +
                "Артемий Филиппович: Как ревизор?\n" +
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.\n" +
                "Аммос Федорович: Вот те на!\n" +
                "Артемий Филиппович: Вот не было заботы, так подай!\n" +
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!";


        String text = String.valueOf(input) + "\n";
        text = text.substring(text.indexOf('\n') + 1);
        int rolesCount = 0;
        String line = "";
        ArrayList<String> roles = new ArrayList<>();
        int indexn = 0;
        String role;
        while (true){
            indexn = text.indexOf('\n');
            line = text.substring(0, indexn);
            if (line.equals("textLines:")) break;
            text = text.substring(indexn + 1);
            System.out.println(line);
            roles.add(line);
        }
        text = text.substring(text.indexOf('\n') + 1);
        int currrole = 1;
        ArrayList<String> rolesandtext = new ArrayList<String>(roles);
        while (!text.equals("")) {
            indexn = text.indexOf('\n');
            line = text.substring(0, indexn);
            text = text.substring(indexn + 1);
            role = line.substring(0, line.indexOf(':'));
            line = line.substring(line.indexOf(':') + 1);
            for (int i = 0; i < roles.size(); i++) {
                if (roles.get(i).equals(role)) {
                    rolesandtext.set(i, rolesandtext.get(i) + "\n" + currrole + ")" + line);
                    currrole ++;
                    break;
                }
            }
        }
        for (int i = 0; i < rolesandtext.size(); i++) {
            System.out.println(rolesandtext.get(i) + "\n");
        }



    }
}
