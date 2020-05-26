package common.system.webservice.Adapter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.system.AppPropertiesConfig;
import model.system.Abstract.IHelp;
import model.system.repository.Help;

@Service
public class HelpService  implements IHelp {
	AppPropertiesConfig AppPropertiesConfig = new AppPropertiesConfig();
	@Override
	public String getUserName() {
		try {
			return AppPropertiesConfig.getPropValues("UserName");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getPassword() {

		try {
			return AppPropertiesConfig.getPropValues("Password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getDomainAPICore() {
		try {
			return AppPropertiesConfig.getPropValues("DomainAPICore");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String getDomainAPPGamachicas() {
		// TODO Auto-generated method stub
		try {
			return AppPropertiesConfig.getPropValues("DomainAPPGamachicas");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
