package com.scm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.entities.User;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    // Repo is used for he database interactions
    // Ya databse query valya methos ya JPA repository kadun yetat
    // inbuilt sodun kahi DB related methods jr lihaychya astil tr tya ith lihu skto
    // Tya custom user written quey pn asi shktat kiva tya custom finder methods
    Optional<User> findByEmail(String email);

}
