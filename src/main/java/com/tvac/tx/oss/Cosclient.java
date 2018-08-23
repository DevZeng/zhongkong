package com.tvac.tx.oss;

/*
 * 
 * tengxun
 */

public class Cosclient {

	
	private static String accessKey="AKIDTpDTZdLR8g32yoCPbz6EG9QdkvU2NySv";
	
	private static String secretKey="lXJ63rYItMm4EPSWVK3b0Y0Vu8E9tXiE";
	 
	private static String bucket="ap-guangzhou";
	
    private static String bucketName="babihu2018-1256705913";
    
    private static String path="https://babihu2018-1256705913.cos.ap-guangzhou.myqcloud.com";
    
    private static String qianzui="bbh";

	public static String getAccessKey() {
		return accessKey;
	}

	public static void setAccessKey(String accessKey) {
		Cosclient.accessKey = accessKey;
	}

	public static String getSecretKey() {
		return secretKey;
	}

	public static void setSecretKey(String secretKey) {
		Cosclient.secretKey = secretKey;
	}

	public static String getBucket() {
		return bucket;
	}

	public static void setBucket(String bucket) {
		Cosclient.bucket = bucket;
	}

	public static String getBucketName() {
		return bucketName;
	}

	public static void setBucketName(String bucketName) {
		Cosclient.bucketName = bucketName;
	}

	public static String getPath() {
		return path;
	}

	public static void setPath(String path) {
		Cosclient.path = path;
	}

	public static String getQianzui() {
		return qianzui;
	}

	public static void setQianzui(String qianzui) {
		Cosclient.qianzui = qianzui;
	}
    
}
