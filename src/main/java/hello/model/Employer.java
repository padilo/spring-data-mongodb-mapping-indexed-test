package hello.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by pdiaz on 13/04/2015.
 */
@Document
public class Employer {

    @Id
    private Long id;

    @DBRef
    private Employer referrer;

    @Indexed
    private String firstName;
    private String lastName;

    public Employer(Long id, String firstName, String lastName, Employer referrer) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.referrer = referrer;
    }

    public Employer getReferrer() {
        return referrer;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", referrer=" + referrer +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
