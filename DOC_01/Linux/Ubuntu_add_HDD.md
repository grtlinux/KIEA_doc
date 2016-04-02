----------------------------------------------------------------------------------------------------

#Virtual HDD addition to VirtualBox

[준비] 먼저 Virtual HDD(예. VB_HDD_200GB.vdi) 파일을 사용하려면
VitualBox의 해당 가상HOST의 저장소의 SATA HDD에 추가해야 한다.
가상HOST의 상태는 전원이 꺼짐 상태라야하는 건 당연합니다.
UUID 충돌에러가 발생하면 VB_ubuntu13_File2.vbox 파일을 에디터로
직접 수정하면 된다(기존 내용 삭제).
VirtualBox 관리자 > 파일 > 가상 미디어 관리자 > 하드 드라이브 탭을 선택하고
가상 디스크 명칭을 찾아서 제거한다.

-----------------------------------------------------------------------------------------------------
1). 현재 시스템의 디스크 파티션 정보 확인

		root@FileUbuntu2:~# sudo fdisk -l
		
		Disk /dev/sda: 214.7 GB, 214748364800 bytes
		255 heads, 63 sectors/track, 26108 cylinders, total 419430400 sectors
		Units = sectors of 1 * 512 = 512 bytes
		Sector size (logical/physical): 512 bytes / 512 bytes
		I/O size (minimum/optimal): 512 bytes / 512 bytes
		Disk identifier: 0x0000d1e5
	
		   Device Boot      Start         End      Blocks   Id  System
		/dev/sda1   *        2048   418383871   209190912   83  Linux
		/dev/sda2       418385918   419428351      521217    5  Extended
		/dev/sda5       418385920   419428351      521216   82  Linux swap / Solaris
	
		Disk /dev/sdb: 214.7 GB, 214748364800 bytes
		255 heads, 63 sectors/track, 26108 cylinders, total 419430400 sectors
		Units = sectors of 1 * 512 = 512 bytes
		Sector size (logical/physical): 512 bytes / 512 bytes
		I/O size (minimum/optimal): 512 bytes / 512 bytes
		Disk identifier: 0x00000000
	
		Disk /dev/sdb doesn't contain a valid partition table                  <--
	
		root@FileUbuntu2:~# 

-----------------------------------------------------------------------------------------------------
2). 디스크 파티션 생성

		root@FileUbuntu2:~# sudo fdisk /dev/sdb
	
		Device contains neither a valid DOS partition table, nor Sun, SGI or OSF disklabel
		Building a new DOS disklabel with disk identifier 0x68d8f85e.
		Changes will remain in memory only, until you decide to write them.
		After that, of course, the previous content won't be recoverable.

		Warning: invalid flag 0x0000 of partition table 4 will be corrected by w(rite)

		Command (m for help): m                                      <--
		Command action
		   a   toggle a bootable flag
		   b   edit bsd disklabel
		   c   toggle the dos compatibility flag
		   d   delete a partition
		   l   list known partition types
		   m   print this menu
		   n   add a new partition
		   o   create a new empty DOS partition table
		   p   print the partition table
		   q   quit without saving changes
		   s   create a new empty Sun disklabel
		   t   change a partition's system id
		   u   change display/entry units
		   v   verify the partition table
		   w   write table to disk and exit
		   x   extra functionality (experts only)

		Command (m for help): n                                     <--
		Partition type:
		   p   primary (0 primary, 0 extended, 4 free)
		   e   extended
		Select (default p): p                                     <--
		Partition number (1-4, default 1): 
		Using default value 1
		First sector (2048-419430399, default 2048): 
		Using default value 2048
		Last sector, +sectors or +size{K,M,G} (2048-419430399, default 419430399): 
		Using default value 419430399

		Command (m for help): w                                     <--
		The partition table has been altered!

		Calling ioctl() to re-read partition table.
		Syncing disks.
		
		root@FileUbuntu2:~# 


