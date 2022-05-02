package hellojpa;

import javax.persistence.*;
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
            /* Create
            Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");
             */

            Member findMember = em.find(Member.class, 1L);

            /* Read
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());
             */

            /* Delete
            em.remove(findMember);
             */

            /* Update
            findMember.setName("HelloJPA");
             */

            // Member 테이블이 아니라 해당 엔티티 객체를 다 불러온다!!
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1) // pagination -> 방언에 맞춰서 각 DB 벤더사에 맞게 SQL을 맞춰줌
                    .setMaxResults(10)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }

            /*
               JPAQL은 테이블이 아닌 객체를 대상으로 검색하는 객체 지향 쿼리
               SQL을 추상화해서 특정 데이터베이스 SQL에 의존하지 않는다.
               JPQL을 한마디로 정리하면 객체지향 SQL
             */

            // 비영속 상태
           /* Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");

            // 영속 상태
            System.out.println("=== BEFORE ===");
            em.persist(member); // JPA 1차 캐시에 저장
//            em.detach(member); // 영속성 컨텍스트에서 분리, 준영속 상태
            System.out.println("=== AFTER ===");*/

            Member findDbFindMember = em.find(Member.class, 101L);
            System.out.println("findDbFindMember.id = " + findDbFindMember.getId());
            System.out.println("findDbFindMember.name = " + findDbFindMember.getName());
            Member primaryCacheFindMember = em.find(Member.class, 101L);
            System.out.println("primaryCacheFindMember.id = " + primaryCacheFindMember.getId());
            System.out.println("primaryCacheFindMember.name = " + primaryCacheFindMember.getName());

            System.out.println("result = " + (findDbFindMember == primaryCacheFindMember)); // 영속 엔티티의 동일성을 보장 해 준다.


//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//            Member member = em.find(Member.class, 150L); // 영속 엔티티를 조회하고
//            member.setName("ZZZ"); // 값을 변경하기만 하면 변경감지(Dirty Checking)로 자동으로 변경해준다.

//            em.persist(member1);
//            em.persist(member2);
//            em.remove(member); 삭제

            Member member = new Member(200L, "member200");
            em.persist(member);

            /* 영속성 컨텍스트를 플러시하는 방법
             1. em.flush() - 직접 호출
             2. 트랜잭션 커밋 - 플러시 자동 호출
             3. JPQL 쿼리 실행 - 플러시 자동 호출
             */
            em.flush(); // 이 시점에 DB에 쿼리를 날린다. => 영속성 컨텍스트에 있는 쓰기 지연 SQL 저장소에 있는것들이 DB에 반영이 된다.(영속성 컨텍스트의 변경 내용을 데이터베이스에 동기화한다) => 실질적인 반영은 커밋에서!

            System.out.println("=====================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();

        }

        emf.close();
    }
}
