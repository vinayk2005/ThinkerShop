package com.thinker.workshop.adapters.repository;

import com.thinker.workshop.entity.User;
import com.thinker.workshop.usecase.bridge.UserRepository;
import java.util.List;
import java.util.Optional;

public class DBUserRepository implements UserRepository {

  @Override
  public User create(User user) {
    return null;
  }

  @Override
  public Optional<User> findById(String id) {
    return Optional.empty();
  }

  @Override
  public Optional<User> findByEmail(String email) {
    return Optional.empty();
  }

  @Override
  public List<User> findAllUsers() {
    return null;
  }
}
