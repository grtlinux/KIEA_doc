# Fedora 서버 IP 변경

--------------------------------------------------------------------------------------------------
1. 확인

	# ip addr

		1: lo: <LOOPBACK,UP,LOWER_UP> mtu 65536 qdisc noqueue state UNKNOWN group default
			link/loopback 00:00:00:00:00:00 brd  00:00:00:00:00:00
			inet 127.0.0.1/8 scope host lo
				valid_lft forever preferred_lft forever
			inet6 ::1/128 scope host
				valid_lft forever preferred_lft forever
		2: enp0s3: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc fq_codel state UP group default qlen 1000
			link/ether 08:00:27:77:77:a9 brd ff:ff:ff:ff:ff:ff
			inet 192.168.0.28/24 brd 192.168.0.255 scope global dynamic enp0s3
				valid_lft 863935sec preferred_lft 863935sec
			inet6 fe80::a00:27ff:fe77:77a9/64 scope link
				valid_lft forever preferred_lft forever

	# 


--------------------------------------------------------------------------------------------------
2. enp0s3 을 내린다.

	# ifdown enp0s3
	
		Device 'enp0s3' successfully disconnected.
	
	#
	
--------------------------------------------------------------------------------------------------
3. 다시 확인

	# ip addr

		1: lo: <LOOPBACK,UP,LOWER_UP> mtu 65536 qdisc noqueue state UNKNOWN group default
			link/loopback 00:00:00:00:00:00 brd  00:00:00:00:00:00
			inet 127.0.0.1/8 scope host lo
				valid_lft forever preferred_lft forever
			inet6 ::1/128 scope host
				valid_lft forever preferred_lft forever
		2: enp0s3: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc fq_codel state UP group default qlen 1000
			link/ether 08:00:27:77:77:a9 brd ff:ff:ff:ff:ff:ff

	# 

--------------------------------------------------------------------------------------------------
4. 인터페이스 목록 확인

	# ll /etc/sysconfig/network-scripts/ifcfg*
	
		-rw-r--r--. 1 root root 289 Apr  3 05:12  /etc/sysconfig/network-scripts/ifcfg-enp0s3
		-rw-r--r--. 1 root root 254 Apr  6  2015  /etc/sysconfig/network-scripts/ifcfg-lo
	
	# cat /etc/sysconfig/network-scripts/ifcfg-lo
	
		DEVICE=lo
		IPADDR=127.0.0.1
		NETMASK=255.0.0.0
		NETWORK=127.0.0.0
		# If you're having problems with gated making 127.0.0.0/8 a martian,
		# you can change this to something else (255.255.255.255, for example)
		BROADCAST=127.255.255.255
		ONBOOT=yes
		NAME=loopback
	
	# cat /etc/sysconfig/network-scripts/ifcfg-enp0s3
	
		HWADDR=08:00:27:77:77:A9
		TYPE=Ethernet
		BOOTPROTO=dhcp
		DEFROUTE=yes
		PEERDNS=yes
		PEERROUTES=yes
		IPV4_FAILURE_FATAL=no
		IPV6INIT=yes
		IPV6_AUTOCONF=yes
		IPV6_DEFROUTE=yes
		IPV6_PEERDNS=yes
		IPV6_PEERROUTES=yes
		IPV6_FAILURE_FATAL=no
		NAME=enp0s3
		UUID=8d7a9s03-ad1f-44b2-b353-6c323ac86eac
		ONBOOT=yes
	
	#

--------------------------------------------------------------------------------------------------
5. grub 수정과 적용

	# vi /etc/default/grub
	
		GRUB_TIMEOUT=5
		GRUB_DISTRIBUTOR="$(sed 's, release .*$,,g' /etc/system-release)"
		GRUB_DEFAULT=saved
		GRUB_DISABLE_SUBMENU=true
		GRUB_TERMINAL_OUTPUT="console"
		GRUB_CMDLINE_LINUX="rd.lvm.lv=fedora/root rd.lvm.lv=fedora/swap rhgb quiet net.ifnames=0 biosdevname=0"   <---
		GRUB_DISABLE_RECOVERY="true"
	
	# grub2-mkconfig -o /boot/grub2/grub.cfg
	
		Generating grub configuration file ...
		Found linux image: /boot/vmlinuz-4.2.3-300.fc23.x86_64
		Found initrd image: /boot/initramfs-4.2.3-300.fc23.x86_64.img
		Found linux image: /boot/vmlinuz-0-rescure-c4aab9b63d184155941325d8afa634de
		Found initrd image: /boot/initramfs-0-rescure-c4aab9b63d184155941325d8afa634de.img
		done
	
	#
	
--------------------------------------------------------------------------------------------------
6. reboot과 확인

	# shutdown -r now
	
	# mv /etc/sysconfig/network-scripts/ifcfg-enp0s3 ~
	
	#
	
--------------------------------------------------------------------------------------------------
7. 유동 IP 세팅

	# vi /etc/sysconfig/network-scripts/ifcfg-eth0
	
		DEVICE=eth0
		BOOTPROTO=dhcp
		ONBOOT=yes
	
	#
	
--------------------------------------------------------------------------------------------------
8. 고정 IP 세팅

	# vi /etc/sysconfig/network-scripts/ifcfg-eth0

		DEVICE=eth0
		ONBOOT=yes
		
		# BOOTPROTO=dhcp
		
		BOOTPROTO=static
		IPADDR=192.168.0.28
		NETMASK=255.255.255.0
		NETWORK=192.168.0.0
		GATEWAY=192.168.0.1
		
		DNS1=168.126.63.1
		DNS2=168.126.63.2
	
	#
	
--------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------








