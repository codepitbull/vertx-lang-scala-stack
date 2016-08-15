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

package io.vertx.scala.ext.web.sstore

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.scala.ext.web.Session
import io.vertx.core.Handler

/**
  * A session store is used to store sessions for an Vert.x-Web web app
  */
class SessionStore(private val _asJava: io.vertx.ext.web.sstore.SessionStore) {

  def asJava: io.vertx.ext.web.sstore.SessionStore = _asJava

  /**
    * The retry timeout value in milli seconds used by the session handler when it retrieves a value from the store.<p/>
    *
    * A non positive value means there is no retry at all.
    * @return the timeout value, in ms
    */
  def retryTimeout(): Long = {
    _asJava.retryTimeout()
  }

  /**
    * Create a new session
    * @param timeout - the session timeout, in ms
    * @return the session
    */
  def createSession(timeout: Long): io.vertx.scala.ext.web.Session = {
    Session.apply(_asJava.createSession(timeout))
  }

  /**
    * Get the session with the specified ID
    * @param id the unique ID of the session
    * @param resultHandler will be called with a result holding the session, or a failure
    */
  def getWithHandler(id: String)( resultHandler: io.vertx.core.AsyncResult [io.vertx.scala.ext.web.Session] => Unit): Unit = {
    _asJava.get(id, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.web.Session], io.vertx.core.AsyncResult [io.vertx.scala.ext.web.Session]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.web.Session, io.vertx.scala.ext.web.Session](x,(x => if (x == null) null else Session.apply(x))))(resultHandler))
  }

  /**
    * Delete the session with the specified ID
    * @param id the unique ID of the session
    * @param resultHandler will be called with a result true/false, or a failure
    */
  def deleteWithHandler(id: String)( resultHandler: io.vertx.core.AsyncResult [Boolean] => Unit): Unit = {
    _asJava.delete(id, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Boolean], io.vertx.core.AsyncResult [Boolean]](x => io.vertx.lang.scala.AsyncResult[java.lang.Boolean, Boolean](x,(x => x)))(resultHandler))
  }

  /**
    * Add a session with the specified ID
    * @param session the session
    * @param resultHandler will be called with a result true/false, or a failure
    */
  def putWithHandler(session: io.vertx.scala.ext.web.Session)( resultHandler: io.vertx.core.AsyncResult [Boolean] => Unit): Unit = {
    _asJava.put(session.asJava.asInstanceOf[io.vertx.ext.web.Session], funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Boolean], io.vertx.core.AsyncResult [Boolean]](x => io.vertx.lang.scala.AsyncResult[java.lang.Boolean, Boolean](x,(x => x)))(resultHandler))
  }

  /**
    * Remove all sessions from the store
    * @param resultHandler will be called with a result true/false, or a failure
    */
  def clear(resultHandler: io.vertx.core.AsyncResult [Boolean] => Unit): Unit = {
    _asJava.clear(funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Boolean], io.vertx.core.AsyncResult [Boolean]](x => io.vertx.lang.scala.AsyncResult[java.lang.Boolean, Boolean](x,(x => x)))(resultHandler))
  }

  /**
    * Get the number of sessions in the store
    * @param resultHandler will be called with the number, or a failure
    */
  def size(resultHandler: io.vertx.core.AsyncResult [Int] => Unit): Unit = {
    _asJava.size(funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Integer], io.vertx.core.AsyncResult [Int]](x => io.vertx.lang.scala.AsyncResult[java.lang.Integer, Int](x,(x => x)))(resultHandler))
  }

  /**
    * Close the store
    */
  def close(): Unit = {
    _asJava.close()
  }

}

object SessionStore {

  def apply(_asJava: io.vertx.ext.web.sstore.SessionStore): io.vertx.scala.ext.web.sstore.SessionStore =
    new io.vertx.scala.ext.web.sstore.SessionStore(_asJava)
}
