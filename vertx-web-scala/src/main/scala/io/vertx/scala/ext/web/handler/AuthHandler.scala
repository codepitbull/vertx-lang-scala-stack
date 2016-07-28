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

package io.vertx.scala.ext.web.handler;

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import scala.util.Try
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.core.Handler

/**
  * Base interface for auth handlers.
  * 
  * An auth handler allows your application to provide authentication/authorisation support.
  * 
  * Auth handler requires a [[io.vertx.scala.ext.web.handler.SessionHandler]] to be on the routing chain before it.
  */
trait AuthHandler {

  def asJava: java.lang.Object

    def handle(arg0: io.vertx.scala.ext.web.RoutingContext): Unit

  /**
  * Add a required authority for this auth handler
  * @param authority the authority
  * @return a reference to this, so the API can be used fluently
  */
  def addAuthority(authority: String): io.vertx.scala.ext.web.handler.AuthHandler

  /**
  * Add a set of required authorities for this auth handler
  * @param authorities the set of authorities
  * @return a reference to this, so the API can be used fluently
  */
  def addAuthorities(authorities: Set[String]): io.vertx.scala.ext.web.handler.AuthHandler

}

object AuthHandler {

  def apply(_asJava: io.vertx.ext.web.handler.AuthHandler): io.vertx.scala.ext.web.handler.AuthHandler =
    new AuthHandlerImpl(_asJava)

  private class AuthHandlerImpl(private val _asJava: io.vertx.ext.web.handler.AuthHandler) extends AuthHandler {

    def asJava: io.vertx.ext.web.handler.AuthHandler = _asJava

    def handle(arg0: io.vertx.scala.ext.web.RoutingContext): Unit = {
        _asJava.handle(arg0.asJava.asInstanceOf[io.vertx.ext.web.RoutingContext])
    }

    /**
      * Add a required authority for this auth handler
      * @param authority the authority
      * @return a reference to this, so the API can be used fluently
      */
    def addAuthority(authority: String): io.vertx.scala.ext.web.handler.AuthHandler = {
        _asJava.addAuthority(authority)
      this
    }

    /**
      * Add a set of required authorities for this auth handler
      * @param authorities the set of authorities
      * @return a reference to this, so the API can be used fluently
      */
    def addAuthorities(authorities: Set[String]): io.vertx.scala.ext.web.handler.AuthHandler = {
        _asJava.addAuthorities(authorities.map(x => if(x == null) null else x:java.lang.String).asJava)
      this
    }

  }

}
