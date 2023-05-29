package io.dove.appium;

import lombok.Getter;

public enum DeviceInfo {
    PIXEL4_10_SIMULATOR("Android",
            "Pixel_4_API_29",
            "10",
            "",
            ""),
    IPHONE8_14_SIMULATOR("iOS",
            "iPhone8",
            "14.5",
            "",
            ""),
    IPHONE8_14("iOS",
            "iPhone 8",
            "14.8",
            "",
            ""),
    NOTE8_9("Android",
            "Galaxy Note8",
            "9",
            "",
            ""),
    NOTE20_11("Android",
            "Note20",
            "11",
            "",
            "");

    @Getter
    private final String platformName;
    @Getter
    private final String deviceName;
    @Getter
    private final String platformVersion;
    @Getter
    private final String udid;
    @Getter
    private final String url;

    DeviceInfo(String platformName, String deviceName, String platformVersion, String udid, String url) {
        this.platformName = platformName;
        this.platformVersion = platformVersion;
        this.deviceName = deviceName;
        this.udid = udid;
        this.url = url;
    }
}