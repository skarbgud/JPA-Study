package hellojpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B") // DTYPE에 들어가는 값
public class Book extends Item {

    private String author;
    private String isbn;
}
