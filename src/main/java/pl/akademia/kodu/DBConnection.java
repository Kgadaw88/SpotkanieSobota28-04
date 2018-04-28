package pl.akademia.kodu;

import org.apache.commons.codec.digest.DigestUtils;
import pl.akademia.User;

import java.sql.*;

public class DBConnection {
    static Connection connect = null;

    public static void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/loginpanel?"
                            + "user=root&password=");
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    public static void insertUser(User user) {
        try {
            String sqlInsert = "INSERT INTO user (login, password, name, surname)" + " VALUES (?, ?, ?, ?);";

            PreparedStatement preparedStatement = connect.prepareStatement(sqlInsert);

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getSurname());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean authenticate(String login, String password) {
        try {
            String sqlSelect = "SELECT password FROM user WHERE login='" + login + "';";

            Statement s = connect.createStatement();

            ResultSet resultSet = s.executeQuery(sqlSelect);
            while (resultSet.next()) {
                if (DigestUtils.md5Hex(password).equals(resultSet.getString("password"))) {
                    return true;
                } else {
                    return false;
                }
//            PreparedStatement preparedStatement = connect.prepareStatement(sqlInsert);
//
//            preparedStatement.setString(1, user.getLogin());
//            preparedStatement.setString(2, user.getPassword());
//            preparedStatement.setString(3, user.getName());
//            preparedStatement.setString(4, user.getSurname());

//            preparedStatement.executeUpdate();
            }
            return false;
            } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
