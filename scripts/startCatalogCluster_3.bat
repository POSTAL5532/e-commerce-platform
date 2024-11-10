@echo off

set COMMAND=java -jar ../catalog-service/build/libs/catalog-service.jar
set PORTS=8040 8041 8042

for %%P in (%PORTS%) do (
    start "Ecommerce catalog service - Instance %%P" cmd /c "%COMMAND% --server.port=%%P"
)

pause
