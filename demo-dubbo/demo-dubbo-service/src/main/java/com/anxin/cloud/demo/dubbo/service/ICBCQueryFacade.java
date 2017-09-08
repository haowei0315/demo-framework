package com.anxin.cloud.demo.dubbo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.anxin.cloud.demo.dubbo.facade.IIcbcQueryFacade;

@Service("icbcQueryFacade")
public class ICBCQueryFacade implements IIcbcQueryFacade {

	@Override
	public Map<String, Object> queryByRefCode(String refCode) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		// XXX
		map.put("name", "张三");
		map.put("loanAmount", BigDecimal.valueOf(123.345));
		map.put("flag", true);

		System.err.println("调用中。。。。");
		return map;
	}

	/*@Override
	public void upload(Long customerId, InputStream in) {
		System.err.println("客户id文件上传中" + customerId);
		try {
			File file = FileUploadUtils.getAbsoluteFile("c:\\louad\\"+System.currentTimeMillis()+".txt");
			FileOutputStream out = new FileOutputStream(file);
			FileCopyUtils.copy(in, out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	@Override
	public void upload(Long customerId, byte[] in) {
		System.err.println("客户id文件上传中" + customerId);
		try {
			//File file = FileUploadUtils.getAbsoluteFile("c:\\louad\\"+System.currentTimeMillis()+".txt");
			File file = new File("c:\\louad\\"+System.currentTimeMillis()+".txt");
			FileOutputStream out = new FileOutputStream(file);
			FileCopyUtils.copy(in, out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
