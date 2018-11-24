package edu.averagejoecoffeeco.userdb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import edu.averagejoecoffeeco.userdb.api.entities.User;

@Repository
public interface IUserRepository extends MongoRepository<User, String> {
  //Test
  @Query (value = "{'firstName':?0}")
  List<User> findByfirstName(String firstname);
  
  @Query (value = "{'username':?0}")
  User findByusername(String username);

}