-----------------------------------------------------------------------------------------------------
3). 파티션 생성 확인

		root@FileUbuntu2:~# fdisk -l

		Disk /dev/sda: 214.7 GB, 214748364800 bytes
		255 heads, 63 sectors/track, 26108 cylinders, total 419430400 sectors
		Units = sectors of 1 * 512 = 512 bytes
		Sector size (logical/physical): 512 bytes / 512 bytes
		I/O size (minimum/optimal): 512 bytes / 512 bytes
		Disk identifier: 0x0000d1e5

		   Device Boot      Start         End      Blocks   Id  System
		/dev/sda1   *        2048   418383871   209190912   83  Linux
		/dev/sda2       418385918   419428351      521217    5  Extended
		/dev/sda5       418385920   419428351      521216   82  Linux swap / Solaris

		Disk /dev/sdb: 214.7 GB, 214748364800 bytes
		86 heads, 25 sectors/track, 195083 cylinders, total 419430400 sectors
		Units = sectors of 1 * 512 = 512 bytes
		Sector size (logical/physical): 512 bytes / 512 bytes
		I/O size (minimum/optimal): 512 bytes / 512 bytes
		Disk identifier: 0x68d8f85e

		   Device Boot      Start         End      Blocks   Id  System
		/dev/sdb1            2048   419430399   209714176   83  Linux                       <--
		
		root@FileUbuntu2:~# 


-----------------------------------------------------------------------------------------------------
4). 파티션 포멧

		root@FileUbuntu2:~# sudo mkfs.ext4 /dev/sdb1
		
		mke2fs 1.42.8 (20-Jun-2013)
		Filesystem label=
		OS type: Linux
		Block size=4096 (log=2)
		Fragment size=4096 (log=2)
		Stride=0 blocks, Stripe width=0 blocks
		13107200 inodes, 52428544 blocks
		2621427 blocks (5.00%) reserved for the super user
		First data block=0
		Maximum filesystem blocks=0
		1600 block groups
		32768 blocks per group, 32768 fragments per group
		8192 inodes per group
		Superblock backups stored on blocks: 
			32768, 98304, 163840, 229376, 294912, 819200, 884736, 1605632, 2654208, 
			4096000, 7962624, 11239424, 20480000, 23887872

		Allocating group tables: done                            
		Writing inode tables: done                            
		Creating journal (32768 blocks): done
		Writing superblocks and filesystem accounting information: done     

		root@FileUbuntu2:~# 


-----------------------------------------------------------------------------------------------------
5). 디스크 파티션 정보 확인

		root@FileUbuntu2:~# sudo fdisk -l

		Disk /dev/sda: 214.7 GB, 214748364800 bytes
		255 heads, 63 sectors/track, 26108 cylinders, total 419430400 sectors
		Units = sectors of 1 * 512 = 512 bytes
		Sector size (logical/physical): 512 bytes / 512 bytes
		I/O size (minimum/optimal): 512 bytes / 512 bytes
		Disk identifier: 0x0000d1e5

		   Device Boot      Start         End      Blocks   Id  System
		/dev/sda1   *        2048   418383871   209190912   83  Linux
		/dev/sda2       418385918   419428351      521217    5  Extended
		/dev/sda5       418385920   419428351      521216   82  Linux swap / Solaris

		Disk /dev/sdb: 214.7 GB, 214748364800 bytes
		86 heads, 25 sectors/track, 195083 cylinders, total 419430400 sectors
		Units = sectors of 1 * 512 = 512 bytes
		Sector size (logical/physical): 512 bytes / 512 bytes
		I/O size (minimum/optimal): 512 bytes / 512 bytes
		Disk identifier: 0x68d8f85e

		   Device Boot      Start         End      Blocks   Id  System
		/dev/sdb1            2048   419430399   209714176   83  Linux                        <--
		
		root@FileUbuntu2:~# 

-----------------------------------------------------------------------------------------------------
6). 파티션에 마운트 할 폴더 생성

		root@FileUbuntu2:~# sudo mkdir /data1
		root@FileUbuntu2:~# 

