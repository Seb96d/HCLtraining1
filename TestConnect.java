import java.sql.*;
import java.util.Scanner;

public class TestConnect {


    public static void main(String[] args){
        try{
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/persons","root","root1");

            Statement st = con.createStatement();
            // Show all users names from users table
            ResultSet rs = st.executeQuery("select * from users");

            while(rs.next()){
                System.out.println(rs.getString("Name"));
            }

            Scanner scanner = new Scanner(System.in);
            //User login system

            while(true){
                System.out.println("Username: \n");

                String inputUsername = scanner.nextLine();
                inputUsername = inputUsername.trim();

                System.out.println("Password: \n");

                String inputPassword = scanner.nextLine();
                inputPassword = inputPassword.trim();

                boolean usernameIsValid = false;

                if(usernameIsValid){
                    ResultSet rs1 = st.executeQuery("select Name, Password from users where Name = '"
                            + inputUsername + "' and Password = '" + inputPassword + "'");
                    while(rs.next()){
                        System.out.println("The user that you logged is " + inputUsername + "and his password is " + inputPassword);
                    }
                }
            }


        }catch(Exception e) {
            System.out.println(e);
        }
    }
}
