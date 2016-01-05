package com.template.service

import com.template.aspect.Profiling
import org.springframework.stereotype.Service

/**
  * dummy service
  */
@Service
class DummyService {

  @Profiling
  def callMe = "Hello!"
}
