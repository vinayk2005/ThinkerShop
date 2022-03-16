package com.thinker.workshop.usecase;

import com.thinker.workshop.entity.User;
import com.thinker.workshop.usecase.bridge.UserRepository;
import com.thinker.workshop.usecase.exception.NotAllowedException;

public final class LoginUser {

//  private final UserRepository userRepository;
//  private final PasswordEncoder passwordEncoder;
//
//  public LoginUser(final UserRepository userRepository, final PasswordEncoder passwordEncoder) {
//    this.userRepository = userRepository;
//    this.passwordEncoder = passwordEncoder;
//  }
//
//  public User login(final String email, final String password) {
//    User user = userRepository.findByEmail(email).orElseThrow(() -> new NotAllowedException("Not allowed"));
//    String hashedPassword = passwordEncoder.encode(email + password);
//    if (!user.getPassword().equals(hashedPassword)) throw new NotAllowedException("Not allowed");
//    return user;
//  }
}