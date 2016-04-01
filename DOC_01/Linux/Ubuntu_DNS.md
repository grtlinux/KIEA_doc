-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
	# ifconfig eth0 10.10.10.1/24     <- 본인 서버 IP

	# route add default gw 10.10.10.254    <- gateway
		Kernel IP routing table
		Destination     Gateway         Genmask         Flags Metric Ref    Use Iface
		0.0.0.0         10.10.10.254    0.0.0.0         UG    0      0        0 eth0
		10.10.10.0      0.0.0.0         255.255.255.0   U     0      0        0 eth0

-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
	root@DNSubuntu:~# ifconfig eth0
		eth0      Link encap:Ethernet  HWaddr 08:00:27:c5:a1:db  
				  inet addr:192.168.0.25  Bcast:192.168.0.255  Mask:255.255.255.0
				  inet6 addr: fe80::a00:27ff:fec5:a1db/64 Scope:Link
				  UP BROADCAST RUNNING MULTICAST  MTU:1500  Metric:1
				  RX packets:14757 errors:0 dropped:0 overruns:0 frame:0
				  TX packets:3854 errors:0 dropped:0 overruns:0 carrier:0
				  collisions:0 txqueuelen:1000 
				  RX bytes:984787 (984.7 KB)  TX bytes:714934 (714.9 KB)


-----------------------------------------------------------------------------
	root@DNSubuntu:~# route -n
		Kernel IP routing table
		Destination     Gateway         Genmask         Flags Metric Ref    Use Iface
		0.0.0.0         192.168.0.1     0.0.0.0         UG    0      0        0 eth0
		192.168.0.0     0.0.0.0         255.255.255.0   U     0      0        0 eth0

-----------------------------------------------------------------------------

	root@DNSubuntu:~# ls -al /etc/bind
		total 60
		drwxr-sr-x   2 root bind 4096  4월  1 17:44 .
		drwxr-xr-x 100 root root 4096  4월  1 17:35 ..
		-rw-r--r--   1 root root 2389 10월  8  2013 bind.keys
		-rw-r--r--   1 root root  237 10월  8  2013 db.0
		-rw-r--r--   1 root root  271 10월  8  2013 db.127
		-rw-r--r--   1 root root  237 10월  8  2013 db.255
		-rw-r--r--   1 root root  353 10월  8  2013 db.empty
		-rw-r--r--   1 root root  270 10월  8  2013 db.local
		-rw-r--r--   1 root root 3048 10월  8  2013 db.root
		-rw-r--r--   1 root bind  463 10월  8  2013 named.conf
		-rw-r--r--   1 root bind  490 10월  8  2013 named.conf.default-zones
		-rw-r--r--   1 root bind  165 10월  8  2013 named.conf.local
		-rw-r--r--   1 root bind  882  4월  1 17:40 named.conf.options
		-rw-r-----   1 bind bind   77  4월  1 11:35 rndc.key
		-rw-r--r--   1 root root 1317 10월  8  2013 zones.rfc1918


-----------------------------------------------------------------------------

	root@DNSubuntu:~# cat /etc/bind/named.conf.options
		options {
			directory "/var/cache/bind";

			// If there is a firewall between you and nameservers you want
			// to talk to, you may need to fix the firewall to allow multiple
			// ports to talk.  See http://www.kb.cert.org/vuls/id/800113

			// If your ISP provided one or more IP addresses for stable 
			// nameservers, you probably want to use them as forwarders.  
			// Uncomment the following block, and insert the addresses replacing 
			// the all-0's placeholder.

			forwarders {
				8.8.8.8;
			};

			//========================================================================
			// If BIND logs error messages about the root key being expired,
			// you will need to update your keys.  See https://www.isc.org/bind-keys
			//========================================================================
			dnssec-validation auto;

			auth-nxdomain no;    # conform to RFC1035
			listen-on-v6 { any; };
		};


-----------------------------------------------------------------------------

	root@DNSubuntu:~# /etc/init.d/bind9 restart
		 * Stopping domain name service... bind9      waiting for pid 2742 to die
																				  [ OK ]
		 * Starting domain name service... bind9                                  [ OK ] 

