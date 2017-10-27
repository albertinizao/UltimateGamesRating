package com.opipo.ultimategamesrating;

import com.github.fakemongo.Fongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@EnableAutoConfiguration(exclude = {EmbeddedMongoAutoConfiguration.class, MongoAutoConfiguration.class,
        MongoDataAutoConfiguration.class})
@Configuration
@ComponentScan(basePackages = {"com.opipo.ultimategamesrating"}, excludeFilters = {
        @ComponentScan.Filter(classes = {SpringBootApplication.class})})
public class UltimateGamesRatingApplicationConfig extends AbstractMongoConfiguration {
    @Autowired
    private Environment env;

    @Override
    protected String getDatabaseName() {
        return "myDB";
    }

    @Override
    public com.mongodb.MongoClient mongoClient() {
        return new Fongo(getDatabaseName()).getMongo();
    }
}
