package hellojpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A") // DTYPE에 들어가는 값
public class Album extends Item {

    private String artist;
}
