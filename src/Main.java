import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        //Hashing the password
        HashPassword hashPassword = new HashPassword();

        Scanner userPass = new Scanner(System.in);
        System.out.println("Please, enter password");

        String password = userPass.nextLine() ;
        String storedHash = hashPassword.hashPassword(password);

        System.out.println("Stored Hash Data: " + storedHash);



    }
}