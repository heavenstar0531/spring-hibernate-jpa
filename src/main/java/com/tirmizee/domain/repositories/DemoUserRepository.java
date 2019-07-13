package com.tirmizee.domain.repositories;

import com.tirmizee.domain.entities.DemoUser;
import com.tirmizee.domain.repositories.custom.CustomDemoUserRepository;

public interface DemoUserRepository extends BaseRepository<DemoUser, Integer>, CustomDemoUserRepository {

}
