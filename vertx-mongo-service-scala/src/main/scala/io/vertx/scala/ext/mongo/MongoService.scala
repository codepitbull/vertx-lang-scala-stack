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

package io.vertx.scala.ext.mongo

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
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
  */
class MongoService(private val _asJava: io.vertx.ext.mongo.MongoService) {

  def asJava: io.vertx.ext.mongo.MongoService = _asJava

  def saveWithHandler(collection: String, document: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [String] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.save(collection, document, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.String], io.vertx.core.AsyncResult [String]](x => io.vertx.lang.scala.AsyncResult[java.lang.String, String](x,(x => x)))(resultHandler))
    this
  }

  def saveWithOptionsWithHandler(collection: String, document: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption)( resultHandler: io.vertx.core.AsyncResult [String] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.saveWithOptions(collection, document, writeOption, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.String], io.vertx.core.AsyncResult [String]](x => io.vertx.lang.scala.AsyncResult[java.lang.String, String](x,(x => x)))(resultHandler))
    this
  }

  def insertWithHandler(collection: String, document: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [String] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.insert(collection, document, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.String], io.vertx.core.AsyncResult [String]](x => io.vertx.lang.scala.AsyncResult[java.lang.String, String](x,(x => x)))(resultHandler))
    this
  }

  def insertWithOptionsWithHandler(collection: String, document: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption)( resultHandler: io.vertx.core.AsyncResult [String] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.insertWithOptions(collection, document, writeOption, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.String], io.vertx.core.AsyncResult [String]](x => io.vertx.lang.scala.AsyncResult[java.lang.String, String](x,(x => x)))(resultHandler))
    this
  }

  def updateWithHandler(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.update(collection, query, update, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  def updateCollectionWithHandler(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientUpdateResult] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.updateCollection(collection, query, update, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult], io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientUpdateResult]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult, io.vertx.scala.ext.mongo.MongoClientUpdateResult](x,(x => MongoClientUpdateResult(x))))(resultHandler))
    this
  }

  def updateWithOptionsWithHandler(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, options: io.vertx.scala.ext.mongo.UpdateOptions)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.updateWithOptions(collection, query, update, options.asJava, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  def updateCollectionWithOptionsWithHandler(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, options: io.vertx.scala.ext.mongo.UpdateOptions)( resultHandler: io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientUpdateResult] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.updateCollectionWithOptions(collection, query, update, options.asJava, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult], io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientUpdateResult]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult, io.vertx.scala.ext.mongo.MongoClientUpdateResult](x,(x => MongoClientUpdateResult(x))))(resultHandler))
    this
  }

  def replaceWithHandler(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.replace(collection, query, replace, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  def replaceDocumentsWithHandler(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientUpdateResult] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.replaceDocuments(collection, query, replace, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult], io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientUpdateResult]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult, io.vertx.scala.ext.mongo.MongoClientUpdateResult](x,(x => MongoClientUpdateResult(x))))(resultHandler))
    this
  }

  def replaceWithOptionsWithHandler(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, options: io.vertx.scala.ext.mongo.UpdateOptions)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.replaceWithOptions(collection, query, replace, options.asJava, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  def replaceDocumentsWithOptionsWithHandler(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, options: io.vertx.scala.ext.mongo.UpdateOptions)( resultHandler: io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientUpdateResult] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.replaceDocumentsWithOptions(collection, query, replace, options.asJava, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult], io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientUpdateResult]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult, io.vertx.scala.ext.mongo.MongoClientUpdateResult](x,(x => MongoClientUpdateResult(x))))(resultHandler))
    this
  }

  def findWithHandler(collection: String, query: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.find(collection, query, funcToMappedHandler[io.vertx.core.AsyncResult[java.util.List[io.vertx.core.json.JsonObject]], io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]](x => io.vertx.lang.scala.AsyncResult[java.util.List[io.vertx.core.json.JsonObject], scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]](x,x => if (x == null) null else x.asScala))(resultHandler))
    this
  }

  def findBatchWithHandler(collection: String, query: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [io.vertx.core.json.JsonObject] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.findBatch(collection, query, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject], io.vertx.core.AsyncResult [io.vertx.core.json.JsonObject]](x => io.vertx.lang.scala.AsyncResult[io.vertx.core.json.JsonObject, io.vertx.core.json.JsonObject](x,(x => x)))(resultHandler))
    this
  }

  def findWithOptionsWithHandler(collection: String, query: io.vertx.core.json.JsonObject, options: io.vertx.scala.ext.mongo.FindOptions)( resultHandler: io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.findWithOptions(collection, query, options.asJava, funcToMappedHandler[io.vertx.core.AsyncResult[java.util.List[io.vertx.core.json.JsonObject]], io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]](x => io.vertx.lang.scala.AsyncResult[java.util.List[io.vertx.core.json.JsonObject], scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]](x,x => if (x == null) null else x.asScala))(resultHandler))
    this
  }

  def findBatchWithOptionsWithHandler(collection: String, query: io.vertx.core.json.JsonObject, options: io.vertx.scala.ext.mongo.FindOptions)( resultHandler: io.vertx.core.AsyncResult [io.vertx.core.json.JsonObject] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.findBatchWithOptions(collection, query, options.asJava, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject], io.vertx.core.AsyncResult [io.vertx.core.json.JsonObject]](x => io.vertx.lang.scala.AsyncResult[io.vertx.core.json.JsonObject, io.vertx.core.json.JsonObject](x,(x => x)))(resultHandler))
    this
  }

  def findOneWithHandler(collection: String, query: io.vertx.core.json.JsonObject, fields: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [io.vertx.core.json.JsonObject] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.findOne(collection, query, fields, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject], io.vertx.core.AsyncResult [io.vertx.core.json.JsonObject]](x => io.vertx.lang.scala.AsyncResult[io.vertx.core.json.JsonObject, io.vertx.core.json.JsonObject](x,(x => x)))(resultHandler))
    this
  }

  def countWithHandler(collection: String, query: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [Long] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.count(collection, query, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Long], io.vertx.core.AsyncResult [Long]](x => io.vertx.lang.scala.AsyncResult[java.lang.Long, Long](x,(x => x)))(resultHandler))
    this
  }

  def removeWithHandler(collection: String, query: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.remove(collection, query, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  def removeDocumentsWithHandler(collection: String, query: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientDeleteResult] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.removeDocuments(collection, query, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult], io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientDeleteResult]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult, io.vertx.scala.ext.mongo.MongoClientDeleteResult](x,(x => MongoClientDeleteResult(x))))(resultHandler))
    this
  }

  def removeWithOptionsWithHandler(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.removeWithOptions(collection, query, writeOption, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  def removeDocumentsWithOptionsWithHandler(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption)( resultHandler: io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientDeleteResult] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.removeDocumentsWithOptions(collection, query, writeOption, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult], io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientDeleteResult]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult, io.vertx.scala.ext.mongo.MongoClientDeleteResult](x,(x => MongoClientDeleteResult(x))))(resultHandler))
    this
  }

  def removeOneWithHandler(collection: String, query: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.removeOne(collection, query, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  def removeDocumentWithHandler(collection: String, query: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientDeleteResult] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.removeDocument(collection, query, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult], io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientDeleteResult]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult, io.vertx.scala.ext.mongo.MongoClientDeleteResult](x,(x => MongoClientDeleteResult(x))))(resultHandler))
    this
  }

  def removeOneWithOptionsWithHandler(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.removeOneWithOptions(collection, query, writeOption, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  def removeDocumentWithOptionsWithHandler(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption)( resultHandler: io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientDeleteResult] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.removeDocumentWithOptions(collection, query, writeOption, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult], io.vertx.core.AsyncResult [io.vertx.scala.ext.mongo.MongoClientDeleteResult]](x => io.vertx.lang.scala.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult, io.vertx.scala.ext.mongo.MongoClientDeleteResult](x,(x => MongoClientDeleteResult(x))))(resultHandler))
    this
  }

  def createCollectionWithHandler(collectionName: String)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.createCollection(collectionName, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  def getCollections(resultHandler: io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[String]] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.getCollections(funcToMappedHandler[io.vertx.core.AsyncResult[java.util.List[java.lang.String]], io.vertx.core.AsyncResult [scala.collection.mutable.Buffer[String]]](x => io.vertx.lang.scala.AsyncResult[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x,x => if (x == null) null else x.asScala))(resultHandler))
    this
  }

  def dropCollectionWithHandler(collection: String)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.dropCollection(collection, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  def createIndexWithHandler(collection: String, key: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.createIndex(collection, key, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  def createIndexWithOptionsWithHandler(collection: String, key: io.vertx.core.json.JsonObject, options: io.vertx.scala.ext.mongo.IndexOptions)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.createIndexWithOptions(collection, key, options.asJava, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  def listIndexesWithHandler(collection: String)( resultHandler: io.vertx.core.AsyncResult [io.vertx.core.json.JsonArray] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.listIndexes(collection, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonArray], io.vertx.core.AsyncResult [io.vertx.core.json.JsonArray]](x => io.vertx.lang.scala.AsyncResult[io.vertx.core.json.JsonArray, io.vertx.core.json.JsonArray](x,(x => x)))(resultHandler))
    this
  }

  def dropIndexWithHandler(collection: String, indexName: String)( resultHandler: io.vertx.core.AsyncResult [Unit] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.dropIndex(collection, indexName, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(resultHandler))
    this
  }

  def runCommandWithHandler(commandName: String, command: io.vertx.core.json.JsonObject)( resultHandler: io.vertx.core.AsyncResult [io.vertx.core.json.JsonObject] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.runCommand(commandName, command, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject], io.vertx.core.AsyncResult [io.vertx.core.json.JsonObject]](x => io.vertx.lang.scala.AsyncResult[io.vertx.core.json.JsonObject, io.vertx.core.json.JsonObject](x,(x => x)))(resultHandler))
    this
  }

  def distinctWithHandler(collection: String, fieldName: String, resultClassname: String)( resultHandler: io.vertx.core.AsyncResult [io.vertx.core.json.JsonArray] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.distinct(collection, fieldName, resultClassname, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonArray], io.vertx.core.AsyncResult [io.vertx.core.json.JsonArray]](x => io.vertx.lang.scala.AsyncResult[io.vertx.core.json.JsonArray, io.vertx.core.json.JsonArray](x,(x => x)))(resultHandler))
    this
  }

  def distinctBatchWithHandler(collection: String, fieldName: String, resultClassname: String)( resultHandler: io.vertx.core.AsyncResult [io.vertx.core.json.JsonObject] => Unit): io.vertx.scala.ext.mongo.MongoService = {
    _asJava.distinctBatch(collection, fieldName, resultClassname, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject], io.vertx.core.AsyncResult [io.vertx.core.json.JsonObject]](x => io.vertx.lang.scala.AsyncResult[io.vertx.core.json.JsonObject, io.vertx.core.json.JsonObject](x,(x => x)))(resultHandler))
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
