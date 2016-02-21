package com.example.Services;

import com.example.Config.MySQLConfig;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class NewService {

//DATE MAGIC
   // java.util.Date utilDate = new java.util.Date();
    // System.out.println("Util date in Java : " + utilDate);
    // contains only date information without time
    // java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    // System.out.println("SQL date in Java : " + sqlDate);

//TIME MAGIC
    //PreparedStatement pstmt = conn.prepareStatement(INSERT_RECORD);
//    java.sql.Time sqlDate = new java.sql.Time(new java.util.Date().getTime());
//    pstmt.setTime(2, sqlDate);

    @RequestMapping("/sql")
    public Map<String, ArrayList<String>> getAllRegistrations() {
        MySQLConfig mySQLConfig = new MySQLConfig();
        mySQLConfig.connect();

        ArrayList<String> result; // = new ArrayList<String>();
        result = mySQLConfig.selectTest("");

        ArrayList<String> databaseValues;
        Map<String, ArrayList<String>> dataFromDatabase = new HashMap<String, ArrayList<String>>();
        for (String s : result) {
            String[] split = s.split(";");
            databaseValues = new ArrayList<String>();
            databaseValues.add(split[1]);
            databaseValues.add(split[2]);

            dataFromDatabase.put(split[0], databaseValues);
        }

        mySQLConfig.closeConnection();
        return dataFromDatabase;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public void doSmth(String id, String name, String surname) {
        MySQLConfig mySQLConfig = new MySQLConfig();
        mySQLConfig.connect();
        mySQLConfig.insertTest(Integer.parseInt(id),name,surname);
        mySQLConfig.closeConnection();
    }
    @RequestMapping(value = "/US1/{id}/{name}/{surname}", method = RequestMethod.PUT)
    public void putInTest(@PathVariable String id, @PathVariable String name, @PathVariable String surname) {
        MySQLConfig mySQLConfig = new MySQLConfig();
        mySQLConfig.connect();
        mySQLConfig.insertTest(Integer.parseInt(id),name,surname);
        mySQLConfig.closeConnection();
    }

    @RequestMapping(value = "/US2/{name}/{surname}/{tel}/{email}/{bank}/{date}/{subject}/{message}", method = RequestMethod.PUT)
    public void putInRegistrations(
            @PathVariable String name, @PathVariable String surname, @PathVariable String tel,
            @PathVariable String email, @PathVariable String bank, @PathVariable String date,
            @PathVariable String subject, @PathVariable String message)
    {
        MySQLConfig mySQLConfig = new MySQLConfig();
        mySQLConfig.connect();

        date += " 12:00";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Date parsed = null;
        try {
            parsed = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
        java.sql.Time sqlTime = new java.sql.Time(parsed.getTime());

        mySQLConfig.insertRegistrations(1,name,surname,tel,email,bank,sqlDate,sqlTime,subject,message);
        mySQLConfig.closeConnection();
    }


}
