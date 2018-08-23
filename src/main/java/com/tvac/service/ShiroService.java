package com.tvac.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvac.common.AllResult;
import com.tvac.common.Msg;
import com.tvac.common.ResultUtil;
import com.tvac.common.Results;
import com.tvac.entriy.Login;
import com.tvac.mapper.LoginMapper;
import com.tvac.shiro.util.JWTUtil;

@Service
public class ShiroService {

	@Autowired
	private LoginMapper loginMapper;
	
//    private final ResultMap resultMap=new ResultMap();
	
	/*
	 * 登录
	 */
//    public String getPasswordByUsername(Long username){
//    	Login select_login = loginMapper.select_login(username);
//        String pwd=select_login.getUser_pwd();
//        return pwd;
//    }
  @SuppressWarnings("unused")
public Msg getPasswordByUsername(Long username,String password) throws NoSuchAlgorithmException, UnsupportedEncodingException{
	Login select_login = loginMapper.select_login(username);
	 if(select_login!=null) {
		    String pwd=select_login.getUser_pwd();
		    MessageDigest md;
			 md = MessageDigest.getInstance("MD5");  // 创建一个md5算法对象  
			 byte[] messageByte = password.getBytes("UTF-8");
			 byte[] md5Byte = md.digest(messageByte);              // 获得MD5字节数组,16*8=128位  
			 String lh_pwd = bytesToHex(md5Byte);
		 if(pwd.equals(lh_pwd)) {
			 return ResultUtil.success(JWTUtil.createToken(String.valueOf(username)),"SUCCESS",null);
//			 return resultMap.success().code(200).message(JWTUtil.createToken(String.valueOf(username)));
		 }else {
			 return ResultUtil.error(0, "密码错误");
		 }
	 }else {
		 return ResultUtil.error(0, "账号错误");
	 }
}
	
    /*
     * 添加登录
     */
    public Msg  insert_login(Login login) throws UnsupportedEncodingException {
    	Results result=new Results();
    	Login select_login=loginMapper.select_login(login.getUser_iphone());
    	if(select_login==null) {
    		MessageDigest md;
			try {
			 md = MessageDigest.getInstance("MD5");  // 创建一个md5算法对象  
	         byte[] messageByte = login.getUser_pwd().getBytes("UTF-8");  
	         byte[] md5Byte = md.digest(messageByte);              // 获得MD5字节数组,16*8=128位  
	         String lh_pwd = bytesToHex(md5Byte); 
	         login.setUser_pwd(lh_pwd);
	         login.setRole("user");
        	int insert_login=loginMapper.insert_login(login);
        	if(insert_login==1) {
        		return ResultUtil.success(1, "注册成功",null);
        	}else {
   			 return ResultUtil.error(0, "添加错误");
        	}	
        } catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}else {
			 return ResultUtil.error(0, "账号已经存在!");
    	}
		return null;
    }
    
    /*
     * 删除登录
     */
    public Msg  delete_login(int id) {
        	int delete_login=loginMapper.delete_login(id);
        	if(delete_login==1) {
        		return ResultUtil.success(1, "删除成功",null);
        	}else {
        		return ResultUtil.error(0, "添加错误");
        	}
    }
    
    /*
     * 查看所有的账号
     */
    public Msg select_all_login() {
    	List<Login> select_all_login=loginMapper.select_all_login();
    	return ResultUtil.success(select_all_login, "SUECCSS",null);
    }
    
	/*
	 * 调用md5
	 */
	private String  bytesToHex(byte[] bytes) {
		// TODO Auto-generated method stub
		 StringBuffer hexStr = new StringBuffer();  
	        int num;  
	        for (int i = 0; i < bytes.length; i++) {  
	            num = bytes[i];  
	             if(num < 0) {  
	                 num += 256;  
	            }  
	            if(num < 16){  
	                hexStr.append("0");  
	            }  
	            hexStr.append(Integer.toHexString(num));  
	        }  
	        return hexStr.toString().toUpperCase();  
	}
}
