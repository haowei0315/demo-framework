package com.anxin.cloud.demo.zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.util.Assert;

public class MyClient implements Watcher {

	private String url;
	private String username;
	private String passwd;

	private ZooKeeper zk = null;

	public ZooKeeper getZk() throws Exception {
		if (null == zk) {
			zk = new ZooKeeper(SetConfig.URL, SetConfig.sessionTimeout, this);
			
			zk.addAuthInfo(SetConfig.auth_type, SetConfig.auth_passwd.getBytes());
			
			while (ZooKeeper.States.CONNECTED != zk.getState()) {
				Thread.sleep(SetConfig.sessionTimeout);
			}
		}
		//System.out.println("连接ZK服务器成功!");
		return zk;
	}

	public void initValue() {
		Assert.notNull(zk);
		try {
			this.url = new String(zk.getData(SetConfig.urlNode, true, null));
			this.username = new String(zk.getData(SetConfig.usernameNode, true, null));
			this.passwd = new String(zk.getData(SetConfig.passwdNode, true, null));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		MyClient myClient = new MyClient();
		ZooKeeper zk = myClient.getZk();
		myClient.initValue();
		
		int i = 0;
		while(true){
			System.out.println(myClient);
			System.out.println("--------------------------------------     " + i );
			Thread.sleep(10000);
			i++;
			
			if(i == 10){
				break;
			}
		}
		
		zk.close();

	}

	@Override
	public void process(WatchedEvent event) {
		if(Watcher.Event.EventType.None == event.getType()){
			System.out.println("连接ZK服务器成功!");
		}else if(Watcher.Event.EventType.NodeCreated == event.getType()){
			System.out.println("节点创建成功!");
		}else if(Watcher.Event.EventType.NodeDeleted == event.getType()){
			System.out.println("节点删除成功!");
		}else if(Watcher.Event.EventType.NodeDataChanged == event.getType()){
			System.out.println("节点数据更新成功!");
			System.err.println(event.getPath());
			
			//读取新的配置
			this.initValue();
		}else if(Watcher.Event.EventType.NodeChildrenChanged == event.getType()){
			System.out.println("子节点创建成功!");
			
			//读取新的配置
			this.initValue();
		}

	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return  "url：" + url + "\t username：" + username +"\t passwd：" + passwd ;
	}

}
