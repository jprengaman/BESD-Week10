package com.promineotech;

public class Sport {
  private int id;
  private String name;
  
  public Sport() {
    
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  
  @Override
  public String toString() {
    return String.format("[%s] %s", getId(), getName());
  }
}
