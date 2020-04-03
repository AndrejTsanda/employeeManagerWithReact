package com.tsanda.controllers;

import com.tsanda.entities.BuildProperties;
import com.tsanda.services.BuildPropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("buildProperties")
public class BuildPropertiesController {

  @Autowired BuildPropertiesService buildPropertiesService;

  @GetMapping(value = "version", produces = MediaType.APPLICATION_JSON_VALUE)
  public BuildProperties getVersion() {
    return buildPropertiesService.getBuildPropertiesVersion();
  }
}
