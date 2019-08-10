package dev.chamindu.mongotime;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocalTimeEventRepository extends MongoRepository<LocalTimeEvent, String> {

}
