@echo off

set COMMAND=java -jar ../user-service/build/libs/user-service.jar
set PORTS=8010 8011 8012

for %%P in (%PORTS%) do (
    start "Ecommerce users service - Instance %%P" cmd /c "%COMMAND% --server.port=%%P"
)

pause
