package com.taotao.fastdfs;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import com.taotao.utils.FastDFSClient;

public class TestFastDFS {
	
	 public void testUploadFile() throws Exception{  
	        //1.向工程添加jar包  
	        //2.创建一个配置文件，配置tracker服务器地址  
	        //3.加载配置文件  
	        ClientGlobal.init("E:/workspace/taotao/taotao-manager-web/src/main/resources/resource/client.conf");  
	        //4.创建一个TrackerClient对象  
	        TrackerClient trackerClient = new TrackerClient();  
	        //5.使用TrackerClient对象获得trackerserver对象。  
	        TrackerServer trackerServer = trackerClient.getConnection();  
	        //6.创建一个StorageServer的引用，我们用null就可以  
	        StorageServer storageServer = null;  
	        //7.创建一个StorageClient对象。trackerserver、StorageServer两个参数  
	        StorageClient storageClient = new StorageClient(trackerServer, storageServer);  
	        //8.使用StorageClient对象上传文件  
	        NameValuePair[] metaList = new NameValuePair[3];  
	        metaList[0] = new NameValuePair("fileName", "2");  
	        metaList[1] = new NameValuePair("createTime", "2018-06-11 9:01:00");  
	        metaList[2] = new NameValuePair("createUser", "yzwangc");  
	        String[] upload_files = storageClient.upload_file("C:/Users/Administrator/Desktop/123.jpg", "jpg", metaList);  
	        for(String file : upload_files){  
	            System.out.println(file);  
	        }  
	    }  
	 
	 @Test
	    public void testUpload() throws Exception {
	    	FastDFSClient fast = new FastDFSClient("E:/workspace/taotao/taotao-manager-web/src/main/resources/resource/client.conf");
	    	String imgPath = fast.uploadFile("C:/Users/Administrator/Desktop/123.jpg");
	    	System.out.println(imgPath);  
	    }
}
