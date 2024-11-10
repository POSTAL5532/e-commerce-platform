@echo off

set COMMAND=java -jar ../inventory-service/build/libs/inventory-service.jar
set PORTS=8030

for %%P in (%PORTS%) do (
    start "Ecommerce inventory service - Instance %%P" cmd /c "%COMMAND% --server.port=%%P"
)

pause
