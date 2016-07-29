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

package io.vertx.scala.ext.web;

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import scala.util.Try
import io.vertx.scala.core.http.HttpServerRequest
import io.vertx.core.http.HttpMethod
import io.vertx.scala.core.Vertx
import io.vertx.core.Handler

/**
  * A router receives request from an [[io.vertx.scala.core.http.HttpServer]] and routes it to the first matching
  * [[io.vertx.scala.ext.web.Route]] that it contains. A router can contain many routes.
  * 
  * Routers are also used for routing failures.
  */
class Router(private val _asJava: io.vertx.ext.web.Router) {

  def asJava: io.vertx.ext.web.Router = _asJava

  /**
    * This method is used to provide a request to the router. Usually you take request from the
    * [[io.vertx.scala.core.http.HttpServer#requestHandler]] and pass it to this method. The
    * router then routes it to matching routes.
    * @param request the request
    */
  def accept(request: io.vertx.scala.core.http.HttpServerRequest): Unit = {
    _asJava.accept(request.asJava.asInstanceOf[io.vertx.core.http.HttpServerRequest])
  }

  /**
    * Add a route with no matching criteria, i.e. it matches all requests or failures.
    * @return the route
    */
  def route(): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.route())
  }

  /**
    * Add a route that matches the specified HTTP method and path
    * @param method the HTTP method to match
    * @param path URI paths that begin with this path will match
    * @return the route
    */
  def route(method: io.vertx.core.http.HttpMethod, path: String): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.route(method, path))
  }

  /**
    * Add a route that matches the specified path
    * @param path URI paths that begin with this path will match
    * @return the route
    */
  def route(path: String): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.route(path))
  }

  /**
    * Add a route that matches the specified HTTP method and path regex
    * @param method the HTTP method to match
    * @param regex URI paths that begin with a match for this regex will match
    * @return the route
    */
  def routeWithRegex(method: io.vertx.core.http.HttpMethod, regex: String): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.routeWithRegex(method, regex))
  }

  /**
    * Add a route that matches the specified path regex
    * @param regex URI paths that begin with a match for this regex will match
    * @return the route
    */
  def routeWithRegex(regex: String): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.routeWithRegex(regex))
  }

  /**
    * Add a route that matches any HTTP GET request
    * @return the route
    */
  def get(): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.get())
  }

  /**
    * Add a route that matches a HTTP GET request and the specified path
    * @param path URI paths that begin with this path will match
    * @return the route
    */
  def get(path: String): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.get(path))
  }

  /**
    * Add a route that matches a HTTP GET request and the specified path regex
    * @param regex URI paths that begin with a match for this regex will match
    * @return the route
    */
  def getWithRegex(regex: String): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.getWithRegex(regex))
  }

  /**
    * Add a route that matches any HTTP HEAD request
    * @return the route
    */
  def head(): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.head())
  }

  /**
    * Add a route that matches a HTTP HEAD request and the specified path
    * @param path URI paths that begin with this path will match
    * @return the route
    */
  def head(path: String): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.head(path))
  }

  /**
    * Add a route that matches a HTTP HEAD request and the specified path regex
    * @param regex URI paths that begin with a match for this regex will match
    * @return the route
    */
  def headWithRegex(regex: String): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.headWithRegex(regex))
  }

  /**
    * Add a route that matches any HTTP OPTIONS request
    * @return the route
    */
  def options(): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.options())
  }

  /**
    * Add a route that matches a HTTP OPTIONS request and the specified path
    * @param path URI paths that begin with this path will match
    * @return the route
    */
  def options(path: String): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.options(path))
  }

  /**
    * Add a route that matches a HTTP OPTIONS request and the specified path regex
    * @param regex URI paths that begin with a match for this regex will match
    * @return the route
    */
  def optionsWithRegex(regex: String): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.optionsWithRegex(regex))
  }

  /**
    * Add a route that matches any HTTP PUT request
    * @return the route
    */
  def put(): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.put())
  }

  /**
    * Add a route that matches a HTTP PUT request and the specified path
    * @param path URI paths that begin with this path will match
    * @return the route
    */
  def put(path: String): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.put(path))
  }

  /**
    * Add a route that matches a HTTP PUT request and the specified path regex
    * @param regex URI paths that begin with a match for this regex will match
    * @return the route
    */
  def putWithRegex(regex: String): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.putWithRegex(regex))
  }

  /**
    * Add a route that matches any HTTP POST request
    * @return the route
    */
  def post(): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.post())
  }

  /**
    * Add a route that matches a HTTP POST request and the specified path
    * @param path URI paths that begin with this path will match
    * @return the route
    */
  def post(path: String): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.post(path))
  }

  /**
    * Add a route that matches a HTTP POST request and the specified path regex
    * @param regex URI paths that begin with a match for this regex will match
    * @return the route
    */
  def postWithRegex(regex: String): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.postWithRegex(regex))
  }

  /**
    * Add a route that matches any HTTP DELETE request
    * @return the route
    */
  def delete(): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.delete())
  }

  /**
    * Add a route that matches a HTTP DELETE request and the specified path
    * @param path URI paths that begin with this path will match
    * @return the route
    */
  def delete(path: String): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.delete(path))
  }

  /**
    * Add a route that matches a HTTP DELETE request and the specified path regex
    * @param regex URI paths that begin with a match for this regex will match
    * @return the route
    */
  def deleteWithRegex(regex: String): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.deleteWithRegex(regex))
  }

  /**
    * Add a route that matches any HTTP TRACE request
    * @return the route
    */
  def trace(): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.trace())
  }

  /**
    * Add a route that matches a HTTP TRACE request and the specified path
    * @param path URI paths that begin with this path will match
    * @return the route
    */
  def trace(path: String): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.trace(path))
  }

  /**
    * Add a route that matches a HTTP TRACE request and the specified path regex
    * @param regex URI paths that begin with a match for this regex will match
    * @return the route
    */
  def traceWithRegex(regex: String): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.traceWithRegex(regex))
  }

  /**
    * Add a route that matches any HTTP CONNECT request
    * @return the route
    */
  def connect(): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.connect())
  }

  /**
    * Add a route that matches a HTTP CONNECT request and the specified path
    * @param path URI paths that begin with this path will match
    * @return the route
    */
  def connect(path: String): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.connect(path))
  }

  /**
    * Add a route that matches a HTTP CONNECT request and the specified path regex
    * @param regex URI paths that begin with a match for this regex will match
    * @return the route
    */
  def connectWithRegex(regex: String): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.connectWithRegex(regex))
  }

  /**
    * Add a route that matches any HTTP PATCH request
    * @return the route
    */
  def patch(): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.patch())
  }

  /**
    * Add a route that matches a HTTP PATCH request and the specified path
    * @param path URI paths that begin with this path will match
    * @return the route
    */
  def patch(path: String): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.patch(path))
  }

  /**
    * Add a route that matches a HTTP PATCH request and the specified path regex
    * @param regex URI paths that begin with a match for this regex will match
    * @return the route
    */
  def patchWithRegex(regex: String): io.vertx.scala.ext.web.Route = {
    Route.apply(_asJava.patchWithRegex(regex))
  }

  /**
    * @return a list of all the routes on this router
    */
  def getRoutes(): List[io.vertx.scala.ext.web.Route] = {
    _asJava.getRoutes().asScala.map(Route.apply).toList
  }

  /**
    * Remove all the routes from this router
    * @return a reference to this, so the API can be used fluently
    */
  def clear(): io.vertx.scala.ext.web.Router = {
    _asJava.clear()
    this
  }

  /**
    * Mount a sub router on this router
    * @param mountPoint the mount point (path prefix) to mount it on
    * @param subRouter the router to mount as a sub router
    * @return a reference to this, so the API can be used fluently
    */
  def mountSubRouter(mountPoint: String, subRouter: io.vertx.scala.ext.web.Router): io.vertx.scala.ext.web.Router = {
    _asJava.mountSubRouter(mountPoint, subRouter.asJava.asInstanceOf[io.vertx.ext.web.Router])
    this
  }

  /**
    * Specify a handler for any unhandled exceptions on this router. The handler will be called for exceptions thrown
    * from handlers. This does not affect the normal failure routing logic.
    * @param exceptionHandler the exception handler
    * @return a reference to this, so the API can be used fluently
    */
  def exceptionHandler(exceptionHandler: Throwable => Unit): io.vertx.scala.ext.web.Router = {
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(exceptionHandler))
    this
  }

  /**
    * Used to route a context to the router. Used for sub-routers. You wouldn't normally call this method directly.
    * @param context the routing context
    */
  def handleContext(context: io.vertx.scala.ext.web.RoutingContext): Unit = {
    _asJava.handleContext(context.asJava.asInstanceOf[io.vertx.ext.web.RoutingContext])
  }

  /**
    * Used to route a failure to the router. Used for sub-routers. You wouldn't normally call this method directly.
    * @param context the routing context
    */
  def handleFailure(context: io.vertx.scala.ext.web.RoutingContext): Unit = {
    _asJava.handleFailure(context.asJava.asInstanceOf[io.vertx.ext.web.RoutingContext])
  }

}

object Router {

  def apply(_asJava: io.vertx.ext.web.Router): io.vertx.scala.ext.web.Router =
    new io.vertx.scala.ext.web.Router(_asJava)
  def router(vertx: io.vertx.scala.core.Vertx): io.vertx.scala.ext.web.Router = {
    Router.apply(io.vertx.ext.web.Router.router(vertx.asJava.asInstanceOf[io.vertx.core.Vertx]))
  }
}
