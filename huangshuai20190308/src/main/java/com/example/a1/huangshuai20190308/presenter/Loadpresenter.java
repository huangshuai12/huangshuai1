package com.example.a1.huangshuai20190308.presenter;

import android.os.Handler;

import com.example.a1.huangshuai20190308.contract.LoadContract;
import com.example.a1.huangshuai20190308.model.LoadModel;
import com.example.a1.huangshuai20190308.net.RequesctCallBack;

import java.util.HashMap;

public class Loadpresenter extends LoadContract.Lloadpresenter {
    private final LoadModel loadModel;
   public static LoadContract.LloadView lloadView;

    public Loadpresenter(LoadContract.LloadView lloadView) {
        this.lloadView = lloadView;
        loadModel = new LoadModel();
    }

    @Override
    public void ppresenter(HashMap<String, String> map) {
        loadModel.model(map, new RequesctCallBack() {
            @Override
            public void Success(String result) {
                if (lloadView!=null){
                    lloadView.Success(result);
                }
            }

            @Override
            public void Failure(String msg) {
                if (lloadView!=null){
                    lloadView.Failure(msg);
                }
            }
        });
    }
    //防止内存泄漏
    public static void ondestory(){
       lloadView=null;
    }
}
