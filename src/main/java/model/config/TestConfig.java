package model.config;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestConfig {
    @JsonProperty("base_url")
    private String baseUrl;

    @JsonProperty("selenium_browser")
    private String browser;

    @JsonProperty("selenium_browser_version")
    private String browserVersion;

    @JsonProperty("selenium_timeout")
    private Long timeout;

    @JsonProperty("selenium_headless")
    private Boolean headless;

    @JsonProperty("selenium_browser_size")
    private String browserSize;

    @JsonProperty("selenium_vnc")
    private Boolean enabledVnc;

    @JsonProperty("selenium_start_maximized")
    private Boolean startMaximized;

    @JsonProperty("selenide_screenshots")
    private Boolean selenideScreenshots;

    @JsonProperty("selenide_save_page_source")
    private Boolean selenideSavePageSource;
}