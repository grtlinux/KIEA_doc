@echo off
if "%1" == "" goto SHOWMSG
if "%2" == "dhcp" goto DHCP
if "%2" == "" goto SHOWMSG
if "%3" == "" goto SHOWMSG
if "%4" == "" goto SHOWMSG
if "%5" == "" goto SHOWMSG

echo netsh interface ip set address name="로컬 영역 연결" source=static addr=%2 mask=%3 gateway=%4 gwmetric=1 > d:\ipChange\%1.bat
echo netsh interface ip set dns name="로컬 영역 연결" source=static addr=%5 register=primary >> d:\ipChange\%1.bat
if not "%6" == "" echo netsh interface ip add dns name="로컬 영역 연결" addr=%6 index=2 >> d:\ipChange\%1.bat
if not "%7" == "" echo netsh interface ip set wins name="로컬 영역 연결" source=static addr=%7 >> d:\ipChange\%1.bat

goto EXEC

:DHCP
echo netsh interface ip set address name="로컬 영역 연결" source=dhcp > d:\ipChange\%1.bat
echo netsh interface ip set dns name="로컬 영역 연결" source=dhcp >> d:\ipChange\%1.bat
goto EXEC

:SHOWMSG
cls
echo -------------------------------------------------
echo    makeip 이름 ip mask gateway dns1 dns2 wins
echo -------------------------------------------------
echo    이름      : 저장할 파일명
echo    ip        : ip address
echo              : dhcp (자동설정일 경우)
echo    mask      : subnet mask
echo    gateway   : gateway
echo    dns1      : 기본 dns
echo    dns2      : 보조 dns (option)
echo    wins      : 기본 wins (option)
echo -------------------------------------------------
echo                       made by sbkyun@lycos.co.kr
echo.
echo.
goto END

:EXEC
echo 설정한 ip를 설정합니다.
echo.
echo.
pause
d:\ipChange\%1.bat


:END
