package edu.averagejoecoffeeco.userdb;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import edu.averagejoecoffeeco.userdb.api.entities.User;

@Component
public class UserDbSeeder implements CommandLineRunner {
  @Autowired
  IUserRepository userRepo;

  @Override
  public void run(String ... args){
    User jeremy = new User("jeremy_locatelli","heck","Jeremy","Locatelli",25.0);
    User daniel = new User("d_money","yeet","Daniel","DeLeon",25.0);
    User dallas = new User("d_money2","yeet2","Dallas","Dituri",25.0);
    User jose = new User("josejosejose","jose?","Jose","Garcia",25.0);

    userRepo.deleteAll();
    List<User> users = Arrays.asList(jeremy,daniel,dallas,jose);
    userRepo.saveAll(users);


  }
}
