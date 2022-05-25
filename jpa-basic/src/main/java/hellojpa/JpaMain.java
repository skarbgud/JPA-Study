package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        // EntityManagerFactory는 애플리케이션 생성 시점에 딱 하나만 생성해야하고
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml에서 작성한 UnitName

        // 수행의 단위마다(예: 고객의 요청) em을 하나씩 생성 (쓰레드간에 공유 x)
        EntityManager em = emf.createEntityManager();

        // 트랜잭션 실행
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//
//            /* Create
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//             */
//
//            Member findMember = em.find(Member.class, 1L);
//
//            /* Read
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());
//             */
//
//            /* Delete
//            em.remove(findMember);
//             */
//
//            /* Update
//            findMember.setName("HelloJPA");
//             */
//
//            // Member 테이블이 아니라 해당 엔티티 객체를 다 불러온다!!
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1) // pagination -> 방언에 맞춰서 각 DB 벤더사에 맞게 SQL을 맞춰줌
//                    .setMaxResults(10)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }
//
//            /*
//               JPAQL은 테이블이 아닌 객체를 대상으로 검색하는 객체 지향 쿼리
//               SQL을 추상화해서 특정 데이터베이스 SQL에 의존하지 않는다.
//               JPQL을 한마디로 정리하면 객체지향 SQL
//             */
//
//            // 비영속 상태
//           /* Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            // 영속 상태
//            System.out.println("=== BEFORE ===");
//            em.persist(member); // JPA 1차 캐시에 저장
////            em.detach(member); // 영속성 컨텍스트에서 분리, 준영속 상태
//            System.out.println("=== AFTER ===");*/
//
//            Member findDbFindMember = em.find(Member.class, 101L);
//            System.out.println("findDbFindMember.id = " + findDbFindMember.getId());
//            System.out.println("findDbFindMember.name = " + findDbFindMember.getName());
//            Member primaryCacheFindMember = em.find(Member.class, 101L);
//            System.out.println("primaryCacheFindMember.id = " + primaryCacheFindMember.getId());
//            System.out.println("primaryCacheFindMember.name = " + primaryCacheFindMember.getName());
//
//            System.out.println("result = " + (findDbFindMember == primaryCacheFindMember)); // 영속 엔티티의 동일성을 보장 해 준다.
//
//
////            Member member1 = new Member(150L, "A");
////            Member member2 = new Member(160L, "B");
//            Member member = em.find(Member.class, 150L); // 영속 엔티티를 조회하고
//            // ----- member는 영속 상태 -----------
//            member.setName("AAAA"); // 값을 변경하기만 하면 변경감지(Dirty Checking)로 자동으로 변경해준다.
//
//            // 영속성 컨텍스트에서 분리
////            em.detach(member);
//            em.clear(); // 영속성 컨텍스트를 그냥 통째로 초기화
////            em.close(); // 영속성 컨텍스트를 종료
//            // 다시 영속성 컨텍스트에 올려서 조회하게 된다.
//            Member member2 = em.find(Member.class, 150L); // 영속 엔티티를 다시 조회하게 된다
//
////            em.persist(member1);
////            em.persist(member2);
////            em.remove(member); 삭제
//
////            Member member = new Member(200L, "member200");
////            em.persist(member);
//
//            /* 영속성 컨텍스트를 플러시하는 방법
//             1. em.flush() - 직접 호출
//             2. 트랜잭션 커밋 - 플러시 자동 호출
//             3. JPQL 쿼리 실행 - 플러시 자동 호출
//             */
////            em.flush(); // 이 시점에 DB에 쿼리를 날린다. => 영속성 컨텍스트에 있는 쓰기 지연 SQL 저장소에 있는것들이 DB에 반영이 된다.(영속성 컨텍스트의 변경 내용을 데이터베이스에 동기화한다) => 실질적인 반영은 커밋에서!
//
//            System.out.println("=====================");

//            Member member = new Member();
////            member.setId("ID_A");
//            member.setUsername("C");

//            Member member1 = new Member();
//            member1.setUsername("A");
//
//            Member member2 = new Member();
//            member1.setUsername("B");
//
//            Member member3 = new Member();
//            member1.setUsername("C");
//
//            System.out.println("=============");
//
//            // DB SEQ = 1      |  1
//            // DB SEQ = 51     |  2
//            // DB SEQ = 51     |  3
//
//            em.persist(member1);  // 1, 51
//            em.persist(member2);  // MEM
//            em.persist(member3);  // MEM
//
//            System.out.println("member1 = " + member1.getId());
//            System.out.println("member2 = " + member2.getId());
//            System.out.println("member3 = " + member3.getId());
//
//            System.out.println("=============");

            // 저장
//            Team team = new Team();
//            team.setName("TeamA");
////            team.getMembers().add(member);
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
////            member.setTeamId(team.getId());
//            // 역방향(주인이 아닌 방향)만 연관관계 설정
////            member.changeTeam(team); // 연관관계에서 member가 주인이라서 member에 team을 넣어야한다.
//            em.persist(member);
//
//            team.addMember(member);
//
//            // 양방향 매핑시 연관관계 주인에 값에 입력을 해야하지만 (순수한 객체 관계를 고려하면 항상 양쪽다 값을 입력해야 한다.)
////            team.getMembers().add(member); // -> 연관관계 편의 메소드를 넣어서 실수하지 않도록 한다.
//
////            em.flush();
////            em.clear();
//
//            Team findTeam = em.find(Team.class, team.getId()); // 1차 캐시
//            List<Member> members = findTeam.getMembers();
//
//            System.out.println("=============");
////            for (Member m : members) {
////                System.out.println("m = " + m.getUsername());
////            }
//            System.out.println("members = " + findTeam); // => toString() 양방향 매핑시에 무한 루프를 조심하자
//            System.out.println("=============");

