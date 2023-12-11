package com.mukesh.composetask.ui

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import com.mukesh.composetask.di.timerModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import java.lang.ref.WeakReference

class ApplicationController: Application()  {

    companion object {
        var context: WeakReference<Context>? = null
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ApplicationController)
            modules(timerModule)
        }

        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks{
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) = Unit

            override fun onActivityStarted(activity: Activity) = Unit

            override fun onActivityResumed(activity: Activity) {
                context = WeakReference(activity)
            }

            override fun onActivityPaused(activity: Activity) = Unit

            override fun onActivityStopped(activity: Activity) = Unit

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) = Unit

            override fun onActivityDestroyed(activity: Activity) = Unit

        })
    }

}