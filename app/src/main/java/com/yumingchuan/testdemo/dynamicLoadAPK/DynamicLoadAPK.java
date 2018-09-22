package com.yumingchuan.testdemo.dynamicLoadAPK;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

/**
 * Created by yumingchuan on 2018/9/22.
 */

public class DynamicLoadAPK {

    /**
     * 类加载器
     *
     * @param mContext
     * @param className
     * @param mDexPath
     */
    public static void loadClass(Context mContext, String className, String mDexPath) {
        File dexOutputDir = mContext.getDir("dex", 0);
        String dexOutputPath = dexOutputDir.getAbsolutePath();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        DexClassLoader dexClassLoader = new DexClassLoader(mDexPath, dexOutputPath, null, classLoader);
        try {
            Class loadClass = dexClassLoader.loadClass(className);
            Constructor<?> constructor = loadClass.getConstructor(new Class[]{});
            Object instance = constructor.newInstance(new Object[]{});
            Method setProxy = loadClass.getMethod("setProxy", new Class[]{Activity.class});
            setProxy.setAccessible(true);
            setProxy.invoke(instance, new Object[]{mContext});

            Method onCreate = loadClass.getDeclaredMethod("onCreate", new Class[]{Bundle.class});
            onCreate.setAccessible(true);
            Bundle bundle = new Bundle();
            bundle.putString("from", "dynamicLoadAPK");
            onCreate.invoke(instance, new Object[]{bundle});

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 资源加载器
     *
     * @param mContext
     * @param mDexPath
     * @return
     */
    public static Resources loadAssert(Context mContext, String mDexPath) {
        try {
            AssetManager assetManager = AssetManager.class.newInstance();
            Method addAssetPath = assetManager.getClass().getMethod("addAssetPath", String.class);
            addAssetPath.invoke(assetManager, mDexPath);

            Resources superResources = mContext.getResources();

            Resources resources = new Resources(assetManager, superResources.getDisplayMetrics(), superResources.getConfiguration());
            Resources.Theme theme = resources.newTheme();
            theme.setTo(mContext.getTheme());

            return resources;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
