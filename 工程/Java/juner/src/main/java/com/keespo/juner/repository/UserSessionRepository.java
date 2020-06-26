package com.keespo.juner.repository;

import com.keespo.juner.entities.User;
import com.keespo.juner.entities.UserSession;
import org.springframework.data.repository.CrudRepository;

public interface UserSessionRepository extends CrudRepository<UserSession,Integer> {
    UserSession findUserSessionByUserId(Integer id);
    UserSession findUserSessionBySession(String session);
}
