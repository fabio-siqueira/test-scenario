package dev.lecture.testscenario.config

import groovy.transform.CompileStatic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Profile
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType

import javax.sql.DataSource

@Configuration
@CompileStatic
class DatasourceConfig {

    @Bean
    @Primary
    @Profile(['dev', 'test'])
    DataSource inMemoryDatasource() {
        new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .continueOnError(false)
            .generateUniqueName(true)
            .addScript("/static/schema-dev.sql")
            .addScript("/static/table-schema.sql")
            .build()
    }
}