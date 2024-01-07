package org.java.mql.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class RestConfigDef extends ResourceConfig {

	public RestConfigDef() {
		packages("org.java.mql");
	}

}
