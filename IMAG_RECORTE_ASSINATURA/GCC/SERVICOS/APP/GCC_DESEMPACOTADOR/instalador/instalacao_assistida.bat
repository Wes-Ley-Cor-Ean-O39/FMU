@echo off
set /p nome=Coloque o nome do servico:%=%

set /p jvm=Coloque o caminho do arquivo jvm.dll (Ex.: C:\Program Files (x86)\Java\jre6\bin\client\jvm.dll):%=%

set /p jar=Coloque o caminho do jar (Ex.: D:\GccDesempacotador\GccDesempacotador.jar):%=%

set /p logErr=Coloque o caminho e nome do log de inicializacao do servico (Ex.: D:\GccDesempacotador\GccDesempacotador.log):%=%

copy /Y JavaService.exe %nome%.exe

set comando=%nome% -install %nome% %jvm% -Djava.class.path=%jar% -start br.com.depacketizer.controller.Main -err %logErr%

echo %nome% -uninstall %nome% > "desinstalar-%nome%.bat"
echo %comando% > "instalar-%nome%.bat"

@echo on
@echo %comando%

start %comando%

pause