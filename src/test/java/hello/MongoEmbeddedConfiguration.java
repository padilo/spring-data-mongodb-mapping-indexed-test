package hello;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.mongodb.Mongo;

import cz.jirutka.spring.embedmongo.EmbeddedMongoBuilder;

@Configuration
public class MongoEmbeddedConfiguration {

    @Bean(destroyMethod = "close")
    public Mongo mongo() throws IOException, InterruptedException {
        return new EmbeddedMongoBuilder()
                .version("2.6.5")
                .bindIp("127.0.0.1")
                .build();
    }

}
