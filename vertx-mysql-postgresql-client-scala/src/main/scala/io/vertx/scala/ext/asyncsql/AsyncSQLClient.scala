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

package io.vertx.scala.ext.asyncsql

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.scala.ext.sql.SQLConnection
import io.vertx.core.Handler

/**
  * Represents an asynchronous SQL client
  */
class AsyncSQLClient(private val _asJava: io.vertx.ext.asyncsql.AsyncSQLClient) {

  def asJava: io.vertx.ext.asyncsql.AsyncSQLClient = _asJava

  /**
    * Close the client and release all resources.
    * Note that closing is asynchronous.
    */
  def close(): Unit = {
    _asJava.close()
  }

  /**
    * Close the client and release all resources.
    * Call the handler when close is complete.
    * @param whenDone handler that will be called when close is complete
    */
  def close(whenDone: io.vertx.core.AsyncResult [Unit] => Unit): Unit = {
    _asJava.close(funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(whenDone))
  }

  /**
    * Returns a connection that can be used to perform SQL operations on. It's important to remember to close the
    * connection when you are done, so it is returned to the pool.
    * @param handler the handler which is called when the <code>JdbcConnection</code> object is ready for use.
    */
  def getConnection(handler: io.vertx.core.AsyncResult [io.vertx.scala.ext.sql.SQLConnection] => Unit): Unit = {
    _asJava.getConnection(funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.sql.SQLConnection], io.vertx.core.AsyncResult [io.vertx.scala.ext.sql.SQLConnection]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.sql.SQLConnection, io.vertx.scala.ext.sql.SQLConnection](x,(x => if (x == null) null else SQLConnection.apply(x))))(handler))
  }

}

object AsyncSQLClient {

  def apply(_asJava: io.vertx.ext.asyncsql.AsyncSQLClient): io.vertx.scala.ext.asyncsql.AsyncSQLClient =
    new io.vertx.scala.ext.asyncsql.AsyncSQLClient(_asJava)
}
