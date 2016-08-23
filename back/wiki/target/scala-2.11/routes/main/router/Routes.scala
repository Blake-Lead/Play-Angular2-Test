
// @GENERATOR:play-routes-compiler
// @SOURCE:/data/Sandbox/afpa/back/wiki/conf/routes
// @DATE:Mon Aug 15 00:10:59 CEST 2016

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:3
  ApplicationController_2: controllers.ApplicationController,
  // @LINE:5
  ArticleController_1: controllers.ArticleController,
  // @LINE:12
  CategoryController_0: controllers.CategoryController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:3
    ApplicationController_2: controllers.ApplicationController,
    // @LINE:5
    ArticleController_1: controllers.ArticleController,
    // @LINE:12
    CategoryController_0: controllers.CategoryController
  ) = this(errorHandler, ApplicationController_2, ArticleController_1, CategoryController_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, ApplicationController_2, ArticleController_1, CategoryController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.ApplicationController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """articles""", """controllers.ArticleController.findAll"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """articles/""" + "$" + """id<[^/]+>""", """controllers.ArticleController.find(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """articles/bycategory/""" + "$" + """id<[^/]+>""", """controllers.ArticleController.findByCategory(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """articles""", """controllers.ArticleController.create"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """articles""", """controllers.ArticleController.update"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """articles/""" + "$" + """id<[^/]+>""", """controllers.ArticleController.delete(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """categories""", """controllers.CategoryController.findAll"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """categories/""" + "$" + """id<[^/]+>""", """controllers.CategoryController.find(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """categories""", """controllers.CategoryController.create"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """categories""", """controllers.CategoryController.update"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """categories/""" + "$" + """id<[^/]+>""", """controllers.CategoryController.delete(id:Long)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:3
  private[this] lazy val controllers_ApplicationController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_ApplicationController_index0_invoker = createInvoker(
    ApplicationController_2.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "index",
      Nil,
      "GET",
      """""",
      this.prefix + """"""
    )
  )

  // @LINE:5
  private[this] lazy val controllers_ArticleController_findAll1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("articles")))
  )
  private[this] lazy val controllers_ArticleController_findAll1_invoker = createInvoker(
    ArticleController_1.findAll,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ArticleController",
      "findAll",
      Nil,
      "GET",
      """""",
      this.prefix + """articles"""
    )
  )

  // @LINE:6
  private[this] lazy val controllers_ArticleController_find2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("articles/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ArticleController_find2_invoker = createInvoker(
    ArticleController_1.find(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ArticleController",
      "find",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """articles/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_ArticleController_findByCategory3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("articles/bycategory/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ArticleController_findByCategory3_invoker = createInvoker(
    ArticleController_1.findByCategory(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ArticleController",
      "findByCategory",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """articles/bycategory/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_ArticleController_create4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("articles")))
  )
  private[this] lazy val controllers_ArticleController_create4_invoker = createInvoker(
    ArticleController_1.create,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ArticleController",
      "create",
      Nil,
      "POST",
      """""",
      this.prefix + """articles"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_ArticleController_update5_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("articles")))
  )
  private[this] lazy val controllers_ArticleController_update5_invoker = createInvoker(
    ArticleController_1.update,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ArticleController",
      "update",
      Nil,
      "PUT",
      """""",
      this.prefix + """articles"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_ArticleController_delete6_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("articles/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ArticleController_delete6_invoker = createInvoker(
    ArticleController_1.delete(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ArticleController",
      "delete",
      Seq(classOf[Long]),
      "DELETE",
      """""",
      this.prefix + """articles/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_CategoryController_findAll7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories")))
  )
  private[this] lazy val controllers_CategoryController_findAll7_invoker = createInvoker(
    CategoryController_0.findAll,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "findAll",
      Nil,
      "GET",
      """""",
      this.prefix + """categories"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_CategoryController_find8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CategoryController_find8_invoker = createInvoker(
    CategoryController_0.find(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "find",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """categories/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_CategoryController_create9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories")))
  )
  private[this] lazy val controllers_CategoryController_create9_invoker = createInvoker(
    CategoryController_0.create,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "create",
      Nil,
      "POST",
      """""",
      this.prefix + """categories"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_CategoryController_update10_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories")))
  )
  private[this] lazy val controllers_CategoryController_update10_invoker = createInvoker(
    CategoryController_0.update,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "update",
      Nil,
      "PUT",
      """""",
      this.prefix + """categories"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_CategoryController_delete11_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CategoryController_delete11_invoker = createInvoker(
    CategoryController_0.delete(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "delete",
      Seq(classOf[Long]),
      "DELETE",
      """""",
      this.prefix + """categories/""" + "$" + """id<[^/]+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:3
    case controllers_ApplicationController_index0_route(params) =>
      call { 
        controllers_ApplicationController_index0_invoker.call(ApplicationController_2.index)
      }
  
    // @LINE:5
    case controllers_ArticleController_findAll1_route(params) =>
      call { 
        controllers_ArticleController_findAll1_invoker.call(ArticleController_1.findAll)
      }
  
    // @LINE:6
    case controllers_ArticleController_find2_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ArticleController_find2_invoker.call(ArticleController_1.find(id))
      }
  
    // @LINE:7
    case controllers_ArticleController_findByCategory3_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ArticleController_findByCategory3_invoker.call(ArticleController_1.findByCategory(id))
      }
  
    // @LINE:8
    case controllers_ArticleController_create4_route(params) =>
      call { 
        controllers_ArticleController_create4_invoker.call(ArticleController_1.create)
      }
  
    // @LINE:9
    case controllers_ArticleController_update5_route(params) =>
      call { 
        controllers_ArticleController_update5_invoker.call(ArticleController_1.update)
      }
  
    // @LINE:10
    case controllers_ArticleController_delete6_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ArticleController_delete6_invoker.call(ArticleController_1.delete(id))
      }
  
    // @LINE:12
    case controllers_CategoryController_findAll7_route(params) =>
      call { 
        controllers_CategoryController_findAll7_invoker.call(CategoryController_0.findAll)
      }
  
    // @LINE:13
    case controllers_CategoryController_find8_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_CategoryController_find8_invoker.call(CategoryController_0.find(id))
      }
  
    // @LINE:14
    case controllers_CategoryController_create9_route(params) =>
      call { 
        controllers_CategoryController_create9_invoker.call(CategoryController_0.create)
      }
  
    // @LINE:15
    case controllers_CategoryController_update10_route(params) =>
      call { 
        controllers_CategoryController_update10_invoker.call(CategoryController_0.update)
      }
  
    // @LINE:16
    case controllers_CategoryController_delete11_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_CategoryController_delete11_invoker.call(CategoryController_0.delete(id))
      }
  }
}
