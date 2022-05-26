package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
public class Category extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    @ManyToMany // 실전에서는 중간 테이블은 단순하지 않으니까 1:N 또는 N:1로 바꿔서 하자
    @JoinTable(name = "CATEGORY_ITEM",  // 매핑할 외래 키 이름
            joinColumns = @JoinColumn(name = "CATEGORY_ID"), // 외래키 매핑할 때 사용
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
    )
    private List<Item> items = new ArrayList<>();
}
