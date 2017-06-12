package dev.lecture.testscenario

import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Specification

@ContextConfiguration(loader = SpringBootContextLoader, classes = [Application])
@WebAppConfiguration
@ActiveProfiles(value = ["test"])
class ApplicationTests extends  Specification {

}
