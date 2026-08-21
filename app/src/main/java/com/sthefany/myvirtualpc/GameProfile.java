package com.sthefany.myvirtualpc;

public final class GameProfile {
    public final String name;
    public final int fps;
    public final int renderScale;

    public GameProfile(String name, int fps, int renderScale) {
        this.name = name;
        this.fps = fps;
        this.renderScale = renderScale;
    }

    public static GameProfile forGame(String name, int recommendedFps) {
        if ("Brawl Stars".equals(name)) return new GameProfile(name, recommendedFps, 100);
        if ("Minecraft".equals(name)) return new GameProfile(name, Math.min(recommendedFps, 45), 80);
        return new GameProfile(name, Math.min(recommendedFps, 45), 85);
    }
}
