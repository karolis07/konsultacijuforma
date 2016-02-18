package com.example.Service;

import com.example.DB.Employee;
import com.example.DB.EmployeeRepository;
import com.example.beans.Peanut;
import com.example.beans.PeanutList;
import com.example.config.MongoDBConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;


@RestController
class newService {

    private PeanutList peanutList;
    private EmployeeRepository employeeRepository;

    @PostConstruct
    public void init() {
//        peanutList = new PeanutList();
//        peanutList.addPeanut(new Peanut("Karolis"));
//        peanutList.addPeanut(new Peanut("Antanas"));
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MongoDBConfig.class);
        ctx.refresh();
        employeeRepository = ctx.getBean(EmployeeRepository.class);
    }

    @RequestMapping("/peanuts")
    public List<Employee> list() {
        List<Employee> employees = employeeRepository.getEmployeeByAge(20);

//        for (Employee employee : employees) {
//            System.out.println("Id:"+employee.id+",Name:"+employee.name);
//        }

        return employees;
    }

    @RequestMapping(value="/peanuts", method = RequestMethod.PUT)
    public void create(String name) {
        peanutList.addPeanut(new Peanut(name));
    }

    @RequestMapping(value="/peanuts/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        Peanut toRemove = null;
        for(Peanut p : peanutList.getPeanuts()) {
            if(p.getId() == id) {
                toRemove = p;
            }
        }

        if(toRemove != null)
            peanutList.getPeanuts().remove(toRemove);

    }

}
