package app.planer.controller

import app.planer.configuration.ServiceMockConfiguration
import app.planer.controller.requests.EventRequest
import app.planer.model.Event
import app.planer.model.EventType
import app.planer.service.EventService
import org.springframework.beans.factory.annotation.Autowire
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor
import spock.lang.Specification

import javax.validation.ValidationException
import java.time.LocalDateTime

@ContextConfiguration(classes = [ServiceMockConfiguration, EventController])
class EventControllerTest extends Specification {
    @Autowired
    EventController eventController
    @Autowired
    EventService eventService
@Autowired
MethodValidationPostProcessor asd;
    EventRequest exampleEventToAdd() {
        return new EventRequest("event3", LocalDateTime.of(2020, 1, 2, 3, 4, 5))
    }

    Event createEvent(int id, String name, LocalDateTime time) {
        return new Event(
                id,
                time,
                name,
                EventType.FAMILY,
                true
        )
    }

    def exampleEventsToReturn() {
        return [
                createEvent(1, "event1", LocalDateTime.of(2020, 2, 2, 3, 4, 5))
                , createEvent(2, "event2", LocalDateTime.of(2020, 3, 2, 3, 4, 5))
        ]
    }

    def "given date from and date to should return tasks"() {
        given:
        def events = exampleEventsToReturn()
        1 * eventService.getEvents(dateFrom, dateTo) >> events
        when:
        def result = eventController.getEvents(dateFrom, dateTo)

        then:
        result == events

        where:
        dateFrom << LocalDateTime.of(2020, 1, 1, 1, 1, 1)
        dateTo << LocalDateTime.of(2020, 5, 1, 1, 1, 1)
    }

    def "adding an event should be validated"() {
        given:
        def event = new EventRequest(date, name, eventType, isEventActive)

        when:
        eventController.addEvent(event)

        then:
        thrown(ValidationException)

        where:
        name | date                                  | eventType        | isEventActive
        ""   | LocalDateTime.of(2020, 1, 2, 1, 1, 1) | EventType.FAMILY | true
        " "  | LocalDateTime.of(2020, 1, 2, 1, 1, 1) | EventType.FAMILY | true
        "a"  | null                                  | EventType.FAMILY | false
        "a"  | LocalDateTime.of(2020, 1, 2, 1, 1, 1) | null             | true
        "a"  | LocalDateTime.of(2020, 1, 2, 1, 1, 1) | EventType.FAMILY | null
    }

    def "given an event to add should run addEvent function once"() {
        given:
        def event = exampleEventToAdd()
        1 * eventService.addEvent(event)

        when:
        eventController.addEvent(event)

        then:
        noExceptionThrown()
    }


    def "deleting an event calls service"() {
        given:
        def id = 1
        1 * eventService.deleteEvent(id)

        when:
        eventController.deleteEvent(id)

        then:
        noExceptionThrown()
    }
}
