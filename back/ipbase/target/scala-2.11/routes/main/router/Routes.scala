
// @GENERATOR:play-routes-compiler
// @SOURCE:/data/Sandbox/afpa/back/ipbase/conf/routes
// @DATE:Tue Aug 23 20:36:36 CEST 2016

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
  ApplicationController_0: controllers.ApplicationController,
  // @LINE:5
  AddressController_2: controllers.AddressController,
  // @LINE:12
  GroupController_1: controllers.GroupController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:3
    ApplicationController_0: controllers.ApplicationController,
    // @LINE:5
    AddressController_2: controllers.AddressController,
    // @LINE:12
    GroupController_1: controllers.GroupController
  ) = this(errorHandler, ApplicationController_0, AddressController_2, GroupController_1, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, ApplicationController_0, AddressController_2, GroupController_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.ApplicationController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addresses""", """controllers.AddressController.findAll"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addresses/""" + "$" + """id<[^/]+>""", """controllers.AddressController.find(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addresses/bygroup/""" + "$" + """id<[^/]+>""", """controllers.AddressController.findByGroup(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addresses""", """controllers.AddressController.create"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addresses""", """controllers.AddressController.update"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addresses/""" + "$" + """id<[^/]+>""", """controllers.AddressController.delete(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """groups""", """controllers.GroupController.findAll"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """groups/""" + "$" + """id<[^/]+>""", """controllers.GroupController.find(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """groups""", """controllers.GroupController.create"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """groups""", """controllers.GroupController.update"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """groups/""" + "$" + """id<[^/]+>""", """controllers.GroupController.delete(id:Long)"""),
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
    ApplicationController_0.index,
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
  private[this] lazy val controllers_AddressController_findAll1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addresses")))
  )
  private[this] lazy val controllers_AddressController_findAll1_invoker = createInvoker(
    AddressController_2.findAll,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AddressController",
      "findAll",
      Nil,
      "GET",
      """""",
      this.prefix + """addresses"""
    )
  )

  // @LINE:6
  private[this] lazy val controllers_AddressController_find2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addresses/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AddressController_find2_invoker = createInvoker(
    AddressController_2.find(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AddressController",
      "find",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """addresses/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_AddressController_findByGroup3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addresses/bygroup/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AddressController_findByGroup3_invoker = createInvoker(
    AddressController_2.findByGroup(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AddressController",
      "findByGroup",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """addresses/bygroup/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_AddressController_create4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addresses")))
  )
  private[this] lazy val controllers_AddressController_create4_invoker = createInvoker(
    AddressController_2.create,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AddressController",
      "create",
      Nil,
      "POST",
      """""",
      this.prefix + """addresses"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_AddressController_update5_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addresses")))
  )
  private[this] lazy val controllers_AddressController_update5_invoker = createInvoker(
    AddressController_2.update,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AddressController",
      "update",
      Nil,
      "PUT",
      """""",
      this.prefix + """addresses"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_AddressController_delete6_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addresses/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AddressController_delete6_invoker = createInvoker(
    AddressController_2.delete(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AddressController",
      "delete",
      Seq(classOf[Long]),
      "DELETE",
      """""",
      this.prefix + """addresses/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_GroupController_findAll7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("groups")))
  )
  private[this] lazy val controllers_GroupController_findAll7_invoker = createInvoker(
    GroupController_1.findAll,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "findAll",
      Nil,
      "GET",
      """""",
      this.prefix + """groups"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_GroupController_find8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("groups/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_GroupController_find8_invoker = createInvoker(
    GroupController_1.find(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "find",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """groups/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_GroupController_create9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("groups")))
  )
  private[this] lazy val controllers_GroupController_create9_invoker = createInvoker(
    GroupController_1.create,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "create",
      Nil,
      "POST",
      """""",
      this.prefix + """groups"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_GroupController_update10_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("groups")))
  )
  private[this] lazy val controllers_GroupController_update10_invoker = createInvoker(
    GroupController_1.update,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "update",
      Nil,
      "PUT",
      """""",
      this.prefix + """groups"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_GroupController_delete11_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("groups/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_GroupController_delete11_invoker = createInvoker(
    GroupController_1.delete(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "delete",
      Seq(classOf[Long]),
      "DELETE",
      """""",
      this.prefix + """groups/""" + "$" + """id<[^/]+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:3
    case controllers_ApplicationController_index0_route(params) =>
      call { 
        controllers_ApplicationController_index0_invoker.call(ApplicationController_0.index)
      }
  
    // @LINE:5
    case controllers_AddressController_findAll1_route(params) =>
      call { 
        controllers_AddressController_findAll1_invoker.call(AddressController_2.findAll)
      }
  
    // @LINE:6
    case controllers_AddressController_find2_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_AddressController_find2_invoker.call(AddressController_2.find(id))
      }
  
    // @LINE:7
    case controllers_AddressController_findByGroup3_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_AddressController_findByGroup3_invoker.call(AddressController_2.findByGroup(id))
      }
  
    // @LINE:8
    case controllers_AddressController_create4_route(params) =>
      call { 
        controllers_AddressController_create4_invoker.call(AddressController_2.create)
      }
  
    // @LINE:9
    case controllers_AddressController_update5_route(params) =>
      call { 
        controllers_AddressController_update5_invoker.call(AddressController_2.update)
      }
  
    // @LINE:10
    case controllers_AddressController_delete6_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_AddressController_delete6_invoker.call(AddressController_2.delete(id))
      }
  
    // @LINE:12
    case controllers_GroupController_findAll7_route(params) =>
      call { 
        controllers_GroupController_findAll7_invoker.call(GroupController_1.findAll)
      }
  
    // @LINE:13
    case controllers_GroupController_find8_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_GroupController_find8_invoker.call(GroupController_1.find(id))
      }
  
    // @LINE:14
    case controllers_GroupController_create9_route(params) =>
      call { 
        controllers_GroupController_create9_invoker.call(GroupController_1.create)
      }
  
    // @LINE:15
    case controllers_GroupController_update10_route(params) =>
      call { 
        controllers_GroupController_update10_invoker.call(GroupController_1.update)
      }
  
    // @LINE:16
    case controllers_GroupController_delete11_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_GroupController_delete11_invoker.call(GroupController_1.delete(id))
      }
  }
}
