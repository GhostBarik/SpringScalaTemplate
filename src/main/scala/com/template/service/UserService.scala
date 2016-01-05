package com.template.service

import com.template.aspect.Profiling
import com.template.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
  * User service
  */
@Service
class UserService {

  @Autowired
  private var userRepository: UserRepository = _

  @Profiling
  def getAllUsers = userRepository.findAll
}
