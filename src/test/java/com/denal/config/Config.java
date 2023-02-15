package com.denal.config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@org.aeonbits.owner.Config.Sources(
        {"system:properties",
                "classpath:${env}.properties",
                "classpath:credentials.properties"})
public interface Config extends org.aeonbits.owner.Config {

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("baseURL")
    String baseUrl();

    @Key("appURL")
    String appUrl();

    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();

    @Key("project")
    String projectName();

    @Key("build")
    String buildName();

    @Key("name")
    String testName();

    @Key("localURL")
    String localUrl();

    @Key("platformName")
    String platformName();

    @Key("deviceName")
    String deviceName();

    @Key("platformVersion")
    String platformVersion();

    @Key("appLocalURL")
    String appLocalURL();

    @Key("appPath")
    String appPath();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();


}
