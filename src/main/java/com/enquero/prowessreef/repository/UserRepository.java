package com.enquero.prowessreef.repository;

import com.enquero.prowessreef.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User findUserByUserIdOrFullName(String name, String mobile);
}
