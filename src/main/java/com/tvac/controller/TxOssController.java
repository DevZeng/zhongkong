package com.tvac.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.AnonymousCOSCredentials;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.model.GeneratePresignedUrlRequest;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import com.tvac.common.IDUtil;
import com.tvac.common.Results;
import com.tvac.tx.oss.Cosclient;

import com.tvac.common.Msg;
import com.tvac.common.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="腾讯对象存储")
public class TxOssController {

	  @PostMapping(value="/txUpload_t")
	  @ApiOperation(value="腾讯对象存储")
	  public Msg txUpload_t(@RequestParam(value = "file") MultipartFile file) throws IOException{
		  Results result=new Results();
	        if(file != null){
//	        	String detect=util.detect(file.getBytes());
					
						//开始
					  	String oldFileName = file.getOriginalFilename();
				        String eName = oldFileName.substring(oldFileName.lastIndexOf("."));//拿到后缀
				        String newFileName = IDUtil.getRandomId()+eName;
				        Calendar cal = Calendar.getInstance();
				        int year = cal.get(Calendar.YEAR);
				        int month=cal.get(Calendar.MONTH);
				        int day=cal.get(Calendar.DATE);
				        // 1 初始化用户身份信息(secretId, secretKey)
				        //生成签名就需要初始化身份信息
//				        COSCredentials cred = new BasicCOSCredentials(Cosclient.getAccessKey(), Cosclient.getSecretKey());
				        COSCredentials cred = new AnonymousCOSCredentials();
				        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
				        ClientConfig clientConfig = new ClientConfig(new Region(Cosclient.getBucket()));
				        // 3 生成cos客户端
				        COSClient cosclient = new COSClient(cred, clientConfig);
				        // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
				        String bucketName = Cosclient.getBucketName();

				        // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20 M 以下的文件使用该接口
				        // 大文件上传请参照 API 文档高级 API 上传
				        File localFile = null;
				        try {
				            localFile = File.createTempFile("temp",null);
				            file.transferTo(localFile);
				            // 指定要上传到 COS 上的路径
				            String key = Cosclient.getQianzui()+"/"+year+"/"+newFileName;
				            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
				            PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);
				          //获取
				            GeneratePresignedUrlRequest req =
				                    new GeneratePresignedUrlRequest(bucketName, key, HttpMethodName.GET);
				            URL url = cosclient.generatePresignedUrl(req);
				            return ResultUtil.success(url.toString(), "SUCCESS");
				        } catch (IOException e) {
				        	return ResultUtil.error(0, e.getMessage());
				        }finally {
				            // 关闭客户端(关闭后台线程)
				            cosclient.shutdown();
				        }	//结束  
	        	
	        }else {
	        	return ResultUtil.error(0, "文件为空");
	        }
	    }  
}
