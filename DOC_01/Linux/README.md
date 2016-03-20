#Linux
-----------------------------------------
This is a description of subcomment.

	$ cat /etc/group
		.....
		users:x:100:kang
		.....

	$ cat /etc/passwd
		.....
		kang:x:1001:100:Desc Kiea Kang:/home/kang:/bin/bash
		.....

	$ cat /etc/shadow
		.....
		kang:$6$vHjL0....E0:16880:0:99999:7:::
		.....

	$ cat /etc/login.defs
		.....
		# /etc/login.defs - Configuration control definitions for the login package.
		#
		# This is a temporary situation: setting these variables will soon
		# move to /etc/default/useradd and the variables will then be
		# no more supported
		MAIL_DIR        /var/mail
		#MAIL_FILE      .mail
		
		#
		# Enable logging and display of /var/log/faillog login failure info.
		# This option conflicts with the pam_tally PAM module.
		#
		FAILLOG_ENAB		yes
		
		#
		# Enable display of unknown usernames when login failures are recorded.
		#
		# WARNING: Unknown usernames may become world readable. 
		# See #290803 and #298773 for details about how this could become a security
		# concern
		LOG_UNKFAIL_ENAB	no
		
		#
		# Enable logging of successful logins
		#
		LOG_OK_LOGINS		no
		
		#
		# Enable "syslog" logging of su activity - in addition to sulog file logging.
		# SYSLOG_SG_ENAB does the same for newgrp and sg.
		#
		SYSLOG_SU_ENAB		yes
		SYSLOG_SG_ENAB		yes
		
		#
		# If defined, all su activity is logged to this file.
		#
		#SULOG_FILE	/var/log/sulog
		
		#
		# If defined, file which maps tty line to TERM environment parameter.
		# Each line of the file is in a format something like "vt100  tty01".
		#
		#TTYTYPE_FILE	/etc/ttytype
		
		#
		# If defined, login failures will be logged here in a utmp format
		# last, when invoked as lastb, will read /var/log/btmp, so...
		#
		FTMP_FILE	/var/log/btmp
		
		#
		# If defined, the command name to display when running "su -".  For
		# example, if this is defined as "su" then a "ps" will display the
		# command is "-su".  If not defined, then "ps" would display the
		# name of the shell actually being run, e.g. something like "-sh".
		#
		SU_NAME		su
		
		#
		# If defined, file which inhibits all the usual chatter during the login
		# sequence.  If a full pathname, then hushed mode will be enabled if the
		# user's name or shell are found in the file.  If not a full pathname, then
		# hushed mode will be enabled if the file exists in the user's home directory.
		#
		HUSHLOGIN_FILE	.hushlogin
		#HUSHLOGIN_FILE	/etc/hushlogins
		
		#
		# *REQUIRED*  The default PATH settings, for superuser and normal users.
		#
		# (they are minimal, add the rest in the shell startup files)
		ENV_SUPATH	PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin
		ENV_PATH	PATH=/usr/local/bin:/usr/bin:/bin:/usr/local/games:/usr/games
		
		#
		# Terminal permissions
		#
		#	TTYGROUP	Login tty will be assigned this group ownership.
		#	TTYPERM		Login tty will be set to this permission.
		#
		# If you have a "write" program which is "setgid" to a special group
		# which owns the terminals, define TTYGROUP to the group number and
		# TTYPERM to 0620.  Otherwise leave TTYGROUP commented out and assign
		# TTYPERM to either 622 or 600.
		#
		# In Debian /usr/bin/bsd-write or similar programs are setgid tty
		# However, the default and recommended value for TTYPERM is still 0600
		# to not allow anyone to write to anyone else console or terminal
		
		# Users can still allow other people to write them by issuing 
		# the "mesg y" command.
		
		TTYGROUP	tty
		TTYPERM		0600
		
		#
		# Login configuration initializations:
		#
		#	ERASECHAR	Terminal ERASE character ('\010' = backspace).
		#	KILLCHAR	Terminal KILL character ('\025' = CTRL/U).
		#	UMASK		Default "umask" value.
		#
		# The ERASECHAR and KILLCHAR are used only on System V machines.
		# 
		# UMASK usage is discouraged because it catches only some classes of user
		# entries to system, in fact only those made through login(1), while setting
		# umask in shell rc file will catch also logins through su, cron, ssh etc.
		#
		# At the same time, using shell rc to set umask won't catch entries which use
		# non-shell executables in place of login shell, like /usr/sbin/pppd for "ppp"
		# user and alike.
		#
		# Therefore the use of pam_umask is recommended as the solution which
		# catches all these cases on PAM-enabled systems.
		# 
		# This avoids the confusion created by having the umask set
		# in two different places -- in login.defs and shell rc files (i.e.
		# /etc/profile).
		#
		# For discussion, see #314539 and #248150 as well as the thread starting at
		# http://lists.debian.org/debian-devel/2005/06/msg01598.html
		#
		# Prefix these values with "0" to get octal, "0x" to get hexadecimal.
		#
		ERASECHAR	0177
		KILLCHAR	025
		# 022 is the "historical" value in Debian for UMASK when it was used
		# 027, or even 077, could be considered better for privacy
		# There is no One True Answer here : each sysadmin must make up his/her
		# mind.
		#UMASK		022
		
		#
		# Password aging controls:
		#
		#	PASS_MAX_DAYS	Maximum number of days a password may be used.
		#	PASS_MIN_DAYS	Minimum number of days allowed between password changes.
		#	PASS_WARN_AGE	Number of days warning given before a password expires.
		#
		PASS_MAX_DAYS	99999
		PASS_MIN_DAYS	0
		PASS_WARN_AGE	7
		
		#
		# Min/max values for automatic uid selection in useradd
		#
		UID_MIN			 1000
		UID_MAX			60000
		# System accounts
		#SYS_UID_MIN		  100
		#SYS_UID_MAX		  999
		
		#
		# Min/max values for automatic gid selection in groupadd
		#
		GID_MIN			 1000
		GID_MAX			60000
		# System accounts
		#SYS_GID_MIN		  100
		#SYS_GID_MAX		  999
		
		#
		# Max number of login retries if password is bad. This will most likely be
		# overriden by PAM, since the default pam_unix module has it's own built
		# in of 3 retries. However, this is a safe fallback in case you are using
		# an authentication module that does not enforce PAM_MAXTRIES.
		#
		LOGIN_RETRIES		5
		
		#
		# Max time in seconds for login
		#
		LOGIN_TIMEOUT		60
		
		#
		# Which fields may be changed by regular users using chfn - use
		# any combination of letters "frwh" (full name, room number, work
		# phone, home phone).  If not defined, no changes are allowed.
		# For backward compatibility, "yes" = "rwh" and "no" = "frwh".
		# 
		CHFN_RESTRICT		rwh
		
		#
		# Should login be allowed if we can't cd to the home directory?
		# Default in no.
		#
		DEFAULT_HOME	yes
		
		#
		# If defined, this command is run when removing a user.
		# It should remove any at/cron/print jobs etc. owned by
		# the user to be removed (passed as the first argument).
		#
		#USERDEL_CMD	/usr/sbin/userdel_local
		
		#
		# This enables userdel to remove user groups if no members exist.
		#
		# Other former uses of this variable such as setting the umask when
		# user==primary group are not used in PAM environments, thus in Debian
		#
		USERGROUPS_ENAB yes
		.....
				
		#
		# If defined, either full pathname of a file containing device names or
		# a ":" delimited list of device names.  Root logins will be allowed only
		# upon these devices.
		#
		# This variable is used by login and su.
		#
		#CONSOLE	/etc/consoles
		#CONSOLE	console:tty01:tty02:tty03:tty04
		
		#
		# List of groups to add to the user's supplementary group set
		# when logging in on the console (as determined by the CONSOLE
		# setting).  Default is none.
		#
		# Use with caution - it is possible for users to gain permanent
		# access to these groups, even when not logged in on the console.
		# How to do it is left as an exercise for the reader...
		#
		# This variable is used by login and su.
		#
		#CONSOLE_GROUPS		floppy:audio:cdrom
		
		#
		# If set to "yes", new passwords will be encrypted using the MD5-based
		# algorithm compatible with the one used by recent releases of FreeBSD.
		# It supports passwords of unlimited length and longer salt strings.
		# Set to "no" if you need to copy encrypted passwords to other systems
		# which don't understand the new algorithm.  Default is "no".
		#
		# This variable is deprecated. You should use ENCRYPT_METHOD.
		#
		#MD5_CRYPT_ENAB	no
		
		#
		# If set to MD5 , MD5-based algorithm will be used for encrypting password
		# If set to SHA256, SHA256-based algorithm will be used for encrypting password
		# If set to SHA512, SHA512-based algorithm will be used for encrypting password
		# If set to DES, DES-based algorithm will be used for encrypting password (default)
		# Overrides the MD5_CRYPT_ENAB option
		#
		# Note: It is recommended to use a value consistent with
		# the PAM modules configuration.
		#
		ENCRYPT_METHOD SHA512
		
		.....

	$ cat /etc/default/useradd
		.....
		# Default values for useradd(8)
		#
		# The SHELL variable specifies the default login shell on your
		# system.
		# Similar to DHSELL in adduser. However, we use "sh" here because
		# useradd is a low level utility and should be as general
		# as possible
		SHELL=/bin/sh
		#
		# The default group for users
		# 100=users on Debian systems
		# Same as USERS_GID in adduser
		# This argument is used when the -n flag is specified.
		# The default behavior (when -n and -g are not specified) is to create a
		# primary user group with the same name as the user being added to the
		# system.
		# GROUP=100
		#
		# The default home directory. Same as DHOME for adduser
		# HOME=/home
		#
		# The number of days after a password expires until the account 
		# is permanently disabled
		# INACTIVE=-1
		#
		# The default expire date
		# EXPIRE=
		#
		# The SKEL variable specifies the directory containing "skeletal" user
		# files; in other words, files such as a sample .profile that will be
		# copied to the new user's home directory when it is created.
		# SKEL=/etc/skel
		#
		# Defines whether the mail spool should be created while
		# creating the account
		# CREATE_MAIL_SPOOL=yes
		
		.....

You have a choice of the below.

 * 1. Hello
 * 2. World.

-----------------------------------------

1. [naver-http://www.naver.com](http://www.naver.com)

-----------------------------------------
END.
