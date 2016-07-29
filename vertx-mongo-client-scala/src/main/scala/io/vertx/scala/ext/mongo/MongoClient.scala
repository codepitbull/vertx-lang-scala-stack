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
  * A Vert.x service used to interact with MongoDB server instances.
  * 
  * Some of the operations might change <i>_id</i> field of passed  document.
  */
class MongoClient(private val _asJava: io.vertx.ext.mongo.MongoClient) {

  def asJava: io.vertx.ext.mongo.MongoClient = _asJava

  /**
    * Save a document in the specified collection
    * 
    * This operation might change <i>_id</i> field of <i>document</i> parameter
    * @param collection the collection
    * @param document the document
    * @param resultHandler result handler will be provided with the id if document didn't already have one
    */
  def save(collection: String, document: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[java.lang.String] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.save(collection, document, funcToHandler(resultHandler))
    this
  }

  /**
    * Save a document in the specified collection with the specified write option
    * 
    * This operation might change <i>_id</i> field of <i>document</i> parameter
    * @param collection the collection
    * @param document the document
    * @param writeOption the write option to use
    * @param resultHandler result handler will be provided with the id if document didn't already have one
    */
  def saveWithOptions(collection: String, document: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption, resultHandler: io.vertx.core.AsyncResult[java.lang.String] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.saveWithOptions(collection, document, writeOption, funcToHandler(resultHandler))
    this
  }

  /**
    * Insert a document in the specified collection
    * 
    * This operation might change <i>_id</i> field of <i>document</i> parameter
    * @param collection the collection
    * @param document the document
    * @param resultHandler result handler will be provided with the id if document didn't already have one
    */
  def insert(collection: String, document: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[java.lang.String] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.insert(collection, document, funcToHandler(resultHandler))
    this
  }

  /**
    * Insert a document in the specified collection with the specified write option
    * 
    * This operation might change <i>_id</i> field of <i>document</i> parameter
    * @param collection the collection
    * @param document the document
    * @param writeOption the write option to use
    * @param resultHandler result handler will be provided with the id if document didn't already have one
    */
  def insertWithOptions(collection: String, document: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption, resultHandler: io.vertx.core.AsyncResult[java.lang.String] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.insertWithOptions(collection, document, writeOption, funcToHandler(resultHandler))
    this
  }

  /**
    * Update matching documents in the specified collection
    * @param collection the collection
    * @param query query used to match the documents
    * @param update used to describe how the documents will be updated
    * @param resultHandler will be called when complete
    */
  def update(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.update(collection, query, update, funcToHandler(resultHandler))
    this
  }

  /**
    * Update matching documents in the specified collection and return the handler with MongoClientUpdateResult result
    * @param collection the collection
    * @param query query used to match the documents
    * @param update used to describe how the documents will be updated
    * @param resultHandler will be called when complete
    */
  def updateCollection(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.updateCollection(collection, query, update, funcToHandler(resultHandler))
    this
  }

  /**
    * Update matching documents in the specified collection, specifying options
    * @param collection the collection
    * @param query query used to match the documents
    * @param update used to describe how the documents will be updated
    * @param options options to configure the updatesee <a href="../../../../../../../cheatsheet/UpdateOptions.html">UpdateOptions</a>
    * @param resultHandler will be called when complete
    */
  def updateWithOptions(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, options: io.vertx.ext.mongo.UpdateOptions, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.updateWithOptions(collection, query, update, options, funcToHandler(resultHandler))
    this
  }

  /**
    * Update matching documents in the specified collection, specifying options and return the handler with MongoClientUpdateResult result
    * @param collection the collection
    * @param query query used to match the documents
    * @param update used to describe how the documents will be updated
    * @param options options to configure the updatesee <a href="../../../../../../../cheatsheet/UpdateOptions.html">UpdateOptions</a>
    * @param resultHandler will be called when complete
    */
  def updateCollectionWithOptions(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, options: io.vertx.ext.mongo.UpdateOptions, resultHandler: io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.updateCollectionWithOptions(collection, query, update, options, funcToHandler(resultHandler))
    this
  }

