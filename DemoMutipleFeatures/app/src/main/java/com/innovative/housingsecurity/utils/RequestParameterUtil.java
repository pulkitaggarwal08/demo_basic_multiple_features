package com.innovative.housingsecurity.utils;

import com.innovative.housingsecurity.config.ApiConstant;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by pulkit on 27/12/17.
 */

public class RequestParameterUtil {

    public static JSONObject getRegisterObject(String fullName, String email, String phone, String password,
                                               String flatNumber, String floorNumber, String block, String societyName,
                                               String societyAddress) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(ApiConstant.FULL_NAME, fullName);
            jsonObject.put(ApiConstant.EMAIL, email);
            jsonObject.put(ApiConstant.PHONE, phone);
            jsonObject.put(ApiConstant.PASSWORD, password);
            jsonObject.put(ApiConstant.FLAT_NUMBER, flatNumber);
            jsonObject.put(ApiConstant.FLOOR_NUMBER, floorNumber);
            jsonObject.put(ApiConstant.BLOCK, block);
            jsonObject.put(ApiConstant.SOCIETY_NAME, societyName);
            jsonObject.put(ApiConstant.SOCIETY_ADDRESS, societyAddress);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static JSONObject getLoginObject(String username, String password, String token, String deviceId, String appType) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(ApiConstant.LOGIN, username);
            jsonObject.put(ApiConstant.PASSWORD, password);
            jsonObject.put(ApiConstant.TOKEN, token);
            jsonObject.put(ApiConstant.DEVICE_ID, deviceId);
            jsonObject.put(ApiConstant.APP_TYPE, appType);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static JSONObject getScannedObject(String item_id) {

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put(ApiConstant.LOGIN, item_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
