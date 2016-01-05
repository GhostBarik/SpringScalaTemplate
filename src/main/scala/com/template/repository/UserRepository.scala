package com.template.repository

import com.template.model.User
import org.springframework.data.repository.CrudRepository

/**
 * User repository
 */
trait UserRepository extends CrudRepository[User, java.lang.Long] {
    // ...
}
