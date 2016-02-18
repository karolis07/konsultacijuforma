package com.example.config;

import com.example.DB.EmployeeRepository;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Karolis on 2016.02.18.
 */
@Configuration
@EnableMongoRepositories(basePackages="com.example" )
public class MongoDBConfigRedHat {
    @Autowired
    EmployeeRepository employeeRepository;
    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        MongoClient mongoClient = new MongoClient("localhost",27017);
        UserCredentials userCredentials = new UserCredentials("admin","QapjnAGeiw1E");
        return new SimpleMongoDbFactory(mongoClient, "concretepage",userCredentials);
    }
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }
}
