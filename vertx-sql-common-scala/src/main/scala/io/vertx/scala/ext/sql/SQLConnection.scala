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

package io.vertx.scala.ext.sql

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
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
  def setAutoCommitWithHandler(autoCommit: Boolean)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.setAutoCommit(autoCommit, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  /**
    * Executes the given SQL statement
    * @param sql the SQL to execute. For example <code>CREATE TABLE IF EXISTS table ...</code>
    * @param resultHandler the handler which is called once this operation completes.
    */
  def executeWithHandler(sql: String)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.execute(sql, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  /**
    * Executes the given SQL <code>SELECT</code> statement which returns the results of the query.
    * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
    * @param resultHandler the handler which is called once the operation completes. It will return a `ResultSet`.
    */
  def queryWithHandler(sql: String)( resultHandler: io.vertx.core.AsyncResult [io.vertx.scala.ext.sql.ResultSet] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.query(sql, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.sql.ResultSet], io.vertx.core.AsyncResult [io.vertx.scala.ext.sql.ResultSet]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.sql.ResultSet, io.vertx.scala.ext.sql.ResultSet](x,(x => ResultSet(x))))(resultHandler))
    this
  }

  /**
    * Executes the given SQL <code>SELECT</code> prepared statement which returns the results of the query.
    * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
    * @param params these are the parameters to fill the statement.
    * @param resultHandler the handler which is called once the operation completes. It will return a `ResultSet`.
    */
  def queryWithParamsWithHandler(sql: String, params: io.vertx.core.json.JsonArray)( resultHandler: io.vertx.core.AsyncResult [io.vertx.scala.ext.sql.ResultSet] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.queryWithParams(sql, params, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.sql.ResultSet], io.vertx.core.AsyncResult [io.vertx.scala.ext.sql.ResultSet]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.sql.ResultSet, io.vertx.scala.ext.sql.ResultSet](x,(x => ResultSet(x))))(resultHandler))
    this
  }

  /**
    * Executes the given SQL statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
    * statement.
    * @param sql the SQL to execute. For example <code>INSERT INTO table ...</code>
    * @param resultHandler the handler which is called once the operation completes.
    */
  def updateWithHandler(sql: String)( resultHandler: io.vertx.core.AsyncResult [io.vertx.scala.ext.sql.UpdateResult] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.update(sql, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.sql.UpdateResult], io.vertx.core.AsyncResult [io.vertx.scala.ext.sql.UpdateResult]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.sql.UpdateResult, io.vertx.scala.ext.sql.UpdateResult](x,(x => UpdateResult(x))))(resultHandler))
    this
  }

  /**
    * Executes the given prepared statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
    * statement with the given parameters
    * @param sql the SQL to execute. For example <code>INSERT INTO table ...</code>
    * @param params these are the parameters to fill the statement.
    * @param resultHandler the handler which is called once the operation completes.
    */
  def updateWithParamsWithHandler(sql: String, params: io.vertx.core.json.JsonArray)( resultHandler: io.vertx.core.AsyncResult [io.vertx.scala.ext.sql.UpdateResult] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.updateWithParams(sql, params, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.sql.UpdateResult], io.vertx.core.AsyncResult [io.vertx.scala.ext.sql.UpdateResult]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.sql.UpdateResult, io.vertx.scala.ext.sql.UpdateResult](x,(x => UpdateResult(x))))(resultHandler))
    this
  }

  /**
    * Calls the given SQL <code>PROCEDURE</code> which returns the result from the procedure.
    * @param sql the SQL to execute. For example <code>{call getEmpName (?, ?)`</code>.
    * @param resultHandler the handler which is called once the operation completes. It will return a `ResultSet`.
    */
  def callWithHandler(sql: String)( resultHandler: io.vertx.core.AsyncResult [io.vertx.scala.ext.sql.ResultSet] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.call(sql, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.sql.ResultSet], io.vertx.core.AsyncResult [io.vertx.scala.ext.sql.ResultSet]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.sql.ResultSet, io.vertx.scala.ext.sql.ResultSet](x,(x => ResultSet(x))))(resultHandler))
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
  def callWithParamsWithHandler(sql: String, params: io.vertx.core.json.JsonArray, outputs: io.vertx.core.json.JsonArray)( resultHandler: io.vertx.core.AsyncResult [io.vertx.scala.ext.sql.ResultSet] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.callWithParams(sql, params, outputs, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.sql.ResultSet], io.vertx.core.AsyncResult [io.vertx.scala.ext.sql.ResultSet]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.sql.ResultSet, io.vertx.scala.ext.sql.ResultSet](x,(x => ResultSet(x))))(resultHandler))
    this
  }

  /**
    * Closes the connection. Important to always close the connection when you are done so it's returned to the pool.
    * @param handler the handler called when this operation completes.
    */
  def close(handler: io.vertx.core.AsyncResult [Unit] => Unit): Unit = {
    _asJava.close(funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(handler))
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
  def commit(handler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.commit(funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(handler))
    this
  }

  /**
    * Rolls back all changes made since the previous commit/rollback.
    * @param handler the handler called when this operation completes.
    */
  def rollback(handler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.rollback(funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(handler))
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
  def batchWithHandler(sqlStatements: scala.collection.mutable.Buffer[String])( handler: io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[Int]] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.batch(sqlStatements.map(x => if(x == null) null else x:java.lang.String).asJava, funcToMappedHandler[io.vertx.core.AsyncResult[java.util.List[java.lang.Integer]], io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[Int]]](x => io.vertx.lang.scala.AsyncResult[java.util.List[java.lang.Integer], scala.collection.mutable.Buffer[Int]](x,x => if (x == null) null else x.asScala.map(x => x:Int)))(handler))
    this
  }

  /**
    * Batch a prepared statement with all entries from the args list. Each entry is a batch.
    * The operation completes with the execution of the batch where the async result contains a array of Integers.
    * @param sqlStatement sql statement
    * @param args the prepared statement arguments
    * @param handler the result handler
    */
  def batchWithParamsWithHandler(sqlStatement: String, args: scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray])( handler: io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[Int]] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.batchWithParams(sqlStatement, args.map(x => if(x == null) null else x:io.vertx.core.json.JsonArray).asJava, funcToMappedHandler[io.vertx.core.AsyncResult[java.util.List[java.lang.Integer]], io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[Int]]](x => io.vertx.lang.scala.AsyncResult[java.util.List[java.lang.Integer], scala.collection.mutable.Buffer[Int]](x,x => if (x == null) null else x.asScala.map(x => x:Int)))(handler))
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
  def batchCallableWithParamsWithHandler(sqlStatement: String, inArgs: scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray], outArgs: scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray])( handler: io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[Int]] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.batchCallableWithParams(sqlStatement, inArgs.map(x => if(x == null) null else x:io.vertx.core.json.JsonArray).asJava, outArgs.map(x => if(x == null) null else x:io.vertx.core.json.JsonArray).asJava, funcToMappedHandler[io.vertx.core.AsyncResult[java.util.List[java.lang.Integer]], io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[Int]]](x => io.vertx.lang.scala.AsyncResult[java.util.List[java.lang.Integer], scala.collection.mutable.Buffer[Int]](x,x => if (x == null) null else x.asScala.map(x => x:Int)))(handler))
    this
  }

  /**
    * Attempts to change the transaction isolation level for this Connection object to the one given.
    *
    * The constants defined in the interface Connection are the possible transaction isolation levels.
    * @param isolation the level of isolation
    * @param handler the handler called when this operation completes.
    */
  def setTransactionIsolationWithHandler(isolation: io.vertx.ext.sql.TransactionIsolation)( handler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.setTransactionIsolation(isolation, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(handler))
    this
  }

  /**
    * Attempts to return the transaction isolation level for this Connection object to the one given.
    * @param handler the handler called when this operation completes.
    */
  def getTransactionIsolation(handler: io.vertx.core.AsyncResult [io.vertx.ext.sql.TransactionIsolation] => Unit): io.vertx.scala.ext.sql.SQLConnection = {
    _asJava.getTransactionIsolation(funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.sql.TransactionIsolation], io.vertx.core.AsyncResult [io.vertx.ext.sql.TransactionIsolation]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.sql.TransactionIsolation, io.vertx.ext.sql.TransactionIsolation](x,(x => x)))(handler))
    this
  }

}

object SQLConnection {

  def apply(_asJava: io.vertx.ext.sql.SQLConnection): io.vertx.scala.ext.sql.SQLConnection =
    new io.vertx.scala.ext.sql.SQLConnection(_asJava)
}
