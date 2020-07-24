package com.zff.permissiontest;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSdcard();
        getSdcarddd();
    }

    /**
     * 权限申请
     * @param
     */
    @Permission(value = Manifest.permission.READ_EXTERNAL_STORAGE,requestCode = 1)
    public void getSdcard() {
        Log.d("PermissionAspectJ","打印了 getSdcard");
    }

    @Permission()
    public void getSdcarddd() {
        Log.d("PermissionAspectJ","getSdcarddd 打印了");
    }
}
