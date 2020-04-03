package com.tsanda.services;

import com.tsanda.entities.BuildProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BuildPropertiesService {

  private static final Logger logger = LogManager.getLogger();

  @Value("${expanded.project.version}")
  private String version;

  public BuildProperties getBuildPropertiesVersion() {
    try {
      BuildProperties buildProperties = new BuildProperties(version);
      logger.debug("Getting project version: " + buildProperties.getVersion());
      return buildProperties;
    } catch (Exception e) {
      logger.warn("Something went wrong when getting the project version.");
      return null;
    }
  }
}
