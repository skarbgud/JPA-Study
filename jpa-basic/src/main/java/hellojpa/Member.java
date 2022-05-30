package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Entity
//@SequenceGenerator(
//        name = "member_seq_generator",
//        sequenceName = "member_seq", // 매핑할 데이터베이스 시퀀스 이름
//        initialValue = 1, allocationSize = 50  // 미리 call next 의 사이즈를 땡겨온다. (메모리에 미리 올려놓는 개념)
//)
//@TableGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        table = "MY_SEQUENCES",
//        pkColumnValue = "MEMBER_SEQ", allocationSize = 1
//)
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    private Long id;

    // 기본 키 제약 조건: null 아님, 유일, 변하면 안된다. (비즈니스를 키로 가져오는것은 올바르지 않다)
//    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE,
//            generator = "MEMBER_SEQ_GENERATOR")
//    private Long id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    //    @Column(name = "name", nullable = false, length = 10, columnDefinition = "varchar(100) default 'EMPTY'") // 컬럼
    @Column(name = "USERNAME")
    private String username;

    // 기간 Period
    @Embedded
    private Period workPeriod;

    // 집 주소
    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns =
        @JoinColumn(name = "MEMBER_ID")
    )
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

//    @ElementCollection
//    @CollectionTable(name = "ADDRESS", joinColumns =
//        @JoinColumn(name = "MEMBER_ID")
//    )
//    private List<Address> addressHistory = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();

    // 회사 주소
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "city",
//                    column = @Column(name = "WORK_CITY")),
//            @AttributeOverride(name = "street",
//                    column = @Column(name = "WORK_STREET")),
//            @AttributeOverride(name = "zipcode",
//                    column = @Column(name = "WORK_ZIP"))
//    })
//    private Address workAddress;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

//    @ManyToOne(fetch = FetchType.EAGER) // 멤버입장에서는 Member는 N, Team 입장에서는 1로 N:1관계이다.
//    @JoinColumn(name = "TEAM_ID")
//    private Team team;

//    @ManyToOne
//    @JoinColumn(insertable = false, updatable = false) // 이렇게 하면 일대다 양방향 처럼 사용 가능 => 다대일 양방향을 사용하자
//    private Team team;

//    @OneToOne
//    @JoinColumn(name = "LOCKER_ID")
//    private Locker locker;

//    @ManyToMany
//    @JoinTable(name = "MEMBER_PRODUCT")
//    private List<Product> products = new ArrayList<>();
//    @OneToMany(mappedBy = "member")
//    private List<MemberProduct> memberProducts = new ArrayList<>();

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Period getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Period workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    public List<AddressEntity> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<AddressEntity> addressHistory) {
        this.addressHistory = addressHistory;
    }

    //    public List<Address> getAddressHistory() {
//        return addressHistory;
//    }
//
//    public void setAddressHistory(List<Address> addressHistory) {
//        this.addressHistory = addressHistory;
//    }

    //    public Long getTeamId() {
//        return teamId;
//    }
//
//    public void setTeamId(Long teamId) {
//        this.teamId = teamId;
//    }

//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//    }
//
//    public void changeTeam(Team team) {
//        this.team = team;
//
//        // 연관관계 편의 메소드
//        team.getMembers().add(this);
//    }
//
//    @Override
//    public String toString() {
//        return "Member{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", team=" + team +
//                '}';
//    }
}
