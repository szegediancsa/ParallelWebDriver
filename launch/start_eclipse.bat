@echo off
call env.bat

SET ARGS=

REM set the workspace
SET ARGS=%ARGS% -data %WORKSPACE%
REM set the JVM which runs eclipse
SET ARGS=%ARGS% -vm %JAVA_HOME%\jre\bin\javaw
REM refresh the projects from filesystem after startup
REM SET ARGS=%ARGS -refresh
REM any jvm args
REM SET ARGS=%ARGS% -vmargs

start %ECLIPSE_HOME%\eclipse %ARGS%
