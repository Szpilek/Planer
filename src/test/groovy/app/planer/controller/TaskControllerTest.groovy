package app.planer.controller

import app.planer.configuration.ServiceMockConfiguration
import app.planer.model.Task
import app.planer.model.TaskImportance
import app.planer.model.TaskState
import app.planer.service.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import java.time.LocalDate

@ContextConfiguration(classes = [ServiceMockConfiguration, TaskController])
class TaskControllerTest extends Specification {
    @Autowired
    TaskController taskController
    @Autowired
    TaskService taskService

    def exampleTask() {
        return new Task(
                "name",
                TaskState.TO_DO,
                TaskImportance.HIGH,
                LocalDate.ofYearDay(2020, 1)
        )
    }

    def "given dateBefore and dateAfter should return apropriate tasks"() {
        given:
        def tasks = [exampleTask(), exampleTask()]
        1 * taskService.getTasks(dateBefore, dateAfter) >> tasks >> Exception

        when:
        def result = taskController.getItems(dateBefore, dateAfter)

        then:
        result == tasks

        where:
        dateBefore                   | dateAfter
        LocalDate.ofYearDay(2020, 1) | LocalDate.ofYearDay(2020, 12)
        LocalDate.ofYearDay(2020, 2) | LocalDate.ofYearDay(2020, 12)
        LocalDate.ofYearDay(2020, 3) | LocalDate.ofYearDay(2020, 12)
//        dateBefore << [LocalDate.ofYearDay(2020, 1), LocalDate.ofYearDay(2020, 1)];
//        dateAfter << [LocalDate.ofYearDay(2020, 1), LocalDate.ofYearDay(2020, 1)];

    }

//    def "should properly add task"(){
//        given:
//
//    }
}
