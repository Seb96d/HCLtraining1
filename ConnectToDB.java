import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;
import java.util.Vector;
import java.util.jar.JarInputStream;
public class ConnectToDB {

    public static void main(String[] args){
        try{
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/persons","root","root1");

            Statement st = con.createStatement();
            printUsers(con);
            Scanner scanner = new Scanner(System.in);
            startWindow(con);
            logIn(scanner, con);

        }catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void printUsers(Connection con) throws SQLException {
        Statement st = con.createStatement();
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
            ResultSet rs1 = pst.executeQuery();

            boolean checker = false;

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
        }
    }

    static JButton loginB, registerB;
    static JFrame startF, registerF;
    static JTextField nameTF;
    static String nameT, passT;
    static JLabel infoL = new JLabel("");

    public static void loggedInWindow(ResultSet rs1) throws SQLException{

        JTable table = new JTable(buildTableModel(rs1));
        JOptionPane.showMessageDialog(null, new JScrollPane(table));
        startF.setLayout(null);
        startF.setSize(600,600);
//        startF.add(table);
        startF.setVisible(true);

    }

    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        Vector<String> vector = new Vector<>();
        Vector<String> columnNames = new Vector<>();
        Vector<Vector<String>> data = new Vector<>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
            vector.add(rs.getString(column));
        }
        data.add(vector);
        return new DefaultTableModel(data, columnNames);

    }

    public static void registerWindow( Connection con ) throws SQLException{
        registerF = new JFrame();
        registerF.setLayout(null);
        registerF.setSize(600,600);

        JTextField nameTF            = new JTextField();
        JTextField emailTF           = new JTextField();
        JTextField mobileTF          = new JTextField();
        JTextField genderTF          = new JTextField();
        JTextField passwordTF        = new JTextField();
        JTextField passwordConfirmTF = new JTextField();
        JLabel nameL            =          new JLabel("name");
        JLabel emailL           =         new JLabel("email");
        JLabel mobileL          =        new JLabel("mobile");
        JLabel genderL          =        new JLabel("gender");
        JLabel passwordL        =      new JLabel("password");
        JLabel passwordConfirmL =new JLabel("passwordConfirm");
        registerF.add(nameL);
        registerF.add(emailL);
        registerF.add(mobileL);
        registerF.add(genderL);
        registerF.add(passwordL);
        registerF.add(passwordConfirmL);

        nameL.setBounds(150,50,150,30);
        emailL.setBounds(150,100,150,30);
        mobileL.setBounds(150,150,150,30);
        genderL.setBounds(150,200,150,30);
        passwordL.setBounds(150,250,150,30);
        passwordConfirmL.setBounds(150,300,150,30);

        registerF.add(nameTF           );
        registerF.add(emailTF          );
        registerF.add(mobileTF         );
        registerF.add(genderTF         );
        registerF.add(passwordTF       );
        registerF.add(passwordConfirmTF);

        nameTF.setBounds(300,50,150,30);
        emailTF.setBounds(300,100,150,30);
        mobileTF.setBounds(300,150,150,30);
        genderTF.setBounds(300,200,150,30);
        passwordTF.setBounds(300,250,150,30);
        passwordConfirmTF.setBounds(300,300,150,30);

        JButton registerB = new JButton("Register");
        registerB.setBounds(250,450,100,30);
        registerF.add(registerB);
        registerF.setVisible(true);

        registerB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (PreparedStatement pstR = con.prepareStatement("insert into users " +
                        "(Name, Email, Password, Gender, Mobile ) " +
                        "values (?, ?, ?, ?, ? )")) {

                    pstR.setString(1, nameTF.getText());
                    pstR.setString(2, emailTF.getText());
                    pstR.setString(3, passwordTF.getText());
                    pstR.setString(4, genderTF.getText());
                    pstR.setString(5, mobileTF.getText());

                    pstR.executeUpdate();
                    printUsers(con);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

    public static void startWindow(Connection con) throws SQLException {
        startF = new JFrame();
        startF.setLayout(null);
        startF.setSize(600,600);
        JLabel nameL = new JLabel("Name:");
        nameL.setBounds(150,100,100,30);
        startF.add(nameL);

        JLabel passL = new JLabel("Password:");
        passL.setBounds(150,150,100,30);
        startF.add(passL);

        nameTF = new JTextField();
        nameTF.setBounds(250,100,100,30);
        startF.add(nameTF);

        JPasswordField passPF = new JPasswordField();
        passPF.setBounds(250,150,100,30);
        startF.add(passPF);

        nameTF.setText("Seb");
        passPF.setText("1234");

        infoL.setBounds(250,200, 200, 30);
        startF.add(infoL);

        loginB=new JButton("Log in");
        loginB.setBounds(250,350,100,30);
        startF.add(loginB);

        registerB=new JButton("Register");
        registerB.setBounds(250,400,100,30);
        startF.add(registerB);

        startF.setVisible(true);

        loginB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameT = nameTF.getText();
                System.out.println("Input: " + nameT);
                passT = String.valueOf(passPF.getPassword());
                System.out.println(passT);
                try {
                    logInto(nameT,passT,con);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        registerB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Input your data: ");
                try {
                    registerWindow(con);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

    }


    private static void logInto(String name, String pass, Connection con) throws SQLException {

        System.out.println("Login to system");
            System.out.println("Password: \n");

            PreparedStatement pst = con.prepareStatement("select * from users where Name = ?");
            pst.setString(1, name);

            boolean checker = false;

            ResultSet rs1 = pst.executeQuery();

            while(rs1.next()){
                checker = true;
                if(pass.equals(rs1.getString("Password"))){
                    infoL.setText("You are logged in, " + rs1.getString("Name") + "!" );
                    loggedInWindow(rs1);
                }else{
                    infoL.setText("Password incorect!");
                    registerWindow(con);
                }
            }
            if(!checker){
                infoL.setText("User doesnt exist, care to register?");
            }
        }
}
