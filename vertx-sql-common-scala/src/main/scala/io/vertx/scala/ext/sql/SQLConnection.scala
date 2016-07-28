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

package io.vertx.scala.ext.sql;

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import scala.util.Try
import io.vertx.core.json.JsonArray
import io.vertx.ext.sql.UpdateResult
import io.vertx.ext.sql.ResultSet
import io.vertx.ext.sql.TransactionIsolation
import io.vertx.core.Handler

/**
  * Represents a connection to a SQL database
  */
class SQLConnection(private val _asJava: io.vertx.ext.sql.SQLConnection) {

  def asJava: io.vertx.ext.sql.SQLConnection = _asJava

  /**
    * Sets the auto commit flag for this connection. True by default.
    * @param autoCommit the autoCommit flag, true by default.
    * @param resultHandler the handler which is called once this operation completes.
    */
  def setAutoCommit(autoCommit: Boolean, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.setAutoCommit(autoCommit, funcToHandler(resultHandler))
    this
  }

  /**
    * Executes the given SQL statement
    * @param sql the SQL to execute. For example <code>CREATE TABLE IF EXISTS table ...</code>
    * @param resultHandler the handler which is called once this operation completes.
    */
  def execute(sql: String, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.execute(sql, funcToHandler(resultHandler))
    this
  }

  /**
    * Executes the given SQL <code>SELECT</code> statement which returns the results of the query.
    * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
    * @param resultHandler the handler which is called once the operation completes. It will return a `ResultSet`.
    */
  def query(sql: String, resultHandler: io.vertx.core.AsyncResult[io.vertx.ext.sql.ResultSet] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.query(sql, funcToHandler(resultHandler))
    this
  }

  /**
    * Executes the given SQL <code>SELECT</code> prepared statement which returns the results of the query.
    * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
    * @param params these are the parameters to fill the statement.
    * @param resultHandler the handler which is called once the operation completes. It will return a `ResultSet`.
    */
  def queryWithParams(sql: String, params: io.vertx.core.json.JsonArray, resultHandler: io.vertx.core.AsyncResult[io.vertx.ext.sql.ResultSet] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.queryWithParams(sql, params, funcToHandler(resultHandler))
    this
  }

  /**
    * Executes the given SQL statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
    * statement.
    * @param sql the SQL to execute. For example <code>INSERT INTO table ...</code>
    * @param resultHandler the handler which is called once the operation completes.
    */
  def update(sql: String, resultHandler: io.vertx.core.AsyncResult[io.vertx.ext.sql.UpdateResult] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.update(sql, funcToHandler(resultHandler))
    this
  }

  /**
    * Executes the given prepared statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
    * statement with the given parameters
    * @param sql the SQL to execute. For example <code>INSERT INTO table ...</code>
    * @param params these are the parameters to fill the statement.
    * @param resultHandler the handler which is called once the operation completes.
    */
  def updateWithParams(sql: String, params: io.vertx.core.json.JsonArray, resultHandler: io.vertx.core.AsyncResult[io.vertx.ext.sql.UpdateResult] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.updateWithParams(sql, params, funcToHandler(resultHandler))
    this
  }

  /**
    * Calls the given SQL <code>PROCEDURE</code> which returns the result from the procedure.
    * @param sql the SQL to execute. For example <code>{call getEmpName (?, ?)`</code>.
    * @param resultHandler the handler which is called once the operation completes. It will return a `ResultSet`.
    */
  def call(sql: String, resultHandler: io.vertx.core.AsyncResult[io.vertx.ext.sql.ResultSet] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.call(sql, funcToHandler(resultHandler))
    this
  }

  /**
    * Calls the given SQL <code>PROCEDURE</code> which returns the result from the procedure.
    *
    * The index of params and outputs are important for both arrays, for example when dealing with a prodecure that
    * takes the first 2 arguments as input values and the 3 arg as an output then the arrays should be like:
    *
    * <pre>
    *   params = [VALUE1, VALUE2, null]
    *   outputs = [null, null, "VARCHAR"]
    * </pre>
    * @param sql the SQL to execute. For example <code>{call getEmpName (?, ?)`</code>.
    * @param params these are the parameters to fill the statement.
    * @param outputs these are the outputs to fill the statement.
    * @param resultHandler the handler which is called once the operation completes. It will return a `ResultSet`.
    */
  def callWithParams(sql: String, params: io.vertx.core.json.JsonArray, outputs: io.vertx.core.json.JsonArray, resultHandler: io.vertx.core.AsyncResult[io.vertx.ext.sql.ResultSet] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.callWithParams(sql, params, outputs, funcToHandler(resultHandler))
    this
  }

