@echo off
cls
call env.bat

set HUB_URL=http://localhost:4444/grid/register
set CHROME_DRIVER_LOC=%TOOL%/chromedriver/chromedriver.exe
set SELENIUM_VERSION=2.47.1

cd %TOOL%\webdriver
start java -jar selenium-server-standalone-%SELENIUM_VERSION%.jar -role hub -port 4444
start java -jar selenium-server-standalone-%SELENIUM_VERSION%.jar -role node -nodeConfig nodeconfig.json

cmd /k ..\..\env.bat
