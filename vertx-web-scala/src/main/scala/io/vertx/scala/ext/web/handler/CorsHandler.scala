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
import io.vertx.core.http.HttpMethod
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.core.Handler

/**
  * A handler which implements server side http://www.w3.org/TR/cors/[CORS] support for Vert.x-Web.
  */
class CorsHandler(private val _asJava: io.vertx.ext.web.handler.CorsHandler) {

  def asJava: io.vertx.ext.web.handler.CorsHandler = _asJava

  def handle(arg0: io.vertx.scala.ext.web.RoutingContext): Unit = {
    _asJava.handle(arg0.asJava.asInstanceOf[io.vertx.ext.web.RoutingContext])
  }

  /**
    * Add an allowed method
    * @param method the method to add
    * @return a reference to this, so the API can be used fluently
    */
  def allowedMethod(method: io.vertx.core.http.HttpMethod): io.vertx.scala.ext.web.handler.CorsHandler = {
    _asJava.allowedMethod(method)
    this
  }

  /**
    * Add an allowed header
    * @param headerName the allowed header name
    * @return a reference to this, so the API can be used fluently
    */
  def allowedHeader(headerName: String): io.vertx.scala.ext.web.handler.CorsHandler = {
    _asJava.allowedHeader(headerName)
    this
  }

  /**
    * Add a set of allowed headers
    * @param headerNames the allowed header names
    * @return a reference to this, so the API can be used fluently
    */
  def allowedHeaders(headerNames: Set[String]): io.vertx.scala.ext.web.handler.CorsHandler = {
    _asJava.allowedHeaders(headerNames.map(x => if (x == null) null else x:java.lang.String).asJava)
    this
  }

  /**
    * Add an exposed header
    * @param headerName the exposed header name
    * @return a reference to this, so the API can be used fluently
    */
  def exposedHeader(headerName: String): io.vertx.scala.ext.web.handler.CorsHandler = {
    _asJava.exposedHeader(headerName)
    this
  }

  /**
    * Add a set of exposed headers
    * @param headerNames the exposed header names
    * @return a reference to this, so the API can be used fluently
    */
  def exposedHeaders(headerNames: Set[String]): io.vertx.scala.ext.web.handler.CorsHandler = {
    _asJava.exposedHeaders(headerNames.map(x => if (x == null) null else x:java.lang.String).asJava)
    this
  }

  /**
    * Set whether credentials are allowed
    * @param allow true if allowed
    * @return a reference to this, so the API can be used fluently
    */
  def allowCredentials(allow: Boolean): io.vertx.scala.ext.web.handler.CorsHandler = {
    _asJava.allowCredentials(allow)
    this
  }

  /**
    * Set how long the browser should cache the information
    * @param maxAgeSeconds max age in seconds
    * @return a reference to this, so the API can be used fluently
    */
  def maxAgeSeconds(maxAgeSeconds: Int): io.vertx.scala.ext.web.handler.CorsHandler = {
    _asJava.maxAgeSeconds(maxAgeSeconds)
    this
  }

}

object CorsHandler {

  def apply(_asJava: io.vertx.ext.web.handler.CorsHandler): io.vertx.scala.ext.web.handler.CorsHandler =
    new io.vertx.scala.ext.web.handler.CorsHandler(_asJava)

  def create(allowedOriginPattern: String): io.vertx.scala.ext.web.handler.CorsHandler = {
    CorsHandler.apply(io.vertx.ext.web.handler.CorsHandler.create(allowedOriginPattern))
  }

}
