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

            Team teamA = new Team();
            teamA.setName("팀A");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("팀B");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.setTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.setTeam(teamB);
            em.persist(member3);

            em.flush();
            em.clear();

            // 단일 값 연관 경로 : 묵시적 내부 조인(inner join) 발생, 탐색 O
            // 컬렉션 값 연관 경로 : 묵시적 내부 조인 발생, 탐색 X

            // 묵시적 내부 조인 쿼리
//            String query = "select t.members From Team t";
            // 명시적 조인 사용 해야함 -> FROM 절에서 명시적 조인을 통해 별칭을 얻으면 별칭을 통해 탐색 가능
//            String query = "select m.username From Team t join t.members m";

//            String query = "select m From Member m";

            // 페치 조인으로 가져오는 쿼리
//            String query = "select m From Member m join fetch m.team";

            // 컬렉션 페치 조인
//            String query = "select t From Team t join fetch t.members";
            // 같은 식별자를 가진 Team 엔티티를 제거
//            String query = "select distinct t From Team t join fetch t.members";
            /*
            페치 조인의 특징과 한계
            - 페치 조인 대상에는 별칭을 줄 수 없다. (하이버네이트는 가능, 가급적 사용X)
            - 둘 이상의 컬렉션은 페치 조인 할 수 없다.
            - 컬렉션을 페치조인하면 페이징 API를 사용할 수 없다.
            - 모든 것을 페치 조인으로 해결할 수 없음
            - 페치 조인은 객체 그래프를 유지할 때 사용하면 효과적
            - 여러 테이블을 조인해서 엔티티가 가진 모양이 아닌 전혀 다른 결과를 내야하면, 페치 조인보다는 일반 조인을 사용하고 사용한 데이터만 DTO로 만들어 사용하는 것이 효과적이다
             */
//            String query = "select t From Team t";
            // JPQL에서 엔티티를 직접 사용하면 SQL에서 해당 엔티티의 기본 키 값을 사용
            String query = "select m From Member m where m = :member"; //  select m from Member m where m.id = :memberId 랑 같음

            // FK 값도 엔티티로 직접 사용 할 수 있다.
            String foreignQuery = "select m from Member m where m.team = :team";


            // 일반조인과 페치조인의 차이 -> 일반조인은 연관된 엔티티를 조회하지 않음(SELECT 절에 지정한 엔티티만 조회할뿐)

//            String query = "select t.members.size From Team t";
            
//            List<Collection> result = em.createQuery(query, Collection.class)
//                            .getResultList();
//            Integer result = em.createQuery(query, Integer.class)
//                    .getSingleR esult();

//            List<Member> result = em.createQuery(query, Member.class)
//                    .getResultList();

//            List<Team> result = em.createQuery(query, Team.class)
//                    .setFirstResult(0) // 컬렉션을 페치 조인하면 페이징API(setFirstResult, setMaxResults)를 사용할 수 없다.
//                    .setMaxResults(2)
//                    .getResultList();

//            Member findMember = em.createQuery(query, Member.class)
//                    .setParameter("member", member1)
//                            .getSingleResult();
//
//            System.out.println("findMember = " + findMember);

            List<Member> members = em.createQuery(foreignQuery, Member.class)
                    .setParameter("team", teamA)
                            .getResultList();
            
            for (Member member : members)  {
                System.out.println("member = " + member);
            }

//            for (Object o : result) {
//                System.out.println("o = " + o);
//            }

//            for (Member member : result) {
//                // 페치 조인으로 회원과 팀을 함께 조회해서 지연 로딩 X
//                System.out.println("member = " + member.getUsername() + ", " + member.getTeam().getName());
//                // 회원1, 팀A(SQL)
//                // 회원2, 팀A(1차캐시)
//                // 회원3, 팀B(SQL)
//
//                // 만약 회원100명 -> N + 1 (+1인 이유는 첫번째로 날리는 쿼리에 대한 결과[비교를 위해])
//            }

//            System.out.println("result = " + result.size());
//
//            for (Team team : result) {
//                System.out.println("team = " + team.getName() + "| members = " + team.getMembers().size());
//                for (Member member : team.getMembers()) {
//                    System.out.println("-> member = " + member);
//                }
//            }

//            System.out.println("result = " + result.size());

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