//            Member findMember = em.find(Member.class, member.getId());

//            Long findTeamId = findMember.getTeamId();
//            Team findTeam = em.find(Team.class, findTeamId);

//            Team findTeam = findMember.getTeam(); // 1차 캐시에서 가져오기 때문에 쿼리 호출이 없다
//            System.out.println("findTeam = " + findTeam.getName());
//
//            Team newTeam = em.find(Team.class, 100L);
//            findMember.setTeam(newTeam);

//            List<Member> members = findMember.getTeam().getMembers();
//
//            for (Member m : members) {
//                System.out.println("m = " + m.getUsername());
//            }
//            Member member = new Member();
//            member.setUsername("member1");
//
//            em.persist(member);
//
//            Team team = new Team();
//            team.setName("teamA");
//            team.getMembers().add(member);
//
//            em.persist(team);

//            Movie movie = new Movie();
//            movie.setDirector("aaaa");
//            movie.setActor("bbbb");
//            movie.setName("바람과 함께 사라지다");
//            movie.setPrice(10000);
//
//            em.persist(movie);
//
//            em.flush();
//            em.clear();
//
////            Movie findMovie = em.find(Movie.class, movie.getId());
//            Item item = em.find(Item.class, movie.getId()); // InheritanceType.TABLE_PER_CLASS일 경우 모든 테이블을 다 조회해야하기 때문에 상속된 모든 테이블을 union해서 select해서 좋지 X
//            System.out.println("item = " + item);

//            Member member = new Member();
//            member.setUsername("user1");
//            member.setCreatedBy("kim");
//            member.setCreatedDate(LocalDateTime.now());
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();

//            Member member = em.find(Member.class, 1L);

//            printMember(member);

//            printMemberAndTeam(member);

//            Member member = new Member();
//            member.setUsername("hello");
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
////            Member findMember = em.find(Member.class, member.getId());
//            Member findMember = em.getReference(Member.class, member.getId());
//            System.out.println("before findMember = " + findMember.getClass()); // 하이버네이트가 만든 가짜 객체
//            System.out.println("findMember.id = " + findMember.getId());
//
//            // 내부적으로 실제 영속성 컨텍스트에 DB를 통해서 실제 Entity를 통해서 타겟을 지정해서 조회를 한다
//            System.out.println("findMember.username = " + findMember.getUsername());
//            // 두번째 조회할 경우 프록시에 값이 세팅이 되어있어서 조회를 더이상 하지 않는다. => 프록시 객체는 처음 사용할 때 한 번만 초기화
//            System.out.println("findMember.username = " + findMember.getUsername());
//
//            System.out.println("after findMember = " + findMember.getClass());

//            Member member1 = new Member();
//            member1.setUsername("member1");
//            em.persist(member1);

//            Member member2 = new Member();
//            member2.setUsername("member1");
//            em.persist(member2);

//            em.flush();
//            em.clear();
//
//            Member refMember = em.getReference(Member.class, member1.getId());
//            System.out.println("refMember = " + refMember.getClass()); // Proxy

//            refMember.getUsername(); // 강제 초기화

//            Hibernate.initialize(refMember); // 프록시 강제 초기화

            // 프록시 인스턴스 초기화 여부 확인
//            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));


            // em.detach 또는 em.clear를 통해서 영속성 컨텍스트를 분리하면 찾을수 없게 된다.
//            em.detach(refMember);
//            em.clear();

            // could not initialize proxy [hellojpa.Member#1] - no Session 영속성 컨텍스트가 없다는 에러 발생
//            refMember.getUsername();

            // 이미 멤버를 영속성 컨텍스트에 1차캐시에 있기 때문에 프록시 객체가 아니라 진짜 객체를 조회한다.
//            Member findMember = em.find(Member.class, member1.getId());
//            System.out.println("findMember = " + findMember.getClass()); // Member가 아니라 Proxy다

            // JPA에서는 한 트랜잭션 안에서 == 비교할때 TRUE로 보장하기 위해 영속성 컨텍스트에 있는걸로 동일하게 사용
            // getReference로 조회시에 첫번째도 프록시 두번째도 프록시 객체인데 두개가 같은 객체이다 (== true 보장)
//            System.out.println("refMember == findMember: " + (refMember == findMember));

//            Member m2 = em.find(Member.class, member2.getId());
//            Member m2 = em.getReference(Member.class, member2.getId());

//            logic(m1, m2);

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setTeam(team);
            em.persist(member1);

            em.flush();
            em.clear();

            Member m = em.find(Member.class, member1.getId());

            System.out.println("m = " + m.getTeam().getClass()); // 즉시 로딩시에는 프록시가 아니라 진짜 객체, 지연 로딩의 경우 프록시 객체

            // 실제 team을 사용하는 시점에 초기화
            System.out.println("========");
            System.out.println("teamName = " + m.getTeam().getName()); // 즉시 로딩시 쿼리 조회 X
            m.getTeam().getName(); // 초기화
            System.out.println("========");

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();

        }

        emf.close();
    }

//    private static void logic(Member m1, Member m2) {
////        System.out.println("m1 == m2: " + (m1.getClass() == m2.getClass()));
//        // == 비교 대신 instance of 사용
//        System.out.println("m1 == m2: " + (m1 instanceof Member));
//        System.out.println("m1 == m2: " + (m2 instanceof Member));
//    }

//    private static void printMember(Member member) {
//        System.out.println("member = " + member.getUsername());
//    }
//
//    private static void printMemberAndTeam(Member member) {
//        String username = member.getUsername();
//        System.out.println("username = " + username);
//
//        Team team = member.getTeam();
//        System.out.println("team = " + team.getName());
//    }
}