  /**
    * Replace matching documents in the specified collection
    * 
    * This operation might change <i>_id</i> field of <i>replace</i> parameter
    * @param collection the collection
    * @param query query used to match the documents
    * @param replace all matching documents will be replaced with this
    * @param resultHandler will be called when complete
    */
  def replace(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.replace(collection, query, replace, funcToHandler(resultHandler))
    this
  }

  /**
    * Replace matching documents in the specified collection and return the handler with MongoClientUpdateResult result
    * @param collection the collection
    * @param query query used to match the documents
    * @param replace all matching documents will be replaced with this
    * @param resultHandler will be called when complete
    */
  def replaceDocuments(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.replaceDocuments(collection, query, replace, funcToHandler(resultHandler))
    this
  }

  /**
    * Replace matching documents in the specified collection, specifying options
    * 
    * This operation might change <i>_id</i> field of <i>replace</i> parameter
    * @param collection the collection
    * @param query query used to match the documents
    * @param replace all matching documents will be replaced with this
    * @param options options to configure the replacesee <a href="../../../../../../../cheatsheet/UpdateOptions.html">UpdateOptions</a>
    * @param resultHandler will be called when complete
    */
  def replaceWithOptions(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, options: io.vertx.ext.mongo.UpdateOptions, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.replaceWithOptions(collection, query, replace, options, funcToHandler(resultHandler))
    this
  }

  /**
    * Replace matching documents in the specified collection, specifying options and return the handler with MongoClientUpdateResult result
    * @param collection the collection
    * @param query query used to match the documents
    * @param replace all matching documents will be replaced with this
    * @param options options to configure the replacesee <a href="../../../../../../../cheatsheet/UpdateOptions.html">UpdateOptions</a>
    * @param resultHandler will be called when complete
    */
  def replaceDocumentsWithOptions(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, options: io.vertx.ext.mongo.UpdateOptions, resultHandler: io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.replaceDocumentsWithOptions(collection, query, replace, options, funcToHandler(resultHandler))
    this
  }

  /**
    * Find matching documents in the specified collection
    * @param collection the collection
    * @param query query used to match documents
    * @param resultHandler will be provided with list of documents
    */
  def find(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[java.util.List[io.vertx.core.json.JsonObject]] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.find(collection, query, funcToHandler(resultHandler))
    this
  }

  /**
    * Find matching documents in the specified collection.
    * This method use batchCursor for returning each found document.
    * @param collection the collection
    * @param query query used to match documents
    * @param resultHandler will be provided with each found document
    */
  def findBatch(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.findBatch(collection, query, funcToHandler(resultHandler))
    this
  }

  /**
    * Find matching documents in the specified collection, specifying options
    * @param collection the collection
    * @param query query used to match documents
    * @param options options to configure the findsee <a href="../../../../../../../cheatsheet/FindOptions.html">FindOptions</a>
    * @param resultHandler will be provided with list of documents
    */
  def findWithOptions(collection: String, query: io.vertx.core.json.JsonObject, options: io.vertx.ext.mongo.FindOptions, resultHandler: io.vertx.core.AsyncResult[java.util.List[io.vertx.core.json.JsonObject]] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.findWithOptions(collection, query, options, funcToHandler(resultHandler))
    this
  }

  /**
    * Find matching documents in the specified collection, specifying options.
    * This method use batchCursor for returning each found document.
    * @param collection the collection
    * @param query query used to match documents
    * @param options options to configure the findsee <a href="../../../../../../../cheatsheet/FindOptions.html">FindOptions</a>
    * @param resultHandler will be provided with each found document
    */
  def findBatchWithOptions(collection: String, query: io.vertx.core.json.JsonObject, options: io.vertx.ext.mongo.FindOptions, resultHandler: io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.findBatchWithOptions(collection, query, options, funcToHandler(resultHandler))
    this
  }

