package config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties

@Configuration
@EnableConfigurationProperties(ApplicationConfig.Properties::class)
class ApplicationConfig {

    @Value("\${app.name}")
    lateinit var appName: String

    @Value("\${app.version}")
    lateinit var appVersion: String

    @Bean
    fun appProperties(): Properties {
        return Properties(appName, appVersion)
    }

    data class Properties(
        val name: String,
        val version: String
    )
}