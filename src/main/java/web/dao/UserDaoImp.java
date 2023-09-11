package web.dao;

import web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em;

    @Override
    public void add(User user) {
        em.persist(user);
        System.out.println("Создан - " + user);

    }

    @Override
    public void edit(User updatedUser) {
        em.merge(updatedUser);
        System.out.println("Изменен - " + updatedUser);
    }

    @Override
    public void delete(long id) {
        em.remove(userById(id));
        System.out.println("Удален юзер");
    }

    @Override
    public User userById(long id) {
//        TypedQuery<User> query = em.createQuery("select u from User u where u.id=:id", User.class);
//        query.setParameter("id", id);
//        return query.getResultList().stream().findAny().orElse(null);
//        Этот варик тоже работал, хз какой лучше, оставил который проще по синтаксису
        return em.find(User.class, id);
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return em.createQuery("select u FROM User u", User.class).getResultList();
    }

}
