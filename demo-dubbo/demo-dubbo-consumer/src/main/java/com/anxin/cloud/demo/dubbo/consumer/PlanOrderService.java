package com.anxin.cloud.demo.dubbo.consumer;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anxin.cloud.demo.dubbo.facade.IIcbcQueryFacade;

@Service()
public class PlanOrderService {

	private Logger logger = LoggerFactory.getLogger(PlanOrderService.class);

	@Autowired
	private IIcbcQueryFacade icbcQueryFacade;

	public void queryByRefCode(String refCode) {
		logger.info("PlanOrderService queryByRefCode befor: " + System.currentTimeMillis());
		Map<String, Object> result = icbcQueryFacade.queryByRefCode(refCode);
		logger.info("PlanOrderService queryByRefCode end: " + System.currentTimeMillis());
		logger.info("PlanOrderService queryByRefCode result: " + result);
		System.err.println(result);
	}

	
	public void upload(Long customerId, byte[] in){
		logger.info("PlanOrderService upload befor: " + System.currentTimeMillis());
		icbcQueryFacade.upload(customerId, in);
		logger.info("PlanOrderService upload end: " + System.currentTimeMillis());
	}
	
}
