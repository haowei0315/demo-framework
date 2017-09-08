package com.anxin.cloud.demo.dubbo.facade;

import java.util.Map;

public interface IIcbcQueryFacade {

	public Map<String, Object> queryByRefCode(String refCode);
	
	//public void upload(Long customerId, InputStream in);
	public void upload(Long customerId, byte[] in);
}
