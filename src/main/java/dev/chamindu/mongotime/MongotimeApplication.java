package dev.chamindu.mongotime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class MongotimeApplication implements CommandLineRunner {

    private EventRepository eventRepository;
    private LocalTimeEventRepository localTimeEventRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongotimeApplication.class, args);
    }

    public MongotimeApplication(EventRepository eventRepository, LocalTimeEventRepository localTimeEventRepository) {
        this.eventRepository = eventRepository;
        this.localTimeEventRepository = localTimeEventRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createEvent();
        createLocalTimeEvent();

    }

    private void createEvent() {
        System.out.println("Deleting old event records.");
        this.eventRepository.deleteAll();

        LocalDateTime dateTime = LocalDateTime.of(2019, 8, 1, 9, 30);
        Event event = new Event();
        event.setEventTime(dateTime);

        this.eventRepository.save(event);

    }

    private void createLocalTimeEvent() {
        System.out.println("Deleting old event records.");
        this.localTimeEventRepository.deleteAll();

        for (int day = 1; day < 11; day++) {
            MongoLocalDateTime dateTime = MongoLocalDateTime.of(2019, 8, day, 8, 0, 0);
            LocalTimeEvent event = new LocalTimeEvent();
            event.setEventTime(dateTime);
            this.localTimeEventRepository.save(event);
        }

    }

}
