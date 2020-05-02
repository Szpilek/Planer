package app.planer.configuration

import app.planer.service.EventService
import app.planer.service.TaskService
import org.hibernate.validator.HibernateValidator
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor
import spock.mock.DetachedMockFactory

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

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

    @Bean
     MethodValidationPostProcessor validatorProcessor() {
        return new MethodValidationPostProcessor()
    }
}
