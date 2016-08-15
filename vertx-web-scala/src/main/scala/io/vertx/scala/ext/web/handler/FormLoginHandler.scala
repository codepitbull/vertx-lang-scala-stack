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

package io.vertx.scala.ext.web.handler

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.core.Handler
import io.vertx.scala.ext.auth.AuthProvider

/**
  * Handler that handles login from a form on a custom login page.
  * 
  * Used in conjunction with the [[io.vertx.scala.ext.web.handler.RedirectAuthHandler]].
  */
class FormLoginHandler(private val _asJava: io.vertx.ext.web.handler.FormLoginHandler) {

  def asJava: io.vertx.ext.web.handler.FormLoginHandler = _asJava

  def handle(arg0: io.vertx.scala.ext.web.RoutingContext): Unit = {
    _asJava.handle(arg0.asJava.asInstanceOf[io.vertx.ext.web.RoutingContext])
  }

  /**
    * Set the name of the form param used to submit the username
    * @param usernameParam the name of the param
    * @return a reference to this for a fluent API
    */
  def setUsernameParam(usernameParam: String): io.vertx.scala.ext.web.handler.FormLoginHandler = {
    _asJava.setUsernameParam(usernameParam)
    this
  }

  /**
    * Set the name of the form param used to submit the password
    * @param passwordParam the name of the param
    * @return a reference to this for a fluent API
    */
  def setPasswordParam(passwordParam: String): io.vertx.scala.ext.web.handler.FormLoginHandler = {
    _asJava.setPasswordParam(passwordParam)
    this
  }

  /**
    * Set the name of the session attrioute used to specify the return url
    * @param returnURLParam the name of the param
    * @return a reference to this for a fluent API
    */
  def setReturnURLParam(returnURLParam: String): io.vertx.scala.ext.web.handler.FormLoginHandler = {
    _asJava.setReturnURLParam(returnURLParam)
    this
  }

  /**
    * Set the url to redirect to if the user logs in directly at the url of the form login handler
    * without being redirected here first
    * @param directLoggedInOKURL the URL to redirect to
    * @return a reference to this for a fluent API
    */
  def setDirectLoggedInOKURL(directLoggedInOKURL: String): io.vertx.scala.ext.web.handler.FormLoginHandler = {
    _asJava.setDirectLoggedInOKURL(directLoggedInOKURL)
    this
  }

}

object FormLoginHandler {

  def apply(_asJava: io.vertx.ext.web.handler.FormLoginHandler): io.vertx.scala.ext.web.handler.FormLoginHandler =
    new io.vertx.scala.ext.web.handler.FormLoginHandler(_asJava)
  def create(authProvider: io.vertx.scala.ext.auth.AuthProvider): io.vertx.scala.ext.web.handler.FormLoginHandler = {
    FormLoginHandler.apply(io.vertx.ext.web.handler.FormLoginHandler.create(authProvider.asJava.asInstanceOf[io.vertx.ext.auth.AuthProvider]))
  }
  def create(authProvider: io.vertx.scala.ext.auth.AuthProvider, usernameParam: String, passwordParam: String, returnURLParam: String, directLoggedInOKURL: String): io.vertx.scala.ext.web.handler.FormLoginHandler = {
    FormLoginHandler.apply(io.vertx.ext.web.handler.FormLoginHandler.create(authProvider.asJava.asInstanceOf[io.vertx.ext.auth.AuthProvider], usernameParam, passwordParam, returnURLParam, directLoggedInOKURL))
  }
}
