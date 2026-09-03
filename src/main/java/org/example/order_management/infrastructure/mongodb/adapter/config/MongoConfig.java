package org.example.order_management.infrastructure.mongodb.adapter.config;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@Profile("mongodb")
@EnableMongoRepositories(basePackages = "org.example.order_management.infrastructure.mongodb.repository")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "order_management_db";  // Replace with your MongoDB database name
    }

    @Bean
    public MongoDatabase mongoDatabase() {
        return MongoClients.create(getConnectionString()).getDatabase(getDatabaseName());
    }

    private String getConnectionString() {
        return "mongodb://localhost:27017/" + getDatabaseName();  // Change if needed
    }
}