  /**
    * Find a single matching document in the specified collection
    * 
    * This operation might change <i>_id</i> field of <i>query</i> parameter
    * @param collection the collection
    * @param query the query used to match the document
    * @param fields the fields
    * @param resultHandler will be provided with the document, if any
    */
  def findOne(collection: String, query: io.vertx.core.json.JsonObject, fields: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.findOne(collection, query, fields, funcToHandler(resultHandler))
    this
  }

  /**
    * Count matching documents in a collection.
    * @param collection the collection
    * @param query query used to match documents
    * @param resultHandler will be provided with the number of matching documents
    */
  def count(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[java.lang.Long] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.count(collection, query, funcToHandler(resultHandler))
    this
  }

  /**
    * Remove matching documents from a collection
    * @param collection the collection
    * @param query query used to match documents
    * @param resultHandler will be called when complete
    */
  def remove(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.remove(collection, query, funcToHandler(resultHandler))
    this
  }

  /**
    * Remove matching documents from a collection and return the handler with MongoClientDeleteResult result
    * @param collection the collection
    * @param query query used to match documents
    * @param resultHandler will be called when complete
    */
  def removeDocuments(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.removeDocuments(collection, query, funcToHandler(resultHandler))
    this
  }

  /**
    * Remove matching documents from a collection with the specified write option
    * @param collection the collection
    * @param query query used to match documents
    * @param writeOption the write option to use
    * @param resultHandler will be called when complete
    */
  def removeWithOptions(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.removeWithOptions(collection, query, writeOption, funcToHandler(resultHandler))
    this
  }

  /**
    * Remove matching documents from a collection with the specified write option and return the handler with MongoClientDeleteResult result
    * @param collection the collection
    * @param query query used to match documents
    * @param writeOption the write option to use
    * @param resultHandler will be called when complete
    */
  def removeDocumentsWithOptions(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption, resultHandler: io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.removeDocumentsWithOptions(collection, query, writeOption, funcToHandler(resultHandler))
    this
  }

  /**
    * Remove a single matching document from a collection
    * @param collection the collection
    * @param query query used to match document
    * @param resultHandler will be called when complete
    */
  def removeOne(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.removeOne(collection, query, funcToHandler(resultHandler))
    this
  }

  /**
    * Remove a single matching document from a collection and return the handler with MongoClientDeleteResult result
    * @param collection the collection
    * @param query query used to match document
    * @param resultHandler will be called when complete
    */
  def removeDocument(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.removeDocument(collection, query, funcToHandler(resultHandler))
    this
  }

  /**
    * Remove a single matching document from a collection with the specified write option
    * @param collection the collection
    * @param query query used to match document
    * @param writeOption the write option to use
    * @param resultHandler will be called when complete
    */
  def removeOneWithOptions(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.removeOneWithOptions(collection, query, writeOption, funcToHandler(resultHandler))
    this
  }

  /**
    * Remove a single matching document from a collection with the specified write option and return the handler with MongoClientDeleteResult result
    * @param collection the collection
    * @param query query used to match document
    * @param writeOption the write option to use
    * @param resultHandler will be called when complete
    */
  def removeDocumentWithOptions(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption, resultHandler: io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.removeDocumentWithOptions(collection, query, writeOption, funcToHandler(resultHandler))
    this
  }

  /**
    * Create a new collection
    * @param collectionName the name of the collection
    * @param resultHandler will be called when complete
    */
  def createCollection(collectionName: String, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.createCollection(collectionName, funcToHandler(resultHandler))
    this
  }

  /**
    * Get a list of all collections in the database.
    * @param resultHandler will be called with a list of collections.
    */
  def getCollections(resultHandler: io.vertx.core.AsyncResult[java.util.List[java.lang.String]] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.getCollections(funcToHandler(resultHandler))
    this
  }

  /**
    * Drop a collection
    * @param collection the collection
    * @param resultHandler will be called when complete
    */
  def dropCollection(collection: String, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.dropCollection(collection, funcToHandler(resultHandler))
    this
  }

  /**
    * Creates an index.
    * @param collection the collection
    * @param key A document that contains the field and value pairs where the field is the index key and the value describes the type of index for that field. For an ascending index on a field, specify a value of 1; for descending index, specify a value of -1.
    * @param resultHandler will be called when complete
    */
  def createIndex(collection: String, key: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.createIndex(collection, key, funcToHandler(resultHandler))
    this
  }

