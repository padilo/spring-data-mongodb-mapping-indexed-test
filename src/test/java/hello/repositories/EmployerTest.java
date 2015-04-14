package hello.repositories;

import com.mongodb.DBObject;
import com.mongodb.Mongo;
import hello.Application;
import hello.MongoEmbeddedConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

/**
 * Created by pdiaz on 13/04/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {MongoEmbeddedConfiguration.class, Application.class})
public class EmployerTest {
    @Autowired
    private Mongo mongo;

    @Test
    public void testFindOne() {
        List<DBObject> indexesFull = mongo.getDB("test").getCollection("employer").getIndexInfo();

        // Returns a List of indexes, each index is a list of fields (without the order)
        List<List<String>> indexes = indexesFull.stream()
                .map(dbObject -> (DBObject) dbObject.get("key"))
                .map(keys -> new ArrayList<>(keys.keySet()))
                .collect(Collectors.toList());

        assertThat("Index on firstName should exists",
                indexes,
                containsInAnyOrder(Collections.singletonList("firstName"), Collections.singletonList("_id"))
        );

    }

}