-----------------------------------------------------------------------------

	root@DNSubuntu:~# netstat -naptu | grep named
		tcp        0      0 192.168.0.25:53         0.0.0.0:*               LISTEN      2861/named      
		tcp        0      0 127.0.0.1:53            0.0.0.0:*               LISTEN      2861/named      
		tcp        0      0 127.0.0.1:953           0.0.0.0:*               LISTEN      2861/named      
		tcp6       0      0 :::53                   :::*                    LISTEN      2861/named      
		tcp6       0      0 ::1:953                 :::*                    LISTEN      2861/named      
		udp        0      0 192.168.0.25:53         0.0.0.0:*                           2861/named      
		udp        0      0 127.0.0.1:53            0.0.0.0:*                           2861/named      
		udp6       0      0 :::53                   :::*                                2861/named      


-----------------------------------------------------------------------------

	root@DNSubuntu:~# dig -x 127.0.0.1

		; <<>> DiG 9.9.3-rpz2+rl.13214.22-P2-Ubuntu-1:9.9.3.dfsg.P2-4ubuntu1 <<>> -x 127.0.0.1
		;; global options: +cmd
		;; Got answer:
		;; ->>HEADER<<- opcode: QUERY, status: NXDOMAIN, id: 57408
		;; flags: qr aa rd ra; QUERY: 1, ANSWER: 0, AUTHORITY: 1, ADDITIONAL: 1

		;; OPT PSEUDOSECTION:
		; EDNS: version: 0, flags:; udp: 4096
		;; QUESTION SECTION:
		;1.0.0.127.in-addr.arpa.		IN	PTR

		;; AUTHORITY SECTION:
		127.IN-ADDR.ARPA.	86400	IN	SOA	127.IN-ADDR.ARPA. . 0 28800 7200 604800 86400

		;; Query time: 5 msec
		;; SERVER: 168.126.63.1#53(168.126.63.1)
		;; WHEN: Fri Apr 01 18:00:10 KST 2016
		;; MSG SIZE  rcvd: 102



-----------------------------------------------------------------------------

	root@DNSubuntu:~# dig naver.com

		; <<>> DiG 9.9.3-rpz2+rl.13214.22-P2-Ubuntu-1:9.9.3.dfsg.P2-4ubuntu1 <<>> naver.com
		;; global options: +cmd
		;; Got answer:
		;; ->>HEADER<<- opcode: QUERY, status: NOERROR, id: 45101
		;; flags: qr rd ra; QUERY: 1, ANSWER: 4, AUTHORITY: 3, ADDITIONAL: 4

		;; OPT PSEUDOSECTION:
		; EDNS: version: 0, flags:; udp: 4096
		;; QUESTION SECTION:
		;naver.com.			IN	A

		;; ANSWER SECTION:
		naver.com.		249	IN	A	125.209.222.142
		naver.com.		249	IN	A	202.179.177.22
		naver.com.		249	IN	A	202.179.177.21
		naver.com.		249	IN	A	125.209.222.141

		;; AUTHORITY SECTION:
		naver.com.		64616	IN	NS	ns3.naver.com.
		naver.com.		64616	IN	NS	ns1.naver.com.
		naver.com.		64616	IN	NS	ns2.naver.com.

		;; ADDITIONAL SECTION:
		ns1.naver.com.		34179	IN	A	125.209.248.6
		ns2.naver.com.		34179	IN	A	125.209.249.6
		ns3.naver.com.		34179	IN	A	61.247.195.250

		;; Query time: 9 msec
		;; SERVER: 168.126.63.1#53(168.126.63.1)
		;; WHEN: Fri Apr 01 18:00:27 KST 2016
		;; MSG SIZE  rcvd: 204


