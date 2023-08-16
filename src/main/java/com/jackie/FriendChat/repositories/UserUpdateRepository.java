package com.jackie.FriendChat.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jackie.FriendChat.models.validators.UserUpdate;

@Repository
public interface UserUpdateRepository extends CrudRepository<UserUpdate, Long> {
	Optional<UserUpdate> findByEmail(String email);
	List<UserUpdate> findAll();
}
