package fr.dawan.springcore.atelier;

import org.springframework.stereotype.Repository;

import fr.dawan.springcore.beans.User;

@Repository
public class UserRepositoryImp implements UserRepository {

    @Override
    public User findByUsername(String username) {

        return null;
    }

}
