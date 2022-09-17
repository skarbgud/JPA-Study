package jpql;

import javax.persistence.*;
import java.util.Collection;
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

//            Member member = new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            em.persist(member);
//
//            em.flush();
//            em.clear();

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
//            List<MemberDTO> resultList = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m")
//                            .getResultList();
//
//            MemberDTO memberDTO = resultList.get(0);
//            System.out.println("memberDTO.getUsername() = " + memberDTO.getUsername());
//            System.out.println("memberDTO.getAge() = " + memberDTO.getAge());

//            for (int i = 0; i < 100; i++) {
//                Member member = new Member();
//                member.setUsername("member" + i);
//                member.setAge(i);
//                em.persist(member);
//            }

//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("관리자");
//            member.setAge(10);
//            member.setType(MemberType.ADMIN);
//
//            Member member2 = new Member();
//            member2.setUsername("관리자2");
//            member2.setAge(10);
//            member2.setType(MemberType.ADMIN);
//
//            member.setTeam(team);
//
//            em.persist(member);
//            em.persist(member2);
//
//            em.flush();
//            em.clear();

//            String query = "select m from Member m inner join m.team t"; // inner 는 생략 가능
//            String query = "select m from Member m left outer join m.team t"; // outer 는 생략 가능
//            String query = "select m from Member m, Team t where m.username = t.name"; // 쎄타 조인

            // 1. 조인 대상 필터링
//            String query = "select m from Member m left join m.team t on t.name = 'teamA'";
            // 2. 연관관계 없는 엔티티 외부 조인
//            String query = "select m from Member m left join Team t ON m.username = t.name";

            // 서브쿼리 예시
//            String query = "select (select avg(m1.age) from Member m1) as avgAge from Member m left join Team t ON m.username = t.name";
            // FROM 절에서는 서브쿼리가 동작하지 않는다.

//            List<Member> result = em.createQuery(query, Member.class)
//                    .getResultList();
//
//            System.out.println("result.size() = " + result.size());

//            System.out.println("result.size = " + result.size());
//            for (Member member1 : result) {
//                System.out.println("member1 = " + member1);
//            }

//            String query = "select m.username, 'HELLo', true FROM Member m " +
//                    "where m.type = jpql.MemberType.ADMIN";
//            String query = "select m.username, 'HELLo', true FROM Member m " +
//                    "where m.type = :userType";
//            List<Object[]> result = em.createQuery(query)
//                    .setParameter("userType", MemberType.ADMIN)
//                    .getResultList();
//
//            for (Object[] objects : result) {
//                System.out.println("objects[0] = " + objects[0]);
//                System.out.println("objects[1] = " + objects[1]);
//                System.out.println("objects[2] = " + objects[2]);
//            }

//            String caseQuery =
//                    "select " +
//                            "case when m.age <= 10 then '학생요금' " +
//                            "     when m.age >=60  then '경로요금' " +
//                            "     else '일반요금' " +
//                            "end " +
//                    "from Member m";
//            String coalesceQuery = "select coalesce(m.username, '이름 없는 회원')" +
//                    " as username from Member m";
//            String nullifQuery = "select nullif(m.username, '관리자') as username " +
//                    "from Member m";
//
//            List<String> result = em.createQuery (nullifQuery , String.class)
//                            .getResultList();
//
//            for (String s : result) {
//                System.out.println("s = " + s);
//            }

//            String functionQuery = "select concat('a', 'b') from Member m";
//            String functionQuery = "select substring(m.username, 2, 3) from Member m";
//            String functionQuery = "select locate('de','abcdefg') from Member m";
//            String functionQuery = "select function('group_concat', m.username) from Member m";
//            String functionQuery = "select group_concat(m.username) from Member m";
//
//            List<String> result = em.createQuery (functionQuery , String.class)
//                            .getResultList();
//
//            for (String s : result) {
//                System.out.println("s = " + s);
//            }

            Team team = new Team();
            em.persist(team);

            Member member1 = new Member();
            member1.setUsername("관리자1");
            member1.setTeam(team);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("관리자2");
            member2.setTeam(team);
            em.persist(member2);

            em.flush();
            em.clear();

            // 단일 값 연관 경로 : 묵시적 내부 조인(inner join) 발생, 탐색 O
            // 컬렉션 값 연관 경로 : 묵시적 내부 조인 발생, 탐색 X

            // 묵시적 내부 조인 쿼리
//            String query = "select t.members From Team t";
            // 명시적 조인 사용 해야함 -> FROM 절에서 명시적 조인을 통해 별칭을 얻으면 별칭을 통해 탐색 가능
            String query = "select m.username From Team t join t.members m";

//            String query = "select t.members.size From Team t";
            
//            List<Collection> result = em.createQuery(query, Collection.class)
//                            .getResultList();
//            Integer result = em.createQuery(query, Integer.class)
//                    .getSingleR esult();
            List<String> result = em.createQuery(query, String.class)
                    .getResultList();
            
//            for (Object o : result) {
//                System.out.println("o = " + o);
//            }

            for (String s : result) {
                System.out.println("s = " + s);
            }

//            System.out.println("result = " + result);

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
