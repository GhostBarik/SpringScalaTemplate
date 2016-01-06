package com.template.model

import javax.persistence._

import scala.beans.BeanProperty

/**
  * User entity
  */
@Entity
@Table(name = "USER")
class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  @BeanProperty
  var id: Long = _

  @Column(name = "USERNAME", length = 100)
  @BeanProperty
  var username: String = _

  override def toString = "User{" + "id=" + id + ", username='" + username + '\'' + '}'
}
