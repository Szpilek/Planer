package app.planer.controller

import app.planer.model.Event
import app.planer.model.EventType
import app.planer.model.Task
import app.planer.model.TaskImportance
import app.planer.model.TaskState;
import app.planer.service.EventService;
import app.planer.configuration.ServiceMockConfiguration
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import spock.lang.Specification

import java.time.LocalDate
import java.time.LocalDateTime;

@ContextConfiguration(classes = [ServiceMockConfiguration, EventController])
class EventControllerTest extends Specification {
    @Autowired
    EventController eventController
    @Autowired
    EventService eventService

    def exampleEventToAdd() {
        return new Event(
                LocalDateTime.of(2020, 1, 2,3,4,5),
                "event1",
                EventType.FAMILY,
                true
        )
    }

    def exampleEventsToReturn() {
        def events = []
        events << new Event(
                LocalDateTime.of(2020, 2, 2,3,4,5),
                "event2",
                EventType.FAMILY,
                true
        )

        events << new Event(
                LocalDateTime.of(2020, 3, 2,3,4,5),
                "event3",
                EventType.FAMILY,
                true
        )
        return events
    }

    def "given date from and date to should return tasks" (){
        given:
        def events = exampleEventsToReturn()

        when:
        result = eventController.getEvents(dateFrom, dateTo)

        then:
        result == events

        where:
        dateFrom << LocalDateTime.of(2020, 1, 1,1,1,1)
        dateTo << LocalDateTime.of(2020, 5, 1,1,1,1)
    }

    def "given an event to add should run addEvent function once"(){
        given:
        def event = exampleEventToAdd()
        1 * eventService.addEvent(event)

        when:
        eventController.addEvent(event)
    }

    def "given an id of event to delete should run deleteEvent function once"(){
        given:
        def id = 1
        1 * eventService.deleteEvent(id)

        when:
        eventController.deleteEvent(id)
    }
}
