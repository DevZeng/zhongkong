package com.tvac.common;


/**
 * @author zou
 * @date 2017/8/20
 */
public class ResultUtil<T> {
	/**
     * 请求成功返回
     * @param object
     * @return
     */
    public static Msg success(Object object,String meg,String totle){
        Msg msg=new Msg();
        msg.setCode(200);
        msg.setMsg(meg);
        msg.setTotle(totle);
        msg.setData(object);
        return msg;
    }
    public static Msg success(String meg,String totle){
		return success(null, meg,totle);
    }
 
    public static Msg error(Integer code,String resultmsg){
        Msg msg=new Msg();
        msg.setCode(code);
        msg.setMsg(resultmsg);
        return msg;
    }
}
