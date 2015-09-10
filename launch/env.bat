@echo off
SET PROJECT_BASE=%~d0%~p0
REM SET PATH=C:\WINXP\system32;C:\WINXP;C:\WINXP\System32\Wbem;
SET PATH=C:\Windows\System32;C:\Windows;C:\Windows\System32\wbem;
SET PATH=%PATH%;%PROJECT_BASE%
SET TOOL=%PROJECT_BASE%\tools
SET PROJECT=%PROJECT_BASE%\projects
SET WORKSPACE=%PROJECT_BASE%\workspace

REM JDK 1.8.0_40
SET JAVA_HOME=%TOOL%\jdk
SET PATH=%PATH%;%JAVA_HOME%\bin
REM ECLIPSE MARS
SET ECLIPSE_HOME=%TOOL%\eclipse
SET PATH=%PATH%;%ECLIPSE_HOME%
REM IE DRIVER 2.47.0
SET IE_DRIVER_HOME=%TOOL%\iedriver
SET PATH=%PATH%;%IE_DRIVER_HOME%
REM CHROME DRIVER 2.16
SET CHROME_DRIVER_HOME=%TOOL%\chromedriver
SET PATH=%PATH%;%CHROME_DRIVER_HOME%
REM WEBDRIVER 2.47.1
SET WEBDRIVER_HOME=%TOOL%\webdriver
SET PATH=%PATH%;%SELENIUM_WEBDRIVER%