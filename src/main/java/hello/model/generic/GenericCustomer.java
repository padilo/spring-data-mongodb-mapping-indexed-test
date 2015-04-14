package hello.model.generic;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public abstract class GenericCustomer<RC extends GenericCustomer> {

    @Id
    private Long id;

    @DBRef
    private RC referrer;

    @Indexed
    private String firstName;
    private String lastName;
    
    public GenericCustomer(Long id, String firstName, String lastName, RC referrer) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.referrer = referrer;
    }

    public RC getReferrer() {
        return referrer;
    }

    @Override
    public String toString() {
        return "GenericCustomer{" +
                "id=" + id +
                ", referrer=" + referrer +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

