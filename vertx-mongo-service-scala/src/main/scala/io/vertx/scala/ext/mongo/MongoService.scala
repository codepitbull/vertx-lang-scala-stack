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

package io.vertx.scala.ext.mongo;

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import scala.util.Try
import io.vertx.ext.mongo.MongoClientDeleteResult
import io.vertx.ext.mongo.WriteOption
import io.vertx.scala.core.Vertx
import io.vertx.core.json.JsonArray
import io.vertx.ext.mongo.IndexOptions
import io.vertx.ext.mongo.FindOptions
import io.vertx.core.json.JsonObject
import io.vertx.core.Handler
import io.vertx.ext.mongo.MongoClientUpdateResult
import io.vertx.ext.mongo.UpdateOptions

/**
  * @author <a href="http://tfox.org">Tim Fox</a>
  */
class MongoService(private val _asJava: io.vertx.ext.mongo.MongoService) {

  def asJava: io.vertx.ext.mongo.MongoService = _asJava

  def save(collection: String, document: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[java.lang.String] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.save(collection, document, funcToHandler(resultHandler))
    this
  }

  def saveWithOptions(collection: String, document: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption, resultHandler: io.vertx.core.AsyncResult[java.lang.String] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.saveWithOptions(collection, document, writeOption, funcToHandler(resultHandler))
    this
  }

  def insert(collection: String, document: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[java.lang.String] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.insert(collection, document, funcToHandler(resultHandler))
    this
  }

  def insertWithOptions(collection: String, document: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption, resultHandler: io.vertx.core.AsyncResult[java.lang.String] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.insertWithOptions(collection, document, writeOption, funcToHandler(resultHandler))
    this
  }

  def update(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.update(collection, query, update, funcToHandler(resultHandler))
    this
  }

  def updateCollection(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.updateCollection(collection, query, update, funcToHandler(resultHandler))
    this
  }

  def updateWithOptions(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, options: io.vertx.ext.mongo.UpdateOptions, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.updateWithOptions(collection, query, update, options, funcToHandler(resultHandler))
    this
  }

  def updateCollectionWithOptions(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, options: io.vertx.ext.mongo.UpdateOptions, resultHandler: io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.updateCollectionWithOptions(collection, query, update, options, funcToHandler(resultHandler))
    this
  }

  def replace(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.replace(collection, query, replace, funcToHandler(resultHandler))
    this
  }

  def replaceDocuments(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.replaceDocuments(collection, query, replace, funcToHandler(resultHandler))
    this
  }

  def replaceWithOptions(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, options: io.vertx.ext.mongo.UpdateOptions, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.replaceWithOptions(collection, query, replace, options, funcToHandler(resultHandler))
    this
  }

  def replaceDocumentsWithOptions(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, options: io.vertx.ext.mongo.UpdateOptions, resultHandler: io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.replaceDocumentsWithOptions(collection, query, replace, options, funcToHandler(resultHandler))
    this
  }

  def find(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[java.util.List[io.vertx.core.json.JsonObject]] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.find(collection, query, funcToHandler(resultHandler))
    this
  }

  def findBatch(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.findBatch(collection, query, funcToHandler(resultHandler))
    this
  }

  def findWithOptions(collection: String, query: io.vertx.core.json.JsonObject, options: io.vertx.ext.mongo.FindOptions, resultHandler: io.vertx.core.AsyncResult[java.util.List[io.vertx.core.json.JsonObject]] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.findWithOptions(collection, query, options, funcToHandler(resultHandler))
    this
  }

  def findBatchWithOptions(collection: String, query: io.vertx.core.json.JsonObject, options: io.vertx.ext.mongo.FindOptions, resultHandler: io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.findBatchWithOptions(collection, query, options, funcToHandler(resultHandler))
    this
  }

  def findOne(collection: String, query: io.vertx.core.json.JsonObject, fields: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.findOne(collection, query, fields, funcToHandler(resultHandler))
    this
  }

  def count(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[java.lang.Long] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.count(collection, query, funcToHandler(resultHandler))
    this
  }

  def remove(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.remove(collection, query, funcToHandler(resultHandler))
    this
  }

  def removeDocuments(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.removeDocuments(collection, query, funcToHandler(resultHandler))
    this
  }

  def removeWithOptions(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.removeWithOptions(collection, query, writeOption, funcToHandler(resultHandler))
    this
  }

  def removeDocumentsWithOptions(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption, resultHandler: io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.removeDocumentsWithOptions(collection, query, writeOption, funcToHandler(resultHandler))
    this
  }

  def removeOne(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.removeOne(collection, query, funcToHandler(resultHandler))
    this
  }

  def removeDocument(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.removeDocument(collection, query, funcToHandler(resultHandler))
    this
  }

  def removeOneWithOptions(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.removeOneWithOptions(collection, query, writeOption, funcToHandler(resultHandler))
    this
  }

  def removeDocumentWithOptions(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption, resultHandler: io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.removeDocumentWithOptions(collection, query, writeOption, funcToHandler(resultHandler))
    this
  }

  def createCollection(collectionName: String, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.createCollection(collectionName, funcToHandler(resultHandler))
    this
  }

  def getCollections(resultHandler: io.vertx.core.AsyncResult[java.util.List[java.lang.String]] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.getCollections(funcToHandler(resultHandler))
    this
  }

  def dropCollection(collection: String, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.dropCollection(collection, funcToHandler(resultHandler))
    this
  }

  def createIndex(collection: String, key: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.createIndex(collection, key, funcToHandler(resultHandler))
    this
  }

  def createIndexWithOptions(collection: String, key: io.vertx.core.json.JsonObject, options: io.vertx.ext.mongo.IndexOptions, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.createIndexWithOptions(collection, key, options, funcToHandler(resultHandler))
    this
  }

  def listIndexes(collection: String, resultHandler: io.vertx.core.AsyncResult[io.vertx.core.json.JsonArray] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.listIndexes(collection, funcToHandler(resultHandler))
    this
  }

  def dropIndex(collection: String, indexName: String, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.dropIndex(collection, indexName, funcToHandler(resultHandler))
    this
  }

  def runCommand(commandName: String, command: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.runCommand(commandName, command, funcToHandler(resultHandler))
    this
  }

  def distinct(collection: String, fieldName: String, resultClassname: String, resultHandler: io.vertx.core.AsyncResult[io.vertx.core.json.JsonArray] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.distinct(collection, fieldName, resultClassname, funcToHandler(resultHandler))
    this
  }

  def distinctBatch(collection: String, fieldName: String, resultClassname: String, resultHandler: io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.distinctBatch(collection, fieldName, resultClassname, funcToHandler(resultHandler))
    this
  }

  def close(): Unit = {
    _asJava.close()
  }

}

object MongoService {

  def apply(_asJava: io.vertx.ext.mongo.MongoService): io.vertx.scala.ext.mongo.MongoService =
    new io.vertx.scala.ext.mongo.MongoService(_asJava)
  def createEventBusProxy(vertx: io.vertx.scala.core.Vertx, address: String): io.vertx.scala.ext.mongo.MongoService = {
    MongoService.apply(io.vertx.ext.mongo.MongoService.createEventBusProxy(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], address))
  }
}
