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
           /* Member member = new Member();
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
            System.out.println("paramQuery = " + paramQuery.getUsername());*/

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

            em.flush();
            em.clear();

            // m은 엔티티이다. => result는 엔티티들
            // 영속성 컨텍스트로 관리가 된다.
//            List<Member> result = em.createQuery("select m from Member m", Member.class)
//                            .getResultList();

//            Member findMember = result.get(0);
//            findMember.setAge(20);

            // 임베디드 타입 프로젝션
//            em.createQuery("select o.address from Order o", Address.class)
//                    .getResultList();

            // 스칼라 타입 프로젝션

            // 프로젝션 - 여러값 조회
            // 1. Query 타입으로 조회
//            List resultList = em.createQuery("select distinct m.username, m.age from Member m")
//                    .getResultList();
//
//            Object o = resultList.get(0);
//            Object[] result = (Object[]) o;
//            System.out.println("username = " + result[0]);
//            System.out.println("age = " + result[1]);

            // 2. Object[] 타입으로 조회
//            List<Object[]> resultList = em.createQuery("select distinct m.username, m.age from Member m")
//                            .getResultList();
//
//            Object[] result = resultList.get(0);
//            System.out.println("username = " + result[0]);
//            System.out.println("age = " + result[1]);

            // 3. new 명령어로 조회
            List<MemberDTO> resultList = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m")
                            .getResultList();

            MemberDTO memberDTO = resultList.get(0);
            System.out.println("memberDTO.getUsername() = " + memberDTO.getUsername());
            System.out.println("memberDTO.getAge() = " + memberDTO.getAge());


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
