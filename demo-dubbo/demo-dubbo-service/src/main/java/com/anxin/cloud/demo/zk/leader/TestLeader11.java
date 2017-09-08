package com.anxin.cloud.demo.zk.leader;

import java.net.InetAddress;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

import com.anxin.cloud.demo.zk.SetConfig;

public class TestLeader11 {
	
	public static void main(String[] args) throws Exception {
		System.err.println(InetAddress.getLocalHost().getHostAddress());
		
		ZooKeeper zk = new ZooKeeper(SetConfig.URL, SetConfig.sessionTimeout, new Watcher(){
			@Override
			public void process(WatchedEvent event) {
				// TODO Auto-generated method stub
				System.out.println("TestLeader22触发了事件：" + event.getType() + "，事件状态：" + event.getState() + "，事件Path：" + event.getPath());
			}
		});
		
		//zk.addAuthInfo(SetConfig.auth_type, SetConfig.auth_passwd.getBytes());
		
		while (ZooKeeper.States.CONNECTED != zk.getState()) {
			Thread.sleep(SetConfig.sessionTimeout);
		}
		
		if(null == zk.exists("/leader", true)){
			zk.create("/leader", null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		}
		
		//if(null == zk.exists("/leader/cloud", true)){
			zk.create("/leader/cloud", "11".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
		//}
			
			long freeMemory = Runtime.getRuntime().freeMemory();
			System.err.println(freeMemory);
			int max = Integer.valueOf(Long.valueOf(freeMemory*100).toString());
			
			try {
			
				//byte[]  bb = new byte[i];
			} catch (Exception e) {
				 
				e.printStackTrace();
				System.err.println(1111111);
			}
			System.err.println(000000000000000);
			
			int i = 0;
			while(true){
				System.err.println(zk.getChildren("/leader", true));
				//System.err.println(new String(zk.getData("/leader/cloud", true, null)));
				Thread.sleep(10000);
				if(i == 2){
					byte[]  bb = new byte[max];
				}
				
				i ++;
				
			}
		
	}
	

}
