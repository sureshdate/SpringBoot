package com.springboot.first.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter //create all the setter method withought writing code because we have install lombok
@Getter //create all the getter method withought writing code because we have install lombok
//@EqualsAndHashCode //gives the equal and hascode method
//@AllArgsConstructor //create all constructor with all arguments 
//insted of this we use @data annotation =@Setter+@Getter+@EqualsAndHashCode+@AllArgsConstructors

public class Student {
 public long id;
 public String FirstName;
 public String LastName;

}
  