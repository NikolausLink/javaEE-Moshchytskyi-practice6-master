package kma.niko.practice6;

import java.util.List;

import javax.persistence.EntityManager;

import kma.niko.practice6.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final EntityManager entityManager;

    @Transactional
    public UserEntity createUser(String firstName, String lastName, String email) {
        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);

        return entityManager.merge(user);
    }


    @Transactional
    public List<UserEntity> findAllUsers() {
        return entityManager.createQuery("SELECT u FROM UserEntity u", UserEntity.class)
                .getResultList();
    }



    @Transactional
    public List<UserEntity> findUserWhereFirstOrLastNameContains(String searchText) {
        return entityManager.createQuery("SELECT u FROM UserEntity u WHERE u.firstName LIKE :query OR u.lastName LIKE :query", UserEntity.class)
                .setParameter("query", '%' + searchText + '%')
                .getResultList();
    }

    public List<UserEntity> findByLastName(String lastName) {
        return entityManager.createNamedQuery(UserEntity.FIND_BY_LASTNAME, UserEntity.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

}
