package com.marcarndt.swarm.service;

import com.marcarndt.morse.service.MongoService;
import com.marcarndt.swarm.data.Application;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by arndt on 2017/05/03.
 */
@Stateless
public class ApplicationService {

  private static final Logger LOG = Logger.getLogger(ApplicationService.class.getName());

  @Inject
  MongoService mongoService;

  public void addApplication(String application) {
    Application applicationObject = new Application();
    applicationObject.setApplication(application);
    mongoService.getDatastore().save(applicationObject);
  }

  public List<String> getApplications() {
    return mongoService.getDatastore().createQuery(Application.class).asList().stream()
        .map(application -> application.getApplication()).sorted().collect(
            Collectors.toList());
  }

  public Application getApplication(String name) {
    return mongoService.getDatastore().createQuery(Application.class).field("application")
        .equal(name).get();
  }


}
