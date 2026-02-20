import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        //Hashing the password section
        HashPassword hashPassword = new HashPassword();

        String password = "UserPass123!";
        String storedHash = hashPassword.hashPassword(password);

        System.out.println("Stored Hash Data: " + storedHash);


        //Verifying the password section

        //Creating a verifyPassword class object
        VerifyPassword verify = new VerifyPassword();

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter password: ");

        String user_input = input.nextLine();

        try {

            //compares the user password and the hash data
            boolean isPass_Match = verify.verifyPassword(user_input, storedHash);
            System.out.println(isPass_Match);

            //if statement checks if the password is correct and display an output
            if (isPass_Match) {
                System.out.println("Correct Password Match, Welcome User");
            } else {
                System.out.println("Incorrect Password, try again!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}