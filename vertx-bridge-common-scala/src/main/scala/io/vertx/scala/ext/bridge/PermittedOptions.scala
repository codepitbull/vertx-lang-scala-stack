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

package io.vertx.scala.ext.bridge

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._

/**
  * Represents a match to allow for inbound and outbound traffic.
  */

class PermittedOptions(val asJava: io.vertx.ext.bridge.PermittedOptions) {

  /**
    * The exact address the message is being sent to. If you want to allow messages based on
    * an exact address you use this field.
    */
  def setAddress(value:String) = {
    asJava.setAddress(value)
    this
  }
  def getAddress = {
    asJava.getAddress()
  }

  /**
    * A regular expression that will be matched against the address. If you want to allow messages
    * based on a regular expression you use this field. If the <a href="../../../../../../../cheatsheet/PermittedOptions.html">PermittedOptions</a> value is specified
    * this will be ignored.
    */
  def setAddressRegex(value:String) = {
    asJava.setAddressRegex(value)
    this
  }
  def getAddressRegex = {
    asJava.getAddressRegex()
  }

  /**
    * This allows you to allow messages based on their structure. Any fields in the match must exist in the
    * message with the same values for them to be allowed. This currently only works with JSON messages.
    */
  def setMatch(value:io.vertx.core.json.JsonObject) = {
    asJava.setMatch(value)
    this
  }
  def getMatch = {
    asJava.getMatch()
  }
}

object PermittedOptions {
  type PermittedOptionsJava = io.vertx.ext.bridge.PermittedOptions
  
  def apply() = {
    new PermittedOptions(new PermittedOptionsJava(io.vertx.lang.scala.json.Json.emptyObj()))
  }
  
  def apply(t: PermittedOptionsJava) = {
    if(t != null)
      new PermittedOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):PermittedOptions = {
    if(json != null)
      new PermittedOptions(new PermittedOptionsJava(json))
    else
      null
  }
}
