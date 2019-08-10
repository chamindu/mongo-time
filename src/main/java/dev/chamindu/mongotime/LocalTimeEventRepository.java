package dev.chamindu.mongotime;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface LocalTimeEventRepository extends MongoRepository<LocalTimeEvent, String> {
    @Query("{'eventTime':{$gte:'?0', $lte:'?1'}}")
    List<LocalTimeEvent> findByEventTimeRange(MongoLocalDateTime startTime, MongoLocalDateTime end);
}
