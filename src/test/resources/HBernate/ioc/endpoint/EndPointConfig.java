package sgcib.eliot.datalake.HBernate.ioc.endpoint;

import sgcib.eliot.datalake.HBernate.ioc.annotations.Service;
import sgcib.eliot.datalake.HBernate.ioc.mapping.IService;

public class EndPointConfig {

	private IService service;

	public EndPointConfig() {
		super();
	}

	@Service
	public EndPointConfig(IService service) {
		this.service = service;
	}

	public IService getService() {
		return service;
	}

	public void setService(IService service) {
		this.service = service;
	}

}