-----------------------------------------------------------------------------------------------------
7). 파티션 자동 마운트를 위한 파일 수정

		root@FileUbuntu2:~# sudo vi /etc/fstab

		# /etc/fstab: static file system information.
		#
		# Use 'blkid' to print the universally unique identifier for a
		# device; this may be used with UUID= as a more robust way to name devices
		# that works even if disks are added and removed. See fstab(5).
		#
		# <file system> <mount point>   <type>  <options>       <dump>  <pass>
		# / was on /dev/sda1 during installation
		UUID=d1208eb3-fd39-4a06-84b8-796428f87552 /               ext4    errors=remount-ro 0       1
		# swap was on /dev/sda5 during installation
		UUID=83532cd8-5fbc-4a30-8119-1f1d7a46d396 none            swap    sw              0       0

		# Extend data disk
		/dev/sdb1      /data1  ext4    defaults        0       1                                          <--

-----------------------------------------------------------------------------------------------------
8). fstab에 설정된 모든 파일시스템을 마운트하고 디스트 정보를 확인한다.

		root@FileUbuntu2:~# sudo mount -a
		root@FileUbuntu2:~# df -hT
	
		Filesystem     Type      Size  Used Avail Use% Mounted on
		/dev/sda1      ext4      197G   13G  174G   7% /
		none           tmpfs     4.0K     0  4.0K   0% /sys/fs/cgroup
		udev           devtmpfs  240M  4.0K  240M   1% /dev
		tmpfs          tmpfs      50M  396K   50M   1% /run
		none           tmpfs     5.0M     0  5.0M   0% /run/lock
		none           tmpfs     248M     0  248M   0% /run/shm
		none           tmpfs     100M     0  100M   0% /run/user
		/dev/sdb1      ext4      197G   60M  187G   1% /data1                   <--
	
		root@FileUbuntu2:~# 

-----------------------------------------------------------------------------------------------------
9). 언마운트하고 fstab 파일을 원래데로 수정한다.

		root@FileUbuntu2:~# umount /dev/sdb1
		root@FileUbuntu2:~# sudo vi /etc/fstab

		# /etc/fstab: static file system information.
		#
		# Use 'blkid' to print the universally unique identifier for a
		# device; this may be used with UUID= as a more robust way to name devices
		# that works even if disks are added and removed. See fstab(5).
		#
		# <file system> <mount point>   <type>  <options>       <dump>  <pass>
		# / was on /dev/sda1 during installation
		UUID=d1208eb3-fd39-4a06-84b8-796428f87552 /               ext4    errors=remount-ro 0       1
		# swap was on /dev/sda5 during installation
		UUID=83532cd8-5fbc-4a30-8119-1f1d7a46d396 none            swap    sw              0       0

		# Extend data disk
		# /dev/sdb1      /data1  ext4    defaults        0       1                                        <--

-----------------------------------------------------------------------------------------------------
10). 언마운트 상태를 확인한다.

		root@FileUbuntu2:~# df -hT

		Filesystem     Type      Size  Used Avail Use% Mounted on
		/dev/sda1      ext4      197G   13G  174G   7% /
		none           tmpfs     4.0K     0  4.0K   0% /sys/fs/cgroup
		udev           devtmpfs  240M  4.0K  240M   1% /dev
		tmpfs          tmpfs      50M  396K   50M   1% /run
		none           tmpfs     5.0M     0  5.0M   0% /run/lock
		none           tmpfs     248M     0  248M   0% /run/shm
		none           tmpfs     100M     0  100M   0% /run/user
	
		root@FileUbuntu2:~# 

-----------------------------------------------------------------------------------------------------
11). 가상HOST를 시스템을 종료하고 Virual HDD를 제거한다. 당근 [가상미디어 관리자]에서도 제거한다.

-----------------------------------------------------------------------------------------------------
12). 폴더 링크

		# ln -s /data1/FILES  ~/FILES

-----------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------
