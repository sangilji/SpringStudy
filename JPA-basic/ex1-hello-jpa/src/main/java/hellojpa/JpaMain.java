package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {

            Member member = new Member();
            member.setUsername("kimminsu");
            member.setAddress(new Address("city", "street", "10"));
            member.setPeriod(new Period());
            em.persist(member);

            List<Member> result = em.createQuery("select m from Member m where m.username like '%kim%'", Member.class)
                    .getResultList();
            for (Member m : result) {
                System.out.println(m.getUsername());
            }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
        emf.close();


    }
}
