package cielo.clientes.infra.config;

import java.io.File;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info().title(getPomApplicationName())
                        .description(getPomApplicationDescription())
                        .version(getPomVersion())
                        .license(new License().name("MIT")))
                .servers(Arrays.asList(new Server().url("http://localhost:8080/")));
    }

    private String getPomApplicationName() {
        Node nameNode = getPom().getElementsByTagName("name").item(0);
        return "CieloDev - " + nameNode.getTextContent();
    }

    private String getPomApplicationDescription() {
        Node descriptionNode = getPom().getElementsByTagName("description").item(0);
        return descriptionNode.getTextContent();
    }

    private String getPomVersion() {
        Node versionNode = getPom().getElementsByTagName("version").item(1);
        return versionNode.getTextContent();
    }

    private Document getPom() {
        try {
            File pomFile = new File("pom.xml");
           
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(pomFile);
            return document;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
