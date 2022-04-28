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

           tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();

        }

        emf.close();
    }
}
