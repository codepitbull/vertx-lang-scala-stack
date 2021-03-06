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

package io.vertx.scala.ext.mail

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._

/**
  * Represent the result of the sendMail operation
  */

class MailResult(val asJava: io.vertx.ext.mail.MailResult) {

  /**
    */
  def setMessageID(value:String) = {
    asJava.setMessageID(value)
    this
  }
  def getMessageID = {
    asJava.getMessageID()
  }

  /**
    */
  def setRecipients(value:scala.collection.mutable.Buffer[String]) = {
    asJava.setRecipients(value)
    this
  }
  def getRecipients = {
    asJava.getRecipients()
  }
}

object MailResult {
  type MailResultJava = io.vertx.ext.mail.MailResult
  
  def apply() = {
    new MailResult(new MailResultJava(io.vertx.lang.scala.json.Json.emptyObj()))
  }
  
  def apply(t: MailResultJava) = {
    if(t != null)
      new MailResult(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):MailResult = {
    if(json != null)
      new MailResult(new MailResultJava(json))
    else
      null
  }
}
