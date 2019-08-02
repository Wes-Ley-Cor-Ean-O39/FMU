REM GCC_Desempacotador -install GCC_Desempacotador "C:\Program Files\Java\jre1.8.0_191" -Djava.class.path="C:\Users\Jose.Monteiro\Desktop\GCC_Desempacotador_22-02-2019\GCC_Desempacotador.jar" -start br.com.depacketizer.controller.MainStartService.class -err "C:\Program Files\Java\jre1.8.0_191" -Djava.class.path="C:\Users\Jose.Monteiro\Desktop\GCC_Desempacotador_22-02-2019\GCC_Desempacotador.log" 

cd /d C:\GCC\SERVICOS\APP\GCC_IMAG_RECORTE >> C:\GCC\SERVICOS\APP\GCC_IMAG_RECORTE\Install.log

START /W GCC_RECORTE_ASSINATURA.exe -install GCC_RECORTE_ASSINATURA "C:\Program Files (x86)\Java\jre1.8.0_201\bin\client\jvm.dll" -Dfile.encoding=ISO-8859-1 -Djava.class.path=C:\GCC\SERVICOS\APP\GCC_IMAG_RECORTE\GCC_RECORTE_ASSINATURA.jar -Xmx1024m -start br.com.gcc.imag.StartService -stop br.com.gcc.imag.StopService -err C:\GCC\SERVICOS\APP\GCC_IMAG_RECORTE\Install.log

Echo. Fim da Instalação! >> C:\GCC\SERVICOS\APP\GCC_IMAG_RECORTE\Install.log