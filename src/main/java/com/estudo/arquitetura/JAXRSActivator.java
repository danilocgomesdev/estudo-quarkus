package com.estudo.arquitetura;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

// OpenApiDefinition está no arquivo .properties
// Foi utilizado para poder ter diferentes documentações em diferentes ambientes
@SuppressWarnings({"checkstyle:MissingJavadocType", "checkstyle:AbbreviationAsWordInName"})
@ApplicationPath("/api")
public class JAXRSActivator extends Application {

}
