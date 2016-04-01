#Linux
-----------------------------------------
scp remote copy

	$ scp ~/FILES/file kang@192.168.0.24:~/FILES/file2
	
	$ scp -rv ~/FILES kang@192.168.0.24:~/FILES
	
-----------------------------------------
Linux DNS Server Setting

	[http://happy_jhyo.blog.me/70171647409]
	[http://blog.naver.com/kimjs6873/220655902780]
	[http://stop2y.blog.me/220100629808]
	[http://yyman.tistory.com/808]
	[http://cafe.naver.com/linuxlog/253]

-----------------------------------------
Linux Samba Server Setting

	[http://blog.naver.com/zobbily/100056459407]
	[http://blog.naver.com/raining178/100122061515]
	[http://syung1104.blog.me/220132369942]
	[http://cafe.naver.com/openrt/5476]            <- sshfs
	
	
	
-----------------------------------------
ubuntu root passwd

	$ sudo passwd root
		[sudo] password for kang:
		Enter new UNIX password:
		Retype new UNIX password:
		passwd: password updated successfully
	$ su -
		Password:
	#
	
-----------------------------------------
ubuntu root permission

	# vi /etc/ssh/sshd_config
		.....
		PermitRootLogin no         <- 수정함
		.....
	
	# service sshd restart
		Stopping sshd:            [  OK  ]
		Starting sshd:            [  OK  ]
	
-----------------------------------------
ubuntu 한글 display

	$ export LANG=ko_KR.EUC-KR
	# export LANG=ko_KR.EUC-KR
	
	$ cat .bash_profile
		# .bash_profile
		if [ -f "$HOME/.profile" ]; then
			. "$HOME/.profile"
		fi
		
		export LANG=ko_KR.EUC-KR
	
	
-----------------------------------------

/etc/network/interfaces

	$ cat /etc/network/interfaces
		auto lo
		iface lo inet loopback
		
		auto eth0
		#iface eth0 inet dhcp
		iface eth0 inet static
		address   192.168.0.21
		netmask   255.255.255.0
		network   192.168.0.0
		broadcast 192.168.0.255
		gateway   192.168.0.1
		
		dns-nameserver 168.126.63.1 168.126.63.2
		
		auto eth1
		iface eth1 inet dhcp
		
		auto eth2
		iface eth2 inet dhcp
		
		auto ath0
		iface ath0 inet dhcp
		
		auto wlan0
		iface wlan0 inet dhcp

-----------------------------------------
This is a description of subcomment.

/etc/group

	$ cat /etc/group
		.....
		users:x:100:kang
		.....

/etc/passwd

	$ cat /etc/passwd
		.....
		kang:x:1001:100:Desc Kiea Kang:/home/kang:/bin/bash
		.....

/etc/shadow

	$ cat /etc/shadow
		.....
		kang:$6$vHjL0....E0:16880:0:99999:7:::
		.....

/etc/login.defs

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

/etc/default/useradd

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

/root/.profile

	$ cat /root/.profile

		# ~/.profile: executed by Bourne-compatible login shells.

		if [ `hostname` == "bt5-forensics" ]; then
			echo ""
		        echo "[*] Disabling Automount for Forensics Mode"
		        /usr/bin/gconftool-2 --set /apps/nautilus/preferences/media_automount --type bool false 2> /dev/null
		       echo "[*] UDEV mounts in Read Only mode"
		       cp /opt/files/99-fstab.rules /etc/udev/rules.d/
		       /usr/sbin/rebuildfstab
		fi

		if [ `hostname` == "bt5-stealth" ]; then
		        echo ""
		        echo "[*] BackTrack Stealth Mode, Networking Disabled"
		fi


		if [ "$BASH" ]; then
		  if [ -f ~/.bashrc ]; then
		    . ~/.bashrc
		  fi
		fi

		mesg n

/root/.bashrc

	$ cat /root/.bashrc

		# ~/.bashrc: executed by bash(1) for non-login shells.
		# see /usr/share/doc/bash/examples/startup-files (in the package bash-doc)
		# for examples

		# If not running interactively, don't do anything
		if [[ -n "$PS1" ]]; then

		# don't put duplicate lines in the history. See bash(1) for more options
		# ... or force ignoredups and ignorespace
		HISTCONTROL=ignoredups:ignorespace

		# append to the history file, don't overwrite it
		shopt -s histappend

		# for setting history length see HISTSIZE and HISTFILESIZE in bash(1)
		HISTSIZE=1000
		HISTFILESIZE=2000

		# check the window size after each command and, if necessary,
		# update the values of LINES and COLUMNS.
		shopt -s checkwinsize

		# make less more friendly for non-text input files, see lesspipe(1)
		[ -x /usr/bin/lesspipe ] && eval "$(SHELL=/bin/sh lesspipe)"

		# set variable identifying the chroot you work in (used in the prompt below)
		if [ -z "$debian_chroot" ] && [ -r /etc/debian_chroot ]; then
		    debian_chroot=$(cat /etc/debian_chroot)
		fi

		# set a fancy prompt (non-color, unless we know we "want" color)
		case "$TERM" in
		    xterm-color) color_prompt=yes;;
		esac

		# uncomment for a colored prompt, if the terminal has the capability; turned
		# off by default to not distract the user: the focus in a terminal window
		# should be on the output of commands, not on the prompt
		force_color_prompt=yes

		if [ -n "$force_color_prompt" ]; then
		    if [ -x /usr/bin/tput ] && tput setaf 1 >&/dev/null; then
			# We have color support; assume it's compliant with Ecma-48
			# (ISO/IEC-6429). (Lack of such support is extremely rare, and such
			# a case would tend to support setf rather than setaf.)
			color_prompt=yes
		    else
			color_prompt=
		    fi
		fi

		if [ "$color_prompt" = yes ]; then
		    PS1='${debian_chroot:+($debian_chroot)}\[\033[01;31m\]\u@\h\[\033[00m\]:\[\033[01;34m\]\w\[\033[00m\]\$ '
		else
		    PS1='${debian_chroot:+($debian_chroot)}\u@\h:\w\$ '
		fi
		unset color_prompt force_color_prompt

		# If this is an xterm set the title to user@host:dir
		case "$TERM" in
		xterm*|rxvt*)
		    PS1="\[\e]0;${debian_chroot:+($debian_chroot)}\u@\h: \w\a\]$PS1"
		    ;;
		*)
		    ;;
		esac

		# enable color support of ls and also add handy aliases
		if [ -x /usr/bin/dircolors ]; then
		    test -r ~/.dircolors && eval "$(dircolors -b ~/.dircolors)" || eval "$(dircolors -b)"
		    alias ls='ls --color=auto'
		    #alias dir='dir --color=auto'
		    #alias vdir='vdir --color=auto'

		    alias grep='grep --color=auto'
		    alias fgrep='fgrep --color=auto'
		    alias egrep='egrep --color=auto'
		fi

		# some more ls aliases
		alias ll='ls -alF'
		alias la='ls -A'
		alias l='ls -CF'

		# Alias definitions.
		# You may want to put all your additions into a separate file like
		# ~/.bash_aliases, instead of adding them here directly.
		# See /usr/share/doc/bash-doc/examples in the bash-doc package.

		if [ -f ~/.bash_aliases ]; then
		    . ~/.bash_aliases
		fi

		# enable programmable completion features (you don't need to enable
		# this, if it's already enabled in /etc/bash.bashrc and /etc/profile
		# sources /etc/bash.bashrc).
		#if [ -f /etc/bash_completion ] && ! shopt -oq posix; then
		#    . /etc/bash_completion
		#fi
		  export HISTCONTROL=ignoreboth
		fi

		export PATH=$PATH:/etc/alternatives/gem-bin

	$

-----------------------------------------

You have a choice of the below.

 * 1. Hello
 * 2. World.

-----------------------------------------

1. [naver-http://www.naver.com](http://www.naver.com)

-----------------------------------------
END.
