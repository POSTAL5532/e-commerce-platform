@echo off

set COMMAND=java -jar ../order-service/build/libs/order-service.jar
set PORTS=8020 8021

for %%P in (%PORTS%) do (
    start "Ecommerce orders service - Instance %%P" cmd /c "%COMMAND% --server.port=%%P"
)

pause
