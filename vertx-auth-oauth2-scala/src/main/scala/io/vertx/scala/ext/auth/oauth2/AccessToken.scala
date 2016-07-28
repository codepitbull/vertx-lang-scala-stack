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

package io.vertx.scala.ext.auth.oauth2;

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import scala.util.Try
import io.vertx.scala.ext.auth.User
import io.vertx.core.Handler

/**
  * AccessToken extension to the User interface
  */
class AccessToken(private val _asJava: io.vertx.ext.auth.oauth2.AccessToken) {

  def asJava: io.vertx.ext.auth.oauth2.AccessToken = _asJava

  /**
    * Check if the access token is expired or not.
    */
  def expired(): Boolean = {
    _asJava.expired()
  }

  /**
    * Refresh the access token
    * @param callback - The callback function returning the results.
    */
  def refresh(callback: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.auth.oauth2.AccessToken = {
    _asJava.refresh(funcToHandler(callback))
    this
  }

  /**
    * Revoke access or refresh token
    * @param token_type - A String containing the type of token to revoke. Should be either "access_token" or "refresh_token".
    * @param callback - The callback function returning the results.
    */
  def revoke(token_type: String, callback: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.auth.oauth2.AccessToken = {
    _asJava.revoke(token_type, funcToHandler(callback))
    this
  }

  /**
    * Revoke refresh token and calls the logout endpoint. This is a openid-connect extension and might not be
    * available on all providers.
    * @param callback - The callback function returning the results.
    */
  def logout(callback: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.auth.oauth2.AccessToken = {
    _asJava.logout(funcToHandler(callback))
    this
  }

}

object AccessToken {

  def apply(_asJava: io.vertx.ext.auth.oauth2.AccessToken): io.vertx.scala.ext.auth.oauth2.AccessToken =
    new io.vertx.scala.ext.auth.oauth2.AccessToken(_asJava)
}
