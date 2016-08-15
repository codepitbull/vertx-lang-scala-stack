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

/**
  * Handler that will timeout requests if the response has not been written after a certain time.
  * Timeout requests will be ended with an HTTP status code `503`.
  */
class TimeoutHandler(private val _asJava: io.vertx.ext.web.handler.TimeoutHandler) {

  def asJava: io.vertx.ext.web.handler.TimeoutHandler = _asJava

  def handle(arg0: io.vertx.scala.ext.web.RoutingContext): Unit = {
    _asJava.handle(arg0.asJava.asInstanceOf[io.vertx.ext.web.RoutingContext])
  }

}

object TimeoutHandler {

  def apply(_asJava: io.vertx.ext.web.handler.TimeoutHandler): io.vertx.scala.ext.web.handler.TimeoutHandler =
    new io.vertx.scala.ext.web.handler.TimeoutHandler(_asJava)
  def create(): io.vertx.scala.ext.web.handler.TimeoutHandler = {
    TimeoutHandler.apply(io.vertx.ext.web.handler.TimeoutHandler.create())
  }
  def create(timeout: Long): io.vertx.scala.ext.web.handler.TimeoutHandler = {
    TimeoutHandler.apply(io.vertx.ext.web.handler.TimeoutHandler.create(timeout))
  }
  def create(timeout: Long, errorCode: Int): io.vertx.scala.ext.web.handler.TimeoutHandler = {
    TimeoutHandler.apply(io.vertx.ext.web.handler.TimeoutHandler.create(timeout, errorCode))
  }
}
