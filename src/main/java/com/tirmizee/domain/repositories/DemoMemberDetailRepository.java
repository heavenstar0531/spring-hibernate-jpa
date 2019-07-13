package com.tirmizee.domain.repositories;

import com.tirmizee.domain.entities.DemoMemberDetail;
import com.tirmizee.domain.repositories.custom.CustomDemoMemberDetailRepository;

public interface DemoMemberDetailRepository extends BaseRepository<DemoMemberDetail, Long>, CustomDemoMemberDetailRepository {

}
