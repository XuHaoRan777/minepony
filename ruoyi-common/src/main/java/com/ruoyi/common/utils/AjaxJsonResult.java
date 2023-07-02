package com.ruoyi.common.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * 快速封裝用來返回前端的json結果
 */
public class AjaxJsonResult {

    // 默认成功信息
    private static final String DEFAULT_SUCCESS_MSG = "success";
    // 默认警告信息
    private static final String DEFAULT_WARNING_MSG = "warning";
    // 默认警告信息
    private static final String DEFAULT_ERROR_MSG = "error";

    /**
     * 返回指定状态码、信息、数据
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static String json( Integer code, String msg, Object data){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("code",code);
        jsonObject.put("message",msg);
        jsonObject.put("data",data);

        return jsonObject.toJSONString();
    }

    /**
     * 返回成功，并返回指定信息和数据
     * @param msg
     * @param data
     * @return
     */
    public static String success(String msg,Object data){
        return json(ResultCode.SUCCESS,msg,data);
    }
    /**
     * 返回成功，并返回指定信息
     * @param msg
     * @return
     */
    public static String success(String msg){
        return success(msg,null);
    }
    /**
     * 返回成功，并返回指定数据
     * @param data
     * @return
     */
    public static String success(Object data){
        return success(DEFAULT_SUCCESS_MSG,data);
    }
    /**
     * 返回成功
     * @return
     */
    public static String success(){
        return success(DEFAULT_SUCCESS_MSG,null);
    }
    //===================================================================================================================================
    /**
     * 返回错误，并返回指定信息和数据
     * @param msg
     * @param data
     * @return
     */
    public static String error(String msg,Object data){
        return json(ResultCode.ERROR,msg,data);
    }
    /**
     * 返回错误，并返回指定信息
     * @param msg
     * @return
     */
    public static String error(String msg){
        return error(msg,null);
    }
    /**
     * 返回错误，并返回指定数据
     * @param data
     * @return
     */
    public static String error(Object data){
        return error(DEFAULT_ERROR_MSG,data);
    }
    /**
     * 返回错误
     * @return
     */
    public static String error(){
        return error(DEFAULT_ERROR_MSG,null);
    }
    //===================================================================================================================================
    /**
     * 返回警告，并返回指定信息和数据
     * @param msg
     * @param data
     * @return
     */
    public static String warning(String msg,Object data){
        return json(ResultCode.WARNING,msg,data);
    }
    /**
     * 返回警告，并返回指定信息
     * @param msg
     * @return
     */
    public static String warning(String msg){
        return warning(msg,null);
    }
    /**
     * 返回警告，并返回指定数据
     * @param data
     * @return
     */
    public static String warning(Object data){
        return warning(DEFAULT_WARNING_MSG,data);
    }
    /**
     * 返回警告
     * @return
     */
    public static String warning(){
        return warning(DEFAULT_WARNING_MSG,null);
    }




}
