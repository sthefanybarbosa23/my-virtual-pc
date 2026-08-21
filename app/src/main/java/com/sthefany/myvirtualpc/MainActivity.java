package com.sthefany.myvirtualpc;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.Button;
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
        info.setText("Android 11 (API 30)\nHost: ARMv7 / 32-bit\n\nRuntime experimental\nAvatar World • Minecraft • Brawl Stars");
        info.setTextColor(Color.LTGRAY);
        info.setTextSize(18);
        info.setGravity(Gravity.CENTER);
        info.setPadding(0, 24, 0, 0);

        TextView status = new TextView(this);
        status.setText(DeviceCapabilities.summary(this));
        status.setTextColor(Color.GRAY);
        status.setGravity(Gravity.CENTER);
        status.setPadding(0, 24, 0, 16);

        Button profiles = new Button(this);
        profiles.setText("Ver perfis de desempenho");
        profiles.setOnClickListener(v -> {
            int fps = DeviceCapabilities.recommendedFps(this);
            status.setText("PERFIS\n\n" + profile("Avatar World", fps) + "\n\n" + profile("Minecraft", fps) + "\n\n" + profile("Brawl Stars", fps));
        });

        root.addView(title);
        root.addView(info);
        root.addView(status);
        root.addView(profiles);
        setContentView(root);
    }

    private String profile(String game, int fps) {
        GameProfile p = GameProfile.forGame(game, fps);
        return p.name + ": " + p.fps + " FPS • escala " + p.renderScale + "%";
    }
}
