package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Title: <br/>
 * Description: <br/>
 * Copyright: 2024 <br/>
 * Company:<br/>
 * Project: design-pattern <br/>
 *
 * @Author huanglian <br/>
 * Create Time:12/25/24 15:08 <br/>
 */
public class CreateSql {
    private static final String SQL = "INSERT INTO R_SYS_ROLE_MENU (\"ROLE_ID\", \"MENU_ID\", \"TENANT_ID\") " +
            "VALUES ('%s', '%s', '%s');";
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/huanglian/Desktop/design/design-pattern/src/main/resources/file/map.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] s = line.split("\t");
                map.put(s[1], s[0]);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("/Users/huanglian/Desktop/design/design-pattern/src/main/resources/file/insert_sql.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] s = line.split("\t");

                System.out.printf(
                        (SQL) + "%n",
                        map.getOrDefault(s[2], s[0]), s[1], s[2]
                );
//                System.out.println(Arrays.toString(s));
            }



        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
