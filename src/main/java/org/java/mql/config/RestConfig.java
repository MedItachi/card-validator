package org.java.mql.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.java.mql.resource.CardResources;
import org.springframework.stereotype.Component;

@Component
public class RestConfig extends ResourceConfig {

	public RestConfig() {
		packages("org.java.mql");
	}

}
