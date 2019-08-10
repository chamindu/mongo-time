package dev.chamindu.mongotime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

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
        createLocalTimeEvents();
        queryByDateRange();
    }

    private void createEvent() {
        System.out.println("Deleting old Event documents and creating a new document");
        this.eventRepository.deleteAll();

        LocalDateTime dateTime = LocalDateTime.of(2019, 8, 1, 9, 30);
        Event event = new Event();
        event.setEventTime(dateTime);
        this.eventRepository.save(event);
    }

    private void createLocalTimeEvents() {
        System.out.println("Deleting old LocalTimeEvent documents and creating 10 new documents.");
        this.localTimeEventRepository.deleteAll();

        for (int day = 1; day < 11; day++) {
            MongoLocalDateTime dateTime = MongoLocalDateTime.of(2019, 8, day, 8, 0, 0);
            LocalTimeEvent event = new LocalTimeEvent();
            event.setEventTime(dateTime);
            this.localTimeEventRepository.save(event);
        }
    }

    private void queryByDateRange() {
        System.out.println("Querying records in date range 2019-08-05 to 2019-08-08.");

        MongoLocalDateTime start = MongoLocalDateTime.of(2019, 8, 5, 0, 0, 0);
        MongoLocalDateTime end = MongoLocalDateTime.of(2019, 8, 8, 0, 0, 0);

        List<LocalTimeEvent> result = this.localTimeEventRepository.findByEventTimeRange(start, end);

        for(LocalTimeEvent event: result) {
            System.out.println(event.getEventTime());
        }
    }
}
