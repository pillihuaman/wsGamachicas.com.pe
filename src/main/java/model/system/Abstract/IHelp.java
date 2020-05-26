package model.system.Abstract;

import java.io.IOException;

import common.system.AppPropertiesConfig;

public interface IHelp {
  String getUserName();
  String getPassword();
  String getDomainAPICore();
  String getDomainAPPGamachicas();
}

//public String UserName() {
//	AppPropertiesConfig AppPropertiesConfig = new AppPropertiesConfig();
//	try {
//		return AppPropertiesConfig.getPropValues("UserName");
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	return null;
//}
//
//public String Password() {
//	AppPropertiesConfig AppPropertiesConfig = new AppPropertiesConfig();
//	try {
//		return AppPropertiesConfig.getPropValues("Password");
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	return null;
//}
//public String Url() {
//	AppPropertiesConfig AppPropertiesConfig = new AppPropertiesConfig();
//	try {
//		return AppPropertiesConfig.getPropValues("urlImagenAPI");
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	return null;
//}

