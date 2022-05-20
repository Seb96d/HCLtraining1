import java.sql.*;
import java.util.Scanner;

public class DioDB {


    public static void main(String[] args){
        try{
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/persons","root","root1");


            Scanner scanner = new Scanner(System.in);


            while(true) {
                //Selecting an option between register and login
                System.out.println("What would you like to do?(" +
                        "1 - register new user, " +
                        "2 - login , " +
                        "3 - logout user, " +
                        "4- show all users\n");

                int inputOption = scanner.nextInt();

                switch (inputOption) {
                    //register
                    case 1:
                        System.out.println("You decided to register a new user");

                        String buforr = scanner.nextLine();

                        System.out.println("Username: ");
                        String inputUsernameRegister = scanner.nextLine();
                        inputUsernameRegister = inputUsernameRegister.trim();

                        System.out.println("Name: ");
                        String inputName = scanner.nextLine();
                        inputName = inputName.trim();

                        System.out.println("Email: ");
                        String inputEmail = scanner.nextLine();
                        inputEmail = inputEmail.trim();

                        System.out.println("Password: ");
                        String inputPasswordRegister = scanner.nextLine();
                        inputPasswordRegister = inputPasswordRegister.trim();

                        System.out.println("Gender: ");
                        String inputGender = scanner.nextLine();
                        inputGender = inputGender.trim();


                        PreparedStatement pstR = con.prepareStatement("insert into task " +
                                "(Username, Name, Email, Password, Gender) " +
                                "values (?, ?, ?, ?, ? )");

                        pstR.setString(1, inputUsernameRegister);
                        pstR.setString(2, inputName);
                        pstR.setString(3, inputEmail);
                        pstR.setString(4, inputPasswordRegister);
                        pstR.setString(5, inputGender);

                        pstR.executeUpdate();

                        //while(rs2.next()){
                        //    System.out.println("New user registered!");
                        //}

                        System.out.println("New user registered!");
                        break;

                    //login
                    case 2:
                        String buforl = scanner.nextLine();
                        System.out.println("Username: \n");

                        String inputUsername = scanner.nextLine();
                        inputUsername = inputUsername.trim();

                        System.out.println("Password: \n");

                        String inputPassword = scanner.nextLine();
                        inputPassword = inputPassword.trim();


                        PreparedStatement pst = con.prepareStatement("select * from task where Username = ?");
                        pst.setString(1, inputUsername);

                        boolean checker = false;

                        ResultSet rs1 = pst.executeQuery();

                        while (rs1.next()) {
                            checker = true;
                            if (inputPassword.equals(rs1.getString("Password"))) {
                                System.out.println("YOu successfully logged in " + rs1.getString("Name") + "!");
                                pst = con.prepareStatement("update task SET IsLoggedIn = true WHERE Username = '"
                                        + inputUsername + "'");
                                pst.executeUpdate();
                            } else {
                                System.out.println("Password incorect!");
                            }
                        }
                        if (!checker) {
                            System.out.println("user doesnt exist!");
                        }
                        break;
                    //Logout
                    case 3:
                        String buforrr = scanner.nextLine();
                        System.out.println("Which user you would like to logout?");
                        String inputUsernameToLogout = scanner.nextLine();
                        inputUsernameToLogout = inputUsernameToLogout.trim();

                        PreparedStatement pst2 = con.prepareStatement("select * from task where Username = ?");
                        pst2.setString(1, inputUsernameToLogout);

                        ResultSet rs3 =pst2.executeQuery();

                        while(rs3.next()){
                            if(inputUsernameToLogout.equals(rs3.getString("Username")))
                                pst2 = con.prepareStatement("update task SET IsLoggedIn = false WHERE Username = '" +
                                        inputUsernameToLogout + "'");
                        }


                        break;
                    //show all users
                    case 4:
                        Statement st = con.createStatement();
                        // Show all users names from users table
                        ResultSet rs = st.executeQuery("select * from task");

                        while(rs.next()){
                            System.out.println(
                                    rs.getString("Name") +
                                            rs.getString("Username") +
                                            rs.getString("Email") +
                                            rs.getString("Gender") +
                                            rs.getString("IsLoggedIn"));
                        }
                        break;
                    default:
                        System.out.println("You wrote the wrong input!");
                }
            }
        }catch(Exception e) {
            System.out.println(e);
        }
    }
}