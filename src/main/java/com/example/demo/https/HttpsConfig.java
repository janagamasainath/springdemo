package com.example.demo.https;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpsConfig {

    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(org.apache.catalina.Context context) {
                org.apache.catalina.connector.Connector connector = new org.apache.catalina.connector.Connector(
                        org.apache.coyote.http11.Http11NioProtocol.class.getName());
                connector.setScheme("http");
                connector.setPort(8080);
                connector.setSecure(false);
                connector.setRedirectPort(9999);
                addAdditionalTomcatConnectors(connector);
            }
        };
        return tomcat;
    }
}