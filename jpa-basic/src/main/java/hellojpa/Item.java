package hellojpa;

import javax.persistence.*;

// 기본적으로 상속을 하게 되면 싱글테이블 전략으로 한개의 테이블로 모든 컬럼이 세팅된다 * @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
//@Inheritance(strategy = InheritanceType.JOINED) // 객체에 맞게 상속된 각 Entity별로 테이블이 생성된다.
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn // DTYPE이라는 컬럼이 생기게 된다.(엔티티명이 default로 들어가게 된다.) => 단일 테이블 전략의 경우에 기본적으로 생성이 된다.
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // ITEM 테이블 자체가 생성X, 컬럼 모든것을 상속받아서 사용
public abstract class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
