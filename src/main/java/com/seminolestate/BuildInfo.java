package com.seminolestate;

import java.time.Instant;

public final class BuildInfo {
    private BuildInfo() {}

    public static String summary() {
        String javaVersion = System.getProperty("java.version");
        String os = System.getProperty("os.name") + " " + System.getProperty("os.version");
        String user = System.getProperty("user.name");
        return "Runtime: Java " + javaVersion + " | OS: " + os + " | User: " + user + " | Time: " + Instant.now();
    }
}
