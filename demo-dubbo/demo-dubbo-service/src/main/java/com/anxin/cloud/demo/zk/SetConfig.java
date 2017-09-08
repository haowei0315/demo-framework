package com.anxin.cloud.demo.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class SetConfig {
	
	public final static String URL = "10.1.6.202:2181";
	
	public final static  int sessionTimeout = 3000;

	public final static String rootNode = "/Conf";
	
	public final static String urlNode = rootNode + "/url";
	public final static String usernameNode = rootNode + "/username";
	public final static String passwdNode = rootNode + "/passwd";
	
	public final static String auth_type =  "digest";
	public final static String auth_passwd =  "123456";
	
	public final static String urlV =  "jdbc:10.1.6.202:2181";
	public final static String usernameV =  "root";
	public final static String passwdV =  "123456";
	

	public static void main(String[] args) throws Exception {
		
		ZooKeeper zk = new ZooKeeper(URL, sessionTimeout, new Watcher(){
			@Override
			public void process(WatchedEvent event) {
				// TODO Auto-generated method stub
				System.out.println("触发了事件：" + event.getType() + "，事件状态：" + event.getState());
			}
		});
		
		while(ZooKeeper.States.CONNECTED != zk.getState()){
			Thread.sleep(sessionTimeout);
		}
		
		zk.addAuthInfo(auth_type, auth_passwd.getBytes());
		
		//zk.delete(urlNode, -1);
		//zk.delete(usernameNode, -1);
		//zk.delete(passwdNode, -1);
		
		if(null == zk.exists(rootNode, true)){
			zk.create(rootNode, null, Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
		}

		if(null == zk.exists(urlNode, true)){
			zk.create(urlNode, urlV.getBytes(), Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
		}
		if(null == zk.exists(usernameNode, true)){
			zk.create(usernameNode, usernameV.getBytes(), Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
		}
		if(null == zk.exists(passwdNode, true)){
			zk.create(passwdNode, passwdV.getBytes(), Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
		}
		
		zk.close();
	}

}
