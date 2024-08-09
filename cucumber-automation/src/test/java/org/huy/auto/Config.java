package org.huy.auto;

import java.time.Duration;

public class Config {
    public static Duration implicit = Duration.ofMillis(500);
    public static Duration explicit = Duration.ofSeconds(30);
    private Config() {
    }

}