-----------------------------------------------------------------------------

	root@DNSubuntu:~# dig google.com

		; <<>> DiG 9.9.3-rpz2+rl.13214.22-P2-Ubuntu-1:9.9.3.dfsg.P2-4ubuntu1 <<>> google.com
		;; global options: +cmd
		;; Got answer:
		;; ->>HEADER<<- opcode: QUERY, status: NOERROR, id: 57040
		;; flags: qr rd ra; QUERY: 1, ANSWER: 16, AUTHORITY: 4, ADDITIONAL: 5

		;; OPT PSEUDOSECTION:
		; EDNS: version: 0, flags:; udp: 4096
		;; QUESTION SECTION:
		;google.com.			IN	A

		;; ANSWER SECTION:
		google.com.		246	IN	A	59.18.34.212
		google.com.		246	IN	A	59.18.34.216
		google.com.		246	IN	A	59.18.34.226
		google.com.		246	IN	A	59.18.34.251
		google.com.		246	IN	A	59.18.34.247
		google.com.		246	IN	A	59.18.34.227
		google.com.		246	IN	A	59.18.34.231
		google.com.		246	IN	A	59.18.34.237
		google.com.		246	IN	A	59.18.34.221
		google.com.		246	IN	A	59.18.34.242
		google.com.		246	IN	A	59.18.34.241
		google.com.		246	IN	A	59.18.34.246
		google.com.		246	IN	A	59.18.34.217
		google.com.		246	IN	A	59.18.34.236
		google.com.		246	IN	A	59.18.34.222
		google.com.		246	IN	A	59.18.34.232

		;; AUTHORITY SECTION:
		google.com.		28567	IN	NS	ns3.google.com.
		google.com.		28567	IN	NS	ns2.google.com.
		google.com.		28567	IN	NS	ns4.google.com.
		google.com.		28567	IN	NS	ns1.google.com.

		;; ADDITIONAL SECTION:
		ns1.google.com.		201367	IN	A	216.239.32.10
		ns2.google.com.		201367	IN	A	216.239.34.10
		ns3.google.com.		201367	IN	A	216.239.36.10
		ns4.google.com.		201367	IN	A	216.239.38.10

		;; Query time: 7 msec
		;; SERVER: 168.126.63.1#53(168.126.63.1)
		;; WHEN: Fri Apr 01 18:00:44 KST 2016
		;; MSG SIZE  rcvd: 431


-----------------------------------------------------------------------------

	root@DNSubuntu:~# dig tain.co.kr

		; <<>> DiG 9.9.3-rpz2+rl.13214.22-P2-Ubuntu-1:9.9.3.dfsg.P2-4ubuntu1 <<>> tain.co.kr
		;; global options: +cmd
		;; Got answer:
		;; ->>HEADER<<- opcode: QUERY, status: NOERROR, id: 58192
		;; flags: qr rd ra; QUERY: 1, ANSWER: 1, AUTHORITY: 2, ADDITIONAL: 3

		;; OPT PSEUDOSECTION:
		; EDNS: version: 0, flags:; udp: 4096
		;; QUESTION SECTION:
		;tain.co.kr.			IN	A

		;; ANSWER SECTION:
		tain.co.kr.		300	IN	A	112.175.88.195

		;; AUTHORITY SECTION:
		tain.co.kr.		300	IN	NS	ns2.withsystems.co.kr.
		tain.co.kr.		300	IN	NS	ns1.withsystems.co.kr.

		;; ADDITIONAL SECTION:
		ns1.withsystems.co.kr.	75515	IN	A	61.96.208.226
		ns2.withsystems.co.kr.	75515	IN	A	61.96.208.227

		;; Query time: 14 msec
		;; SERVER: 168.126.63.1#53(168.126.63.1)
		;; WHEN: Fri Apr 01 18:01:05 KST 2016
		;; MSG SIZE  rcvd: 135


