import com.sun.jdi.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String[] myroles = new String[]{"igor", "ivan", "alex", "masha"};
        String[] mytext = new String[]{"igor:sentence", "alex:sliva", "alex:persik",
                "masha:haha how about that much anticipated sport match last night",
        "ivan: chtoooo???"};

        System.out.println(printTextPerRole(myroles,mytext));
    }

    private static String printTextPerRole(String[] roles, String[] textLines) {

        int currole = 1;
        StringBuilder[] rolesandtext = new StringBuilder[roles.length];
        for (int i = 0; i < roles.length; i++)
            rolesandtext[i] = new StringBuilder(roles[i] + "\n");
        StringBuilder text = new StringBuilder();
        try {
            for (int i = 0; i < textLines.length; i++) {
                int indexsep = textLines[i].indexOf(':');
                String role = textLines[i].substring(0, indexsep);
                String line = textLines[i].substring(indexsep + 1);
                for (int j = 0; j < roles.length; j++) {
                    if (role.equals(roles[j])) {
                        rolesandtext[j].append(currole + ")" + line + "\n");
                        currole++;
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }



        StringBuilder finaltext = new StringBuilder();
        for (StringBuilder sb : rolesandtext)
            finaltext.append(sb + "\n");

        return finaltext.toString();
    }

}
