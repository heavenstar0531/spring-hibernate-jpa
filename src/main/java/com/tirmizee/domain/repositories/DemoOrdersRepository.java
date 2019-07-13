package com.tirmizee.domain.repositories;

import com.tirmizee.domain.entities.DemoOrder;
import com.tirmizee.domain.repositories.custom.CustomDemoOrdersRepository;

public interface DemoOrdersRepository extends BaseRepository<DemoOrder, Integer>, CustomDemoOrdersRepository {

}
