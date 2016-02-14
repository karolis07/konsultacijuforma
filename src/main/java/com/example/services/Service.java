package com.example.services;

import com.example.beans.Peanut;
import com.example.beans.PeanutList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Collections;

/**
 * Created by p998snc on 2016.02.10.
 */

@RestController
public class Service {

    private PeanutList peanutList;
    private PeanutList peanutListTemporary;

    @PostConstruct
    public void init() {
        peanutList = new PeanutList();
        peanutList.addPeanut(new Peanut("Karolis"));
        peanutList.addPeanut(new Peanut("Antanas"));
        peanutList.addPeanut(new Peanut("Jonas"));
        peanutList.addPeanut(new Peanut("Benas"));
        peanutList.addPeanut(new Peanut("Laura"));
    }

    @RequestMapping("/peanuts")
   public PeanutList list() {

       return peanutList;
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

    @RequestMapping(value="/peanut/{id}")
    public Peanut getPeanut(@PathVariable Long id) {
        return peanutList.getPeanuts().get(id.intValue());
    }

    @RequestMapping(value="/peanuts/sort")
    public PeanutList getSortedPeanuts() {
        Collections.sort(peanutList.getPeanuts());
        return peanutList;
    }

    @RequestMapping(value="/peanuts/3rdtask")
    public PeanutList getIdDividedByThree() {
        peanutListTemporary = new PeanutList();
        for(Peanut p : peanutList.getPeanuts()) {
            if(p.getId()%3 == 0)
            {
                peanutListTemporary.addPeanut(p);
            }
        }
        return peanutListTemporary;
    }
}
