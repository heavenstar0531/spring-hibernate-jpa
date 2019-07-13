package com.tirmizee.domain.repositories;

import com.tirmizee.domain.entities.DemoOrderItem;
import com.tirmizee.domain.repositories.custom.CustomDemoOrderItemRepository;

public interface DemoOrderItemRepository extends BaseRepository<DemoOrderItem, Integer>, CustomDemoOrderItemRepository {

}
