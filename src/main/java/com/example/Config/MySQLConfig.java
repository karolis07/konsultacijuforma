package com.example.Config;


import java.sql.*;
import java.util.ArrayList;

public class MySQLConfig {
    private String url = "jdbc:mysql://127.11.130.2:3306/";
    private String dbName = "swedbank";
    private String driver = "com.mysql.jdbc.Driver";
    private String userName = "adminMY4mu4d";
    private String password = "rISkSPUHab69";

    private Connection conn;
    private Statement st;

    public boolean connect()
    {
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            st = conn.createStatement();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String> selectTest(String query) {
        ArrayList<String> result = new ArrayList<String>();
        String line = "";

        if (query.equals(""))
            query = "SELECT * FROM Test";

        try {
            ResultSet res = st.executeQuery(query);
            while (res.next()) {
                int id = res.getInt("ID");
                String name = res.getString("name");
                String surname = res.getString("surname");
                line = String.valueOf(id) + ";" + name + ";" + surname;
                result.add(line);
            }
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }

        return result;
    }

    public void insertTest(int id, String name, String surname) {
        String query = String.format("insert into Test(id, name, surname)" +
                        "values(\"%d\",\"%s\", \"%s\");\n",
                id, name, surname);
        try {
            int value = st.executeUpdate(query);
            if (value == 1)
                System.out.println("Successfully inserted value");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertRegistrations(
            int userID, String name, String surname,
            String tel, String email, String bank,
            Date date, String subject, String message ) {
        String query = String.format("INSERT INTO REGISTRATIONS (UserID,Name,Surname,PhoneNo,EMail,BankDepartment,RegistrationDate,RegistrationTime,DropDownList,Message)" +
                        "values(\"%d\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%D\", \"%T\", \"%s\", \"%s\");\n",
                userID, name, surname, tel, email, bank, date, "00:00:00", subject, message);
        try {
            int value = st.executeUpdate(query);
            if (value == 1)
                System.out.println("Successfully inserted value");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


