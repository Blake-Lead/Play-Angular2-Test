
// @GENERATOR:play-routes-compiler
// @SOURCE:/data/Sandbox/afpa/back/ipbase/conf/routes
// @DATE:Tue Aug 23 20:36:36 CEST 2016

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseGroupController GroupController = new controllers.ReverseGroupController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseApplicationController ApplicationController = new controllers.ReverseApplicationController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAddressController AddressController = new controllers.ReverseAddressController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseGroupController GroupController = new controllers.javascript.ReverseGroupController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseApplicationController ApplicationController = new controllers.javascript.ReverseApplicationController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAddressController AddressController = new controllers.javascript.ReverseAddressController(RoutesPrefix.byNamePrefix());
  }

}
