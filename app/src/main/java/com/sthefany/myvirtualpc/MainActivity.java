package com.sthefany.myvirtualpc;

import android.app.Activity;
import android.os.Bundle;
import android.os.Build;
import android.view.Gravity;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    @Override public void onCreate(Bundle state) {
        super.onCreate(state);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER);
        root.setPadding(32, 32, 32, 32);
        root.setBackgroundColor(Color.rgb(18, 18, 24));

        TextView title = new TextView(this);
        title.setText("My Virtual PC");
        title.setTextColor(Color.WHITE);
        title.setTextSize(28);
        title.setGravity(Gravity.CENTER);

        TextView info = new TextView(this);
        info.setText("Perfil: Android 11 (API 30)\\n\\nHost: ARMv7 / 32-bit\\nGuest planejado: ARM64 / 64-bit\\n\\nAvatar World • Minecraft • Brawl Stars");
        info.setTextColor(Color.LTGRAY);
        info.setTextSize(18);
        info.setGravity(Gravity.CENTER);
        info.setPadding(0, 24, 0, 0);

        TextView status = new TextView(this);
        status.setText("Compatibilidade: " + Build.CPU_ABI + "\\nAndroid do aparelho: " + Build.VERSION.RELEASE + "\\n\\nO perfil ARM64 é experimental e só poderá executar código 64-bit se o hardware/runtime do aparelho oferecer suporte.");
        status.setTextColor(Color.GRAY);
        status.setGravity(Gravity.CENTER);
        status.setPadding(0, 24, 0, 0);

        root.addView(title);
        root.addView(info);
        root.addView(status);
        setContentView(root);
    }
}
