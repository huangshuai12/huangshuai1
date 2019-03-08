package com.example.a1.huangshuai20190308.model;

import android.os.Handler;

import com.example.a1.huangshuai20190308.Api.UserApi;
import com.example.a1.huangshuai20190308.contract.LoadContract;
import com.example.a1.huangshuai20190308.net.OkHttpCallBack;
import com.example.a1.huangshuai20190308.net.OkHttpUtils;
import com.example.a1.huangshuai20190308.net.RequesctCallBack;

import java.util.HashMap;

public class LoadModel implements LoadContract.LloadModel {
    private Handler handler=new Handler();
    @Override
    public void model(HashMap<String, String> map, final RequesctCallBack callBack) {
        OkHttpUtils.getInstance().doGet(UserApi.UserApi, new OkHttpCallBack() {
            @Override
            public void Success(final String result) {
                if(callBack!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                        callBack.Success(result);
                        }
                    });
                }
            }

            @Override
            public void Failure(final String msg) {
                if (callBack!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                        callBack.Failure(msg);
                        }
                    });
                }
            }
        });
    }
}
