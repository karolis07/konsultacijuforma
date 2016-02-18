package com.example.DB;

import com.example.Us1BTeamApplication;

/**
 * Created by Karolis on 2016.02.18.
 */
public class Main {
    public static void main(String[] args)
    {
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.register(MongoDBConfig.class);
//        ctx.refresh();
//        EmployeeRepository employeeRepository = ctx.getBean(EmployeeRepository.class);
//        Employee ram = new Employee(1,"Ram",20);
//        Employee shyam = new Employee(2,"Shyam",19);
//        Employee mohan = new Employee(3,"Mohan",20);
//        Employee krishn = new Employee(4,"Krishn",20);
//        //Delete if exists already
//        employeeRepository.deleteAll();
//        //Save employee
//        employeeRepository.save(ram);
//        employeeRepository.save(shyam);
//        employeeRepository.save(mohan);
//        employeeRepository.save(krishn);
//        //Get employee By Name
//        Employee emp = employeeRepository.getEmployeeByName(shyam.name);
//        System.out.println(emp.name);
        //Fetch all employee for the age
//        List<Employee> employees = employeeRepository.getEmployeeByAge(20);
//        System.out.println("----employee for the age 20----");
//        for (Employee employee : employees) {
//            System.out.println("Id:"+employee.id+",Name:"+employee.name);
//        }

        Us1BTeamApplication.runSpring(args);

    }
}
