package com.example.a1.huangshuai20190308.contract;

import com.example.a1.huangshuai20190308.net.RequesctCallBack;

import java.util.HashMap;

public interface LoadContract {
    //p层
    public abstract class Lloadpresenter{
        public abstract void ppresenter(HashMap<String,String> map);
    }
    public
    interface LloadModel{
        void model(HashMap<String,String> map, RequesctCallBack callBack);
    }
    interface LloadView{
        void Success(String result);
        void Failure(String msg);
    }
}
