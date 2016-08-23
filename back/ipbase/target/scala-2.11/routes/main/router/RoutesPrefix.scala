
// @GENERATOR:play-routes-compiler
// @SOURCE:/data/Sandbox/afpa/back/ipbase/conf/routes
// @DATE:Tue Aug 23 20:36:36 CEST 2016


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
