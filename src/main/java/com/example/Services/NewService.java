package com.example.Services;

import com.example.Config.MySQLConfig;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class NewService {

//    @RequestMapping(value = "/US1/{dropDownItem}/{textMessage}/{name}/{surname}/{phoneNr}/{email}/{answerType}/", method = RequestMethod.PUT)
//    public void putContactUs(@PathVariable String dropDownItem,
//                             @PathVariable String textMessage,
//                             @PathVariable String name,
//                             @PathVariable String surname,
//                             @PathVariable String phoneNr,
//                             @PathVariable String email,
//                             @PathVariable String answerType) {
//        MySQLConfig mysqlConfig = new MySQLConfig();
//        mysqlConfig.connect();
//        mysqlConfig.insertContactUsbigTable(dropDownItem, textMessage, answerType, name, surname, phoneNr, email);
//        mysqlConfig.closeConnection();
//    }

//    @RequestMapping(value = "/US1/{dropDownItem}/{textMessage}/{name}/{phoneNr}/{email}/{answerType}/", method = RequestMethod.PUT)
//    public void putContactUs(@PathVariable String dropDownItem,
//                             @PathVariable String textMessage,
//                             @PathVariable String name,
//                             @PathVariable String phoneNr,
//                             @PathVariable String email,
//                             @PathVariable String answerType) {
//        putContactUs(   dropDownItem,
//                textMessage,
//                name,
//                "",
//                phoneNr,
//                email,
//                answerType);
//    }

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
}
