/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.example.notificationscheduler;

import android.app.AlarmManager;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int JOB_ID = 0;
    private JobScheduler mScheduler;
    private ComponentName serviceName;
    private JobInfo.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        serviceName = new ComponentName(getPackageName(),
                NotificationJobService.class.getName());
        builder = new JobInfo.Builder(JOB_ID, serviceName);
    }

    /**
     * onClick method that schedules the jobs based on the parameters set.
     */
    public void scheduleJob(View view) {
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setRequiresDeviceIdle(true)
                .setRequiresCharging(true)
                .setPeriodic(AlarmManager.INTERVAL_DAY);

        JobInfo myJobInfo = builder.build();
        mScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        if (mScheduler != null) {
            mScheduler.schedule(myJobInfo);
        }
        Toast.makeText(this, R.string.job_scheduled, Toast.LENGTH_SHORT)
                .show();
    }

    /**
     * onClick method for cancelling all existing jobs.
     */
    public void cancelJobs(View view) {
        if (mScheduler != null) {
            mScheduler.cancelAll();
            mScheduler = null;
            Toast.makeText(this, R.string.jobs_canceled, Toast.LENGTH_SHORT)
                    .show();
        }
    }

    public void downloadNow(View view) {
        JobInfo myJobInfo = builder.build();
        mScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        if (mScheduler != null) {
            mScheduler.schedule(myJobInfo);
        }
        Toast.makeText(this, R.string.download_now_txt, Toast.LENGTH_SHORT)
                .show();
    }
}