  /**
    * Creates an index.
    * @param collection the collection
    * @param key A document that contains the field and value pairs where the field is the index key and the value describes the type of index for that field. For an ascending index on a field, specify a value of 1; for descending index, specify a value of -1.
    * @param options the options for the indexsee <a href="../../../../../../../cheatsheet/IndexOptions.html">IndexOptions</a>
    * @param resultHandler will be called when complete
    */
  def createIndexWithOptions(collection: String, key: io.vertx.core.json.JsonObject, options: io.vertx.ext.mongo.IndexOptions, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.createIndexWithOptions(collection, key, options, funcToHandler(resultHandler))
    this
  }

  /**
    * Get all the indexes in this collection.
    * @param collection the collection
    * @param resultHandler will be called when complete
    */
  def listIndexes(collection: String, resultHandler: io.vertx.core.AsyncResult[io.vertx.core.json.JsonArray] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.listIndexes(collection, funcToHandler(resultHandler))
    this
  }

  /**
    * Drops the index given its name.
    * @param collection the collection
    * @param indexName the name of the index to remove
    * @param resultHandler will be called when complete
    */
  def dropIndex(collection: String, indexName: String, resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.dropIndex(collection, indexName, funcToHandler(resultHandler))
    this
  }

  /**
    * Run an arbitrary MongoDB command.
    * @param commandName the name of the command
    * @param command the command
    * @param resultHandler will be called with the result.
    */
  def runCommand(commandName: String, command: io.vertx.core.json.JsonObject, resultHandler: io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.runCommand(commandName, command, funcToHandler(resultHandler))
    this
  }

  /**
    * Gets the distinct values of the specified field name.
    * Return a JsonArray containing distinct values (eg: [ 1 , 89 ])
    * @param collection the collection
    * @param fieldName the field name
    * @param resultHandler will be provided with array of values.
    */
  def distinct(collection: String, fieldName: String, resultClassname: String, resultHandler: io.vertx.core.AsyncResult[io.vertx.core.json.JsonArray] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.distinct(collection, fieldName, resultClassname, funcToHandler(resultHandler))
    this
  }

  /**
    * Gets the distinct values of the specified field name.
    * This method use batchCursor for returning each found value.
    * Each value is a json fragment with fieldName key (eg: {"num": 1`).
    * @param collection the collection
    * @param fieldName the field name
    * @param resultHandler will be provided with each found value
    */
  def distinctBatch(collection: String, fieldName: String, resultClassname: String, resultHandler: io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject] => Unit): io.vertx.scala.ext.mongo.MongoClient = {
    _asJava.distinctBatch(collection, fieldName, resultClassname, funcToHandler(resultHandler))
    this
  }

  /**
    * Close the client and release its resources
    */
  def close(): Unit = {
    _asJava.close()
  }

}

object MongoClient {

  def apply(_asJava: io.vertx.ext.mongo.MongoClient): io.vertx.scala.ext.mongo.MongoClient =
    new io.vertx.scala.ext.mongo.MongoClient(_asJava)
  def createNonShared(vertx: io.vertx.scala.core.Vertx, config: io.vertx.core.json.JsonObject): io.vertx.scala.ext.mongo.MongoClient = {
    MongoClient.apply(io.vertx.ext.mongo.MongoClient.createNonShared(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], config))
  }
  def createShared(vertx: io.vertx.scala.core.Vertx, config: io.vertx.core.json.JsonObject, dataSourceName: String): io.vertx.scala.ext.mongo.MongoClient = {
    MongoClient.apply(io.vertx.ext.mongo.MongoClient.createShared(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], config, dataSourceName))
  }
  def createShared(vertx: io.vertx.scala.core.Vertx, config: io.vertx.core.json.JsonObject): io.vertx.scala.ext.mongo.MongoClient = {
    MongoClient.apply(io.vertx.ext.mongo.MongoClient.createShared(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], config))
  }
}
