# ClassLoader

----------------------------------------------------------------------------------------------

1). Site about Java ClassLoader (xpace.tistory.com/20)[http://xpace.tistory.com/20]

----------------------------------------------------------------------------------------------

클래스패스 설정

Java.exe가 인식할 수 있는 클래스패스에는 여러 가지가 있다. 그중에서 크게 java.exe가 실행하면서 로딩하는 bootclass와 java.lang.ClassLoader에 의해 로딩되는 일반 클래스가 있다.

Bootclass는 java.exe에 의해 로딩되면 JVM이 초기화되면서 필요한 클래스들로 이루어져 있다.System.getProperty("sun.boot.class.path")에서 확인할 수 있다.

JVM초기화 과정이 끝나면 java는 java.lang.ClassLoader를 통해서 어플리케이션 클래스들을 로딩한다. System.getProperty("java.class.path")에서 값을 확인할 수 있다.

Hello 클래스를 만들어 실행하는 방식을 알아보자.

> Hello.java를 컴파일하여 hello.jar파일 생성



1. Jar파일을 CLASSPATH환경변수에 설정

	> set CLASSPATH=hello.jar

	> java test.Hello



2. jar파일을 -cp 혹은 -classpath를 이용하여 직접 설정

	> java  -cp hello.jar  test.Hello

	> java  -classpath hello.jar test.Hello



3. Xbootclasspath에 hello.jar를 설정하여 실행하는 방법

	> java  -Xbootclasspath/p:hello.jar  test.Hello

	> java  -Xbootclasspath/a:hello.jar  test.Hello



4. JAVA_HOME/jre/lib/ext에 hello.jar를 복사하고 실행

	> copy hello.jar %JAVA_HOME%/jre/lib/ext/.

	> java  -Xbootclasspath/a:hello.jar  test.Hello

	* JAVA_HOME/jre/lib/ext의 파일들은 System.getProperty("java.class.path")에 표현되지 않는다.



5. -jar를 이용하여 바로 실행

	Jar파일내에 /META-INF/MANIFEST.MF 파일을 만들어 넣는다. 만약 존재하면 다음과 같이Main-Class: 속성을 추가한다.

	Manifest-Version: 1.0

	Main-Class: test.Hello

	그리고 다음과 같이 실행하면 test.Hello가 실행된다.

	> java  -jar hello.jar

	* -jar로 수행할 때 클래스 패스를 추가하려면

	Manifest-Version: 1.0

	Main-Class: test.Hello

	Class-Path: a.jar b.jar





-----------------------------------------------------------------------------------------

클래스 로딩 순서

만약 동일한 클래스가 여러곳에 설정되어있을 때 로딩되는 우선순위는 다음과 같다.

> Xbootclasspath에 설정된 파일  <- BOOT LOADER

> JAVA_HOME/jre/lib/ext에 있는 파일  <- EXT LOADER

> MENIFEST.MF의 Class-Path:에 설정된 클래스  <- APP LOADER

> -cp / -classpath에 설정된 파일                <- APP LOADER

> 환경변수 CLASSPATH에 설정된 파일              <- APP LOADER

   v Java -jar로 클래스를 실행한 경우 클래스패스를 추가하고자 하면JAVA_HOME/jre/lib/ext에 복사하거나 MENIFEST.MF의 Class-Path를 편집하는 방법이 있다.

   v App Loader를 위한 클래스 패스 설정은 같이 사용할 수 없고 그 중에서 하나를 선택해야 한다.




-----------------------------------------------------------------------------------------
클래스 로더 구조

	자바에서 모든 클래스로더는 java.lang.ClassLoader의 child 클래스이다. 클래스 로더에서 말하는 Parent/child 관계는 상속관계를 의미하는 것이 아니고 ClassLoader Chain에서 선행 node를 의미한다.
	
		java.lang.ClassLoader
		
		ExtClassLoader     AppClassLoader      SubAppClassLoader
		
		

-----------------------------------------------------------------------------------------
Application Server의 ClassLoader

	단순한 자바 Appliction의 클래스로더는 SystemClassLoader(BootClassLoader), ExtClassLoader, AppClassLoader의 3개층으로 구성된다.
	그러나 WAS는 Servlet 컨테이너와 그 아래의 각 ServletContext 를 위한 클래스 로더를 별도로 두고 있다.
	
		System            : JAVA_HOME/jre/lib/rt.jar .....
		
		Ext               : JAVA_HOME/jre/lib/ext/*.jar .....
		
		App               : CLASSPATH, Class-Path
		
		ServletContainer  : HttpServlet, Framework, JDBC Driver
		
		Servletcontext    : WAR, JSP, Servlet
		
	AppClassLoader와 ServletContainerClassLoader는 같이 사용되기도 하지만 보통 분리된다. Tomcat의 경우 ServletContainerClassLoader는 TOMCAT_HOME/common/lib 의 클래스들을 로딩한다.
	
	ServletContainerClassLoader나 ServletContextClassLoader는 WAS 벤더에 의해 구현되기 때문에 세부적인 상황이 버전에 따라 다를 수 있다.
	따라서 구체적으로 클래스를 어떻게 배치할 것인가는 해당 WAS의 구현을 확인해고 결정해야 한다.
	




-----------------------------------------------------------------------------------------
스팩과 클래스 로더

	WEB-INF/classes 와 WEB-INF/lib는 동일 로더에 의해 로딩되지만 로더는 WEB-INF/classes를 먼저 검색/로딩한다. (must)
	
	Servlet-API를 구현한 서블릿 컨테이너 클래스를 웹 어플리케이션이 Access 할 수 없도록 하라(recommend)
	
	WAR내부의 클래스를 컨테이너 클래스 패스의 클래스보다 먼저 로딩하라 (recommend)
	

	

-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------




