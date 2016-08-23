
// @GENERATOR:play-routes-compiler
// @SOURCE:/data/Sandbox/afpa/back/wiki/conf/routes
// @DATE:Mon Aug 15 00:10:59 CEST 2016


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
