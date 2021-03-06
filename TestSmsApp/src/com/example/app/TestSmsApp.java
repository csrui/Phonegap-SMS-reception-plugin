/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package com.example.app;

import org.apache.cordova.Config;
import org.apache.cordova.DroidGap;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class TestSmsApp extends DroidGap {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set by <content src="index.html" /> in config.xml
        super.loadUrl(Config.getStartUrl());
        // super.loadUrl("file:///android_asset/www/index.html")
        
        Log.v(TAG, "SMS content column names.");
        getColumnNames();
    }

    private void getColumnNames() {
        Uri sms = Uri.parse("content://sms/inbox");
        ContentResolver cr = this.getContentResolver();
        Cursor c = cr.query(sms, null, null, null, null);
        if (c != null) {
            for (int i = 0; i < c.getColumnCount(); i++) {
                Log.v(TAG, c.getColumnName(i).toString());
            }
            c.close();
        }
    }
}
