@echo off

::----------------------------------------------
:DRIVE_NAME

	set DRIVE_NAME=N
	echo "DRIVE_NAME = %DRIVE_NAME%"

::----------------------------------------------
:CHECK_DRIVE

	if exist %DRIVE_NAME%:  goto SUBST_DRIVE_DEL
	
	goto SUBST_DRIVE_SET

::----------------------------------------------
:SUBST_DRIVE_SET

	subst %DRIVE_NAME%: .\%DRIVE_NAME%_subst
	echo "CMD SET : subst %DRIVE_NAME%: .\%DRIVE_NAME%_subst"
	
	goto END

::----------------------------------------------
:SUBST_DRIVE_DEL

	subst %DRIVE_NAME%: /d
	echo "CMD DEL : subst %DRIVE_NAME%: /d"
	
	goto END

::----------------------------------------------
:END

	timeout 2
	::pause
