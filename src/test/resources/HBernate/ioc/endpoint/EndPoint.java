package sgcib.eliot.datalake.HBernate.ioc.endpoint;

import sgcib.eliot.datalake.HBernate.ioc.annotations.Bean;
import sgcib.eliot.datalake.HBernate.ioc.mapping.IService;

public class EndPoint {

	private IService service;

	public EndPoint() {
		super();
	}

	@Bean
	public EndPoint(IService service) {
		this.service = service;
	}

	public IService getService() {
		return service;
	}

	public void setService(IService service) {
		this.service = service;
	}

}