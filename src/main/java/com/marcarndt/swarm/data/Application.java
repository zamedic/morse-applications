package com.marcarndt.swarm.data;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Created by arndt on 2017/05/03.
 */
@Entity
public class Application {

  @Id
  private ObjectId objectId;
  String application;

  public String getApplication() {
    return application;
  }

  public void setApplication(String application) {
    this.application = application;
  }


}
