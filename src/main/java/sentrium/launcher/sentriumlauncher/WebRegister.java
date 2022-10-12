package sentrium.launcher.sentriumlauncher;
import java.util.UUID;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WebRegister {
    //public static String Login = "test";
    //public static String Password = "test_pass";

    public static String WebAunthFunc(String Login, String Password, String Email , String RetryPassword) throws Exception {
        URL url = new URL("http://141.145.193.111/WebRegister.php");

        String UUID_DATA_A;
        String UUID_DATA;
        if (Password != RetryPassword) {
            UUID_DATA_A = String.valueOf(UUID.randomUUID());
            UUID_DATA = UUID_DATA_A.toString();
        } else {
            return "Pass dont mach";
        }

        String postData = "Login=" + Login + "&Pass=" + Password + "&Email=" + Email + "&WHID=" + UUID_DATA;

        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", Integer.toString(postData.length()));

        try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
            dos.writeBytes(postData);
        }

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(
                conn.getInputStream()))) {
            String line;
            String Full_line = "";
            while ((line = bf.readLine()) != null) {
                //System.out.println(line);
                //add line to Full_line
                Full_line = Full_line + line;


            }
            System.out.println(Full_line);
            if (Full_line == null) {
                return "Login error";

            } else {
                return Full_line;
            }
        }
    }

}