-----------------------------------------------------------------------------

	root@DNSubuntu:~# dig tain.com

		; <<>> DiG 9.9.3-rpz2+rl.13214.22-P2-Ubuntu-1:9.9.3.dfsg.P2-4ubuntu1 <<>> tain.com
		;; global options: +cmd
		;; Got answer:
		;; ->>HEADER<<- opcode: QUERY, status: NOERROR, id: 65220
		;; flags: qr rd ra; QUERY: 1, ANSWER: 1, AUTHORITY: 5, ADDITIONAL: 10

		;; OPT PSEUDOSECTION:
		; EDNS: version: 0, flags:; udp: 4096
		;; QUESTION SECTION:
		;tain.com.			IN	A

		;; ANSWER SECTION:
		tain.com.		30	IN	A	193.33.139.150

		;; AUTHORITY SECTION:
		tain.com.		35072	IN	NS	ns2.tain.com.
		tain.com.		35072	IN	NS	ns1.tain.com.
		tain.com.		35072	IN	NS	ns3.tain.com.
		tain.com.		35072	IN	NS	ns5.tain.com.
		tain.com.		35072	IN	NS	ns4.tain.com.

		;; ADDITIONAL SECTION:
		ns1.tain.com.		35072	IN	A	193.33.138.200
		ns1.tain.com.		35072	IN	AAAA	2a02:750:babe:767:d01::100
		ns2.tain.com.		35072	IN	A	193.33.139.200
		ns2.tain.com.		35072	IN	AAAA	2a02:750:babe:767:d02::100
		ns3.tain.com.		35072	IN	A	91.200.196.111
		ns3.tain.com.		35072	IN	AAAA	2a00:1cc0:cafe:fade:d01::100
		ns4.tain.com.		35072	IN	A	91.200.197.111
		ns4.tain.com.		35072	IN	AAAA	2a00:1cc0:cafe:fade:d02::100
		ns5.tain.com.		121472	IN	A	94.247.175.111

		;; Query time: 341 msec
		;; SERVER: 168.126.63.1#53(168.126.63.1)
		;; WHEN: Fri Apr 01 18:01:20 KST 2016
		;; MSG SIZE  rcvd: 335


-----------------------------------------------------------------------------

	root@DNSubuntu:~# dig tain.net

		; <<>> DiG 9.9.3-rpz2+rl.13214.22-P2-Ubuntu-1:9.9.3.dfsg.P2-4ubuntu1 <<>> tain.net
		;; global options: +cmd
		;; Got answer:
		;; ->>HEADER<<- opcode: QUERY, status: NOERROR, id: 28289
		;; flags: qr rd ra; QUERY: 1, ANSWER: 1, AUTHORITY: 2, ADDITIONAL: 3

		;; OPT PSEUDOSECTION:
		; EDNS: version: 0, flags:; udp: 4096
		;; QUESTION SECTION:
		;tain.net.			IN	A

		;; ANSWER SECTION:
		tain.net.		300	IN	A	141.8.225.63

		;; AUTHORITY SECTION:
		tain.net.		172800	IN	NS	ns2.interimnameserver.com.
		tain.net.		172800	IN	NS	ns1.interimnameserver.com.

		;; ADDITIONAL SECTION:
		ns1.interimnameserver.com. 31520 IN	A	209.99.64.18
		ns2.interimnameserver.com. 31520 IN	A	209.99.65.18

		;; Query time: 176 msec
		;; SERVER: 168.126.63.1#53(168.126.63.1)
		;; WHEN: Fri Apr 01 18:01:43 KST 2016
		;; MSG SIZE  rcvd: 142


-----------------------------------------------------------------------------

	root@DNSubuntu:~# dig tain.org

		; <<>> DiG 9.9.3-rpz2+rl.13214.22-P2-Ubuntu-1:9.9.3.dfsg.P2-4ubuntu1 <<>> tain.org
		;; global options: +cmd
		;; Got answer:
		;; ->>HEADER<<- opcode: QUERY, status: NOERROR, id: 14912
		;; flags: qr rd ra; QUERY: 1, ANSWER: 0, AUTHORITY: 1, ADDITIONAL: 1

		;; OPT PSEUDOSECTION:
		; EDNS: version: 0, flags:; udp: 4096
		;; QUESTION SECTION:
		;tain.org.			IN	A

		;; AUTHORITY SECTION:
		tain.org.		10800	IN	SOA	a.dns.gandi.net. hostmaster.gandi.net. 1402617468 10800 3600 604800 10800

		;; Query time: 152 msec
		;; SERVER: 168.126.63.1#53(168.126.63.1)
		;; WHEN: Fri Apr 01 18:02:07 KST 2016
		;; MSG SIZE  rcvd: 99


-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------


