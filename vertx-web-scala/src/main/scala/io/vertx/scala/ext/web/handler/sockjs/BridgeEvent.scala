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

package io.vertx.scala.ext.web.handler.sockjs;

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import scala.util.Try
import io.vertx.ext.web.handler.sockjs.BridgeEventType
import io.vertx.core.json.JsonObject
import io.vertx.scala.core.Future

/**
  * Represents an event that occurs on the event bus bridge.
  * 
  * Please consult the documentation for a full explanation.
  */
class BridgeEvent(private val _asJava: io.vertx.ext.web.handler.sockjs.BridgeEvent) {

  def asJava: io.vertx.ext.web.handler.sockjs.BridgeEvent = _asJava

  /**
    * @return  the type of the event
    */
  def `type`(): io.vertx.ext.web.handler.sockjs.BridgeEventType = {
    if(cached_0 == null) {
      cached_0=    _asJava.`type`()
    }
    cached_0
  }

  /**
    * Use [[io.vertx.scala.ext.web.handler.sockjs.BridgeEvent#getRawMessage]] instead, will be removed in 3.3
    */
  def rawMessage(): io.vertx.core.json.JsonObject = {
    if(cached_1 == null) {
      cached_1=    _asJava.rawMessage()
    }
    cached_1
  }

  /**
    * Get the raw JSON message for the event. This will be null for SOCKET_CREATED or SOCKET_CLOSED events as there is
    * no message involved. If the returned message is modified, [[io.vertx.scala.ext.web.handler.sockjs.BridgeEvent#setRawMessage]] should be called with the
    * new message.
    * @return the raw JSON message for the event
    */
  def getRawMessage(): io.vertx.core.json.JsonObject = {
    _asJava.getRawMessage()
  }

  /**
    * Get the raw JSON message for the event. This will be null for SOCKET_CREATED or SOCKET_CLOSED events as there is
    * no message involved.
    * @param message the raw message
    * @return this reference, so it can be used fluently
    */
  def setRawMessage(message: io.vertx.core.json.JsonObject): io.vertx.scala.ext.web.handler.sockjs.BridgeEvent = {
    _asJava.setRawMessage(message)
    this
  }

  /**
    * Get the SockJSSocket instance corresponding to the event
    * @return the SockJSSocket instance
    */
  def socket(): io.vertx.scala.ext.web.handler.sockjs.SockJSSocket = {
    if(cached_2 == null) {
      cached_2=    SockJSSocket.apply(_asJava.socket())
    }
    cached_2
  }

  private var cached_0: io.vertx.ext.web.handler.sockjs.BridgeEventType = _
  private var cached_1: io.vertx.core.json.JsonObject = _
  private var cached_2: io.vertx.scala.ext.web.handler.sockjs.SockJSSocket = _
}

object BridgeEvent {

  def apply(_asJava: io.vertx.ext.web.handler.sockjs.BridgeEvent): io.vertx.scala.ext.web.handler.sockjs.BridgeEvent =
    new io.vertx.scala.ext.web.handler.sockjs.BridgeEvent(_asJava)
}