  /**
    * Closes the connection. Important to always close the connection when you are done so it's returned to the pool.
    * @param handler the handler called when this operation completes.
    */
  def close(handler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): Unit = {
    _asJava.close(funcToHandler(handler))
  }

  /**
    * Closes the connection. Important to always close the connection when you are done so it's returned to the pool.
    */
  def close(): Unit = {
    _asJava.close()
  }

  /**
    * Commits all changes made since the previous commit/rollback.
    * @param handler the handler called when this operation completes.
    */
  def commit(handler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.commit(funcToHandler(handler))
    this
  }

  /**
    * Rolls back all changes made since the previous commit/rollback.
    * @param handler the handler called when this operation completes.
    */
  def rollback(handler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.rollback(funcToHandler(handler))
    this
  }

  /**
    * Sets a connection wide query timeout.
    *
    * It can be over written at any time and becomes active on the next query call.
    * @param timeoutInSeconds the max amount of seconds the query can take to execute.
    */
  def setQueryTimeout(timeoutInSeconds: Int): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.setQueryTimeout(timeoutInSeconds)
    this
  }

  /**
    * Batch simple SQL strings and execute the batch where the async result contains a array of Integers.
    * @param sqlStatements sql statement
    * @param handler the result handler
    */
  def batch(sqlStatements: List[String], handler: io.vertx.core.AsyncResult[java.util.List[java.lang.Integer]] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.batch(sqlStatements.map(x => if(x == null) null else x:java.lang.String).asJava, funcToHandler(handler))
    this
  }

  /**
    * Batch a prepared statement with all entries from the args list. Each entry is a batch.
    * The operation completes with the execution of the batch where the async result contains a array of Integers.
    * @param sqlStatement sql statement
    * @param args the prepared statement arguments
    * @param handler the result handler
    */
  def batchWithParams(sqlStatement: String, args: List[io.vertx.core.json.JsonArray], handler: io.vertx.core.AsyncResult[java.util.List[java.lang.Integer]] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.batchWithParams(sqlStatement, args.map(x => if(x == null) null else x:io.vertx.core.json.JsonArray).asJava, funcToHandler(handler))
    this
  }

  /**
    * Batch a callable statement with all entries from the args list. Each entry is a batch.
    * The size of the lists inArgs and outArgs MUST be the equal.
    * The operation completes with the execution of the batch where the async result contains a array of Integers.
    * @param sqlStatement sql statement
    * @param inArgs the callable statement input arguments
    * @param outArgs the callable statement output arguments
    * @param handler the result handler
    */
  def batchCallableWithParams(sqlStatement: String, inArgs: List[io.vertx.core.json.JsonArray], outArgs: List[io.vertx.core.json.JsonArray], handler: io.vertx.core.AsyncResult[java.util.List[java.lang.Integer]] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.batchCallableWithParams(sqlStatement, inArgs.map(x => if(x == null) null else x:io.vertx.core.json.JsonArray).asJava, outArgs.map(x => if(x == null) null else x:io.vertx.core.json.JsonArray).asJava, funcToHandler(handler))
    this
  }

  /**
    * Attempts to change the transaction isolation level for this Connection object to the one given.
    *
    * The constants defined in the interface Connection are the possible transaction isolation levels.
    * @param isolation the level of isolation
    * @param handler the handler called when this operation completes.
    */
  def setTransactionIsolation(isolation: io.vertx.ext.sql.TransactionIsolation, handler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.setTransactionIsolation(isolation, funcToHandler(handler))
    this
  }

  /**
    * Attempts to return the transaction isolation level for this Connection object to the one given.
    * @param handler the handler called when this operation completes.
    */
  def getTransactionIsolation(handler: io.vertx.core.AsyncResult[io.vertx.ext.sql.TransactionIsolation] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.getTransactionIsolation(funcToHandler(handler))
    this
  }

}

object SQLConnection {

  def apply(_asJava: io.vertx.ext.sql.SQLConnection): io.vertx.scala.ext.sql.SQLConnection =
    new io.vertx.scala.ext.sql.SQLConnection(_asJava)
}
