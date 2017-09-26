@echo off
cls
echo -------------------------
echo    Aplicacao Back End
echo -------------------------
set INPUT=

java -jar "C:\thiago_teste\dist\thiago_teste.jar" %INPUT%
set /p option=Fim. Presione uma tecla para finalizar