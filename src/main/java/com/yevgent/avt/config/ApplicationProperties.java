package com.yevgent.avt.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class ApplicationProperties {

    /**
     * Azure Endpoint
     */
    private String azureTranslatorEndpoint;

    /**
     * Azure Translator Region
     */
    private String azureTranslatorRegion;

    /**
     * Azure Translator Key
     */
    private String azureTranslatorKey;

    /**
     * Azure Speech Service Region
     */
    private String azureSpeechRegion;

    /**
     * Azure Speech Service Key
     */
    private String azureSpeechKey;
}
