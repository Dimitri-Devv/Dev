package fr.dawan.springcore.atelier;

import fr.dawan.springcore.beans.User;

public interface UserRepository {

    User findByUsername(String username);

}
