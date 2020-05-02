package app.planer.configuration

import app.planer.service.EventService
import app.planer.service.TaskService
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import spock.mock.DetachedMockFactory

@TestConfiguration
class ServiceMockConfiguration {
    def mockFactory = new DetachedMockFactory()
    @Bean
    TaskService taskServiceMock() {
       return mockFactory.Mock(TaskService)
    }

    @Bean
    EventService eventServiceMock() {
        return mockFactory.Mock(EventService)
    }
}
