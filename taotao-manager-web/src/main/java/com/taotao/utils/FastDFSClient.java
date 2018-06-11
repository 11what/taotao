package com.taotao.utils;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FastDFSClient {
	
	private TrackerClient trackerClient = null; 
	
    private TrackerServer trackerServer = null;
    
    private StorageServer storageServer = null; 
    
    /**
     * 使用的Storage客户端是StorageClient1而不是StorageClient，这个客户端的好处是能够帮我们自动把文件所在的组以及存放位置拼接到一块。
     */
    private StorageClient1 storageClient = null;
    
    public FastDFSClient(String conf) throws Exception {  
        if (conf.contains("classpath:")) {  
            conf = conf.replace("classpath:", this.getClass().getResource("/").getPath());  
        }  
        ClientGlobal.init(conf);  
        trackerClient = new TrackerClient();  
        trackerServer = trackerClient.getConnection();  
        storageServer = null;  
        storageClient = new StorageClient1(trackerServer, storageServer);  
    }  
    
    /**  
     * 上传文件方法   
     * @param fileName
     * @param extName
     * @param metas
     * @return
     * @throws Exception
     */
    public String uploadFile(String fileName, String extName, NameValuePair[] metas) throws Exception {  
        String result = storageClient.upload_file1(fileName, extName, metas);  
        return result;  
    }  
	 
    public String uploadFile(String fileName) throws Exception {  
        return uploadFile(fileName, null, null);  
    }  
      
    public String uploadFile(String fileName, String extName) throws Exception {  
        return uploadFile(fileName, extName, null);  
    }  
    
    /**  
     * 上传文件方法  
     * @param fileContent
     * @param extName
     * @param metas
     * @return
     * @throws Exception
     */
    public String uploadFile(byte[] fileContent, String extName, NameValuePair[] metas) throws Exception {  
          
        String result = storageClient.upload_file1(fileContent, extName, metas);  
        return result;  
    }  
      
    public String uploadFile(byte[] fileContent) throws Exception {  
        return uploadFile(fileContent, null, null);  
    }  
      
    public String uploadFile(byte[] fileContent, String extName) throws Exception {  
        return uploadFile(fileContent, extName, null);  
    }  
}
