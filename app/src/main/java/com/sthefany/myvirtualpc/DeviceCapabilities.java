package com.sthefany.myvirtualpc;

import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.app.ActivityManager;

public final class DeviceCapabilities {
    private DeviceCapabilities() {}

    public static String abi() {
        if (Build.VERSION.SDK_INT >= 21 && Build.SUPPORTED_ABIS.length > 0) {
            return Build.SUPPORTED_ABIS[0];
        }
        return Build.CPU_ABI;
    }

    public static boolean isArmv7() {
        String a = abi();
        return "armeabi-v7a".equals(a) || "armeabi".equals(a);
    }

    public static long totalRamMb(Context context) {
        ActivityManager.MemoryInfo info = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE)).getMemoryInfo(info);
        return info.totalMem / (1024L * 1024L);
    }

    public static long availableRamMb(Context context) {
        ActivityManager.MemoryInfo info = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE)).getMemoryInfo(info);
        return info.availMem / (1024L * 1024L);
    }

    public static int recommendedFps(Context context) {
        long ram = totalRamMb(context);
        if (ram <= 1024) return 30;
        if (ram <= 2048) return 45;
        return 60;
    }

    public static String summary(Context context) {
        return "ABI: " + abi()
                + "\nAndroid: " + Build.VERSION.RELEASE + " (API " + Build.VERSION.SDK_INT + ")"
                + "\nRAM: " + totalRamMb(context) + " MB"
                + "\nFPS recomendado: " + recommendedFps(context);
    }
}
