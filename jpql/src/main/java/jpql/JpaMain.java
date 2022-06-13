package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml에서 작성한 UnitName
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

//            Member member2 = new Member();
//            member2.setUsername("membe2");
//            member2.setAge(10);
//            em.persist(member2);

            // TypeQuery: 반환 타입이 명확할때 사용
            // Query: 반환 타입이 명확하지 않을때 사용
            TypedQuery<Member> query1 = em.createQuery("select m from Member m where m.age = 10", Member.class);
            TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class);
            Query query3 = em.createQuery("select m.username, m.age from Member m");

            // getResultList()는 결과가 하나 이상일 때, 리스트 반환 => 결과가 없으면 빈 리스트 반환
            List<Member> resultList = query1.getResultList();

            // 결과가 정확히 하나, 단일 객체 반환
            // => 결과가 없으면: javax.persistence.NoResultException
            // => 둘 이상이면: javax.persistence.NonUniqueResultException
            Member result = query1.getSingleResult();
            System.out.println("result = " + result.getUsername());

//            TypedQuery<Member> paramQuery = em.createQuery("select m from Member m where m.username = :username", Member.class);
//            paramQuery.setParameter("username", "member1");
//            Member singleResult = paramQuery.getSingleResult();

            Member paramQuery = em.createQuery("select m from Member m where m.username = :username", Member.class)
                    .setParameter("username", "member1")
                    .getSingleResult();
            System.out.println("paramQuery = " + paramQuery.getUsername());

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
