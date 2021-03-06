/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.scala.ext.auth.shiro

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.scala.ext.auth.User
import io.vertx.scala.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.core.Handler
import io.vertx.ext.auth.shiro.ShiroAuthOptions
import io.vertx.ext.auth.shiro.ShiroAuthRealmType
import io.vertx.scala.ext.auth.AuthProvider

/**
  * Factory interface for creating Apache Shiro based [[io.vertx.scala.ext.auth.AuthProvider]] instances.
  */
class ShiroAuth(private val _asJava: io.vertx.ext.auth.shiro.ShiroAuth) {

  def asJava: io.vertx.ext.auth.shiro.ShiroAuth = _asJava

  /**
    * Set the role prefix to distinguish from permissions when checking for isPermitted requests.
    * @param rolePrefix a Prefix e.g.: "role:"
    * @return a reference to this for fluency
    */
  def setRolePrefix(rolePrefix: String): io.vertx.scala.ext.auth.shiro.ShiroAuth = {
    ShiroAuth.apply(_asJava.setRolePrefix(rolePrefix))
  }

}

object ShiroAuth {

  def apply(_asJava: io.vertx.ext.auth.shiro.ShiroAuth): io.vertx.scala.ext.auth.shiro.ShiroAuth =
    new io.vertx.scala.ext.auth.shiro.ShiroAuth(_asJava)

  def create(vertx: io.vertx.scala.core.Vertx, realmType: io.vertx.ext.auth.shiro.ShiroAuthRealmType, config: io.vertx.core.json.JsonObject): io.vertx.scala.ext.auth.shiro.ShiroAuth = {
    ShiroAuth.apply(io.vertx.ext.auth.shiro.ShiroAuth.create(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], realmType, config))
  }

  def create(vertx: io.vertx.scala.core.Vertx, options: io.vertx.scala.ext.auth.shiro.ShiroAuthOptions): io.vertx.scala.ext.auth.shiro.ShiroAuth = {
    ShiroAuth.apply(io.vertx.ext.auth.shiro.ShiroAuth.create(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], options.asJava))
  }

}
