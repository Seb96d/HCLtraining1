import java.sql.*;
import java.util.Scanner;

public class MdBb {


    public static void main(String[] args){
        try{
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/persons","root","root1");

            Statement st = con.createStatement();
            // Show all users names from users table


            Scanner scanner = new Scanner(System.in);

            printUsers(con);
            logIn(scanner, con);


        }catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void printUsers(Connection con) throws SQLException {
        Statement st = con.createStatement();
        // Show all users names from users table
        ResultSet rs = st.executeQuery("select * from users");

        while(rs.next()){
            System.out.println(rs.getString("Id") + "\t| " + rs.getString("Name"));
        }
    }

    public static void logIn(Scanner scanner,Connection con) throws SQLException {
        System.out.println("Login to system");
        while(true){
            System.out.println("Name: \n");

            String inputName = scanner.nextLine();
            inputName = inputName.trim();

            System.out.println("Password: \n");

            String inputPassword = scanner.nextLine();
            inputPassword = inputPassword.trim();


            PreparedStatement pst = con.prepareStatement("select * from users where Name = ?");
            pst.setString(1, inputName);

            boolean checker = false;

            ResultSet rs1 = pst.executeQuery();

            while(rs1.next()){
                checker = true;
                if(inputPassword.equals(rs1.getString("Password"))){
                    System.out.println("You are logged in, " + rs1.getString("Name") + "!" );
                    break;
                }else{
                    System.out.println("Password incorect!");
                }
            }
            if(!checker){
                System.out.println("User doesnt exist!");
            }

            //default:
            //    System.out.println("You wrote the wrong input!");
        }

    }


}
