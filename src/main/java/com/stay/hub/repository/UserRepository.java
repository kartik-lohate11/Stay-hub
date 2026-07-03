package com.stay.hub.repository;

import com.stay.hub.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserData, Long>,
        JpaSpecificationExecutor<UserData> {
    UserData findByNameAndPassword(String name, String password);
}
