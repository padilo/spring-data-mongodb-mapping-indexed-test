package hello.repositories;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import hello.Application;
import hello.MongoEmbeddedConfiguration;

import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {MongoEmbeddedConfiguration.class, Application.class})
public class CustomerTest {
    @Autowired
    private Mongo mongo;

    @Test
    public void testFindOne() {
        List<DBObject> indexesFull = mongo.getDB("test").getCollection("customer").getIndexInfo();

        // Returns a List of indexes, each index is a list of fields (without the order)
        List<Collection<String>> indexes = indexesFull.stream()
                .map(dbObject -> (DBObject) dbObject.get("key"))
                .map(keys -> new ArrayList<>(keys.keySet()))
                .collect(Collectors.toList());

        assertThat("Index on firstName should exists",
                indexes,
                containsInAnyOrder(Collections.singletonList("firstName"), Collections.singletonList("_id"))
        );

    }

}
