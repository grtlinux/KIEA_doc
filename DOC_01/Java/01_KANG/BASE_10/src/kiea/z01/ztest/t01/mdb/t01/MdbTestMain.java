/* Copyright (c) 2008-2014, KangSeok
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * Neither the name of the HSQL Development Group nor the names of its
 * contributors may be used to endorse or promote products derived from this
 * software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL HSQL DEVELOPMENT GROUP, HSQLDB.ORG,
 * OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package kiea.z01.ztest.t01.mdb.t01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Properties;

import kiea.kr.co.tain.base.Flag;

/**
 * MdbTestMain Ŭ����
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: ICA Information and Communication </p>
 *
 * @name    MdbTestMain
 * @author  ����
 * @version 1.0, 2013/06/21
 * @since   jdk1.6.0_45
 *
 *
 * -
 * Class.forName("org.gjt.mm.mysql.Driver");
 * c = DriverManager.getConnection("jdbc:mysql://localhost/tspc?useUnicode=true&characterEncoding=euckr", "root", "321");
 *
 * import java.sql.Connection;
 * import java.sql.DriverManager;
 * import java.sql.PreparedStatement;
 * import java.sql.ResultSet;
 * import java.sql.SQLException;
 * import java.sql.Statement;
 * import java.util.Properties;
 *
 * public class DBConnection {
 *     private String DB_URL = "Jdbc:Odbc:Testdata";
 *     private String DB_USER = "test";
 *     private String DB_PASSWORD= "test";
 *     Connection conn = null;
 *
 *     public Connection getConnection() {
 *
 *         try {
 *             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 *         } catch (ClassNotFoundException e1) {
 *             e1.printStackTrace();
 *         }
 *
 *         try {
 *             Properties props = new Properties();
 *             props.put("charSet", "8859_1" );
 *             props.put("user", DB_USER);
 *             props.put("password", DB_PASSWORD);
 *             conn = DriverManager.getConnection(DB_URL, props);
 *         } catch (SQLException e) {
 *             e.printStackTrace();
 *         }
 *
 *         return conn;
 *     }
 *
 *
 * �׸��� ���⼭�� Properties�� ����Ͽ��µ� �̰� mdb�� �ѱ۹��������̴�.
 * mdb�� �ѱ��� 8859_1�� ����ϱ� ������ �ѱ��� �ȱ����� �޾ƿ��� ���ؼ���
 * Connection�� ������ �� charSet�� 8859_1�� ������ �־�� �Ѵ�
 *
 *
 *         DBConnection dbConn = new DBConnection();
 *         Connection conn = null;
 *         PreparedStatement psmt = null;
 *         ResultSet rs = null;
 *
 *         try {
 *             String sql = " SELECT username FROM member ";
 *             conn = dbConn.getConnection();
 *             psmt = conn.prepareStatement(sql);
 *             rs = psmt.executeQuery();
 *
 *             while (rs.next()) {
 *                 String username = new String(rs.getString("username").getBytes("8859_1"), "euc-kr");
 *             }
 *
 *         } catch(Exception e) {
 *             e.printStackTrace();
 *         } finally {
 *             dbConn.disConnection(rs,psmt, conn);
 *         }
 *
 * ���� Connection�� ����ؼ� Select ������ ������ �κ��̴�.
 * import���� �ʿ���� �κ��� �����ȴ�. ��������δ� 14��° ���θ� ���� �ȴ�.
 * �����̳� ���ڴ� �������� �ѱ��� ��� ���Ŀ�ؼǿ��� ����� �� Access����
 * �ѱ��� 8859_1(ISO-8859-1)�� ����߱� ������ ���⼭�� �޾ƿ� ��Ʈ���� 14��
 * ����ó�� ���ڵ��� ������ �־�� �޾ƿ� �ѱ��� ������ �ʰ� ǥ�õȴ�.
 * (Ư���ϰԵ� ������ encoding�� euc-kr�̵� utf-8�̵� �����ϰ� ��ó��
 * euc-kr�� ���ڵ��� ���־�� �ѱ��� ������ �ʴ´�.)
 *
 * INSERT�� UPDATE�� �ڹ��ʿ��� mdb�� �ѱ��� �������� �����ϰ� ���ڵ� Ÿ����
 * �����ؼ� �־��־�� �Ѵ�. �翬�� ���ڵ��� �ݴ�� �ؼ�...
 *
 *         String str = new String("�ѱ�".getBytes("euc-kr"), "ISO-8859-1");
 *
 * ��ó�� �ϸ� �ȴ�. ( ISO-8859-1�� 8859_1�� ������ ���ڵ��̴�.)
 *
 * ��� mdb�� ���� �ѱ��� �ְ� ���� ���� ������״ϱ� �� 2������ �޼����
 * ���� �����θ� ���Ұ��̴�.
 *
 * --------------------------------------------------------------------
 * [ ODBC ���� ]
 * 
 *     64��Ʈ ������ Microsoft Windows �ü���� ���� ������ Microsoft ������ �����ͺ��̽� ����(ODBC) ������ ���� ������
 *     ����(Odbcad32.exe)�� ���� �Ǿ� �ֽ��ϴ�.
 * 
 *        - 32��Ʈ ������ Odbcad32.exe ������ %systemdrive%\Windows\SysWoW64 ������ �ֽ��ϴ�.
 *        - 64��Ʈ ������ Odbcad32.exe ������ %systemdrive%\Windows\System32 ������ �ֽ��ϴ�.
 *
 *     Odbcad32.exe ���Ͽ��� ������ ���� ������ ������ �����̸�(DSN)�� ǥ���մϴ�.
 * 
 *        - �ý���DSN
 *        - �����DSN
 *
 * [ 64��Ʈ ���α׷����� �����Ͽ� ����ϴ� ��� ]
 *     
 *     64��Ʈ ODBC ����̹� ���α׷��� ������� Access Driver�� �߰����Ѿ� �Ѵ�.
 *     
 *        - AccessDatabaseEngine.exe     : 32��Ʈ ����
 *        - AccessDatabaseEngine_X64.exe : 64��Ʈ ����
 *     
 *     Microsoft Access Database Engine 2010 ����� ���� ��Ű��
 *     
 *     ���)
 *     1. Microsoft Office 2007 ��ġ�� �����Ѵ�.
 *     2. AccessDatabaseEngine_X64.exe �����Ͽ� ��ġ�Ѵ�.
 *     3. Microsoft Office 2007 ��ġ�Ѵ�.
 *
 */

public class MdbTestMain
{
	private static void test01_create()
	{
		if (Flag.TRUE) {
			try {

				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

				Properties props = new Properties();
				props.put("charSet", "EUC-KR");
				props.put("user", "kang");
				props.put("password", "seok");

				Connection db = DriverManager.getConnection("jdbc:odbc:mdbKANG01", props);

				StringBuffer sb = new StringBuffer();
				sb.append(" CREATE TABLE imsi                    ");
				sb.append(" (                                    ");
				sb.append("     ID        int primary key        ");
				sb.append("     , NAME    varchar(255)           ");
				sb.append("     , CONTENT varchar(255)           ");
				sb.append(" )                                    ");
				
				Statement statement = db.createStatement();
				int ret = statement.executeUpdate(sb.toString());
				
				System.out.println("ret = " + ret);

				db.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void test01_insert()
	{
		if (Flag.TRUE) {
			try {

				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

				Properties props = new Properties();
				props.put("charSet", "EUC-KR");
				props.put("user", "kang");
				props.put("password", "seok");

				Connection db = DriverManager.getConnection("jdbc:odbc:kangKang01", props);

				StringBuffer sb = new StringBuffer();
				sb.append(" INSERT INTO kang                     ");
				sb.append(" (                                    ");
				sb.append("     ID                               ");
				sb.append("     , NAME                           ");
				sb.append("     , CONTENT                        ");
				sb.append(" )                                    ");
				sb.append(" VALUES                               ");
				sb.append(" (                                    ");
				sb.append("     9                                ");
				sb.append("     , 'TABLE'                        ");
				sb.append("     , '�̰��� INSERT�� ����.'");
				sb.append(" )                                    ");
				
				Statement statement = db.createStatement();
				int ret = statement.executeUpdate(sb.toString());
				
				System.out.println("ret = " + ret);

				db.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void test01_update()
	{
		if (Flag.TRUE) {
			try {

				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

				Properties props = new Properties();
				props.put("charSet", "EUC-KR");
				props.put("user", "kang");
				props.put("password", "seok");

				Connection db = DriverManager.getConnection("jdbc:odbc:kangKang01", props);

				StringBuffer sb = new StringBuffer();
				sb.append(" UPDATE            ");
				sb.append("     kang          ");
				sb.append(" SET               ");
				sb.append("     NAME = 'KANG'");
				sb.append(" WHERE             ");
				sb.append("     ID = 3        ");
				
				Statement statement = db.createStatement();
				int ret = statement.executeUpdate(sb.toString());
				
				System.out.println("ret = " + ret);

				db.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void test01_delete()
	{
		if (Flag.TRUE) {
			try {

				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

				Properties props = new Properties();
				props.put("charSet", "EUC-KR");
				props.put("user", "kang");
				props.put("password", "seok");

				Connection db = DriverManager.getConnection("jdbc:odbc:kangKang01", props);

				StringBuffer sb = new StringBuffer();
				sb.append(" DELETE FROM       ");
				sb.append("     kang          ");
				sb.append(" WHERE             ");
				sb.append("     ID = 9        ");
				
				Statement statement = db.createStatement();
				int ret = statement.executeUpdate(sb.toString());
				
				System.out.println("ret = " + ret);

				db.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void test01_select()
	{
		if (!Flag.TRUE) {
			try {

				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

				Properties props = new Properties();
				props.put("charSet", "8859_1");
				props.put("user", "kang");
				props.put("password", "seok");

				Connection db = DriverManager.getConnection("jdbc:odbc:kangKang01", props);

				Statement statement = db.createStatement();
				ResultSet rs = statement.executeQuery("select * from kang"); // query
				
				ResultSetMetaData rsMeta = rs.getMetaData();
				int columnCount = rsMeta.getColumnCount();
				
				int iRowNum = 0;
				while (rs.next()) {
					iRowNum ++;
					System.out.println("Row Number [" + iRowNum + "]");

					for (int i=1; i <= columnCount; i++) {
						String strColumnName = rsMeta.getColumnName(i);
						String strText = rs.getString(i);

						strText = new String(strText.getBytes("ISO-8859-1"), "EUC-KR");
						System.out.println("\t[" + i + "] [" + strColumnName + "=" + strText + "]");
					}
				}

				db.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (!Flag.TRUE) {
			try {

				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

				Properties props = new Properties();
				//props.put("charSet", "8859_1");
				props.put("charSet", "EUC-KR");
				props.put("user", "kang");
				props.put("password", "seok");

				Connection db = DriverManager.getConnection("jdbc:odbc:kangKang01", props);

				Statement statement = db.createStatement();
				ResultSet rs = statement.executeQuery("select * from kang"); // query
				
				ResultSetMetaData rsMeta = rs.getMetaData();
				int columnCount = rsMeta.getColumnCount();
				
				int iRowNum = 0;
				while (rs.next()) {
					iRowNum ++;
					System.out.println("Row Number [" + iRowNum + "]");

					for (int i=1; i <= columnCount; i++) {
						String strColumnName = rsMeta.getColumnName(i);
						String strText = rs.getString(i);

						//strText = new String(strText.getBytes("ISO-8859-1"), "EUC-KR");
						System.out.println("\t[" + i + "] [" + strColumnName + "=" + strText + "]");
					}
				}

				db.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (!Flag.TRUE) {
			try {

				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

				Properties props = new Properties();
				props.put("charSet", "8859_1");
				props.put("user", "kang");
				props.put("password", "seok");

				Connection db = DriverManager.getConnection("jdbc:odbc:kangBookCatalog", props);

				Statement statement = db.createStatement();
				ResultSet rs = statement.executeQuery("select * from BookList");  // query
				
				ResultSetMetaData rsMeta = rs.getMetaData();
				int columnCount = rsMeta.getColumnCount();

				int iRowNum = 0;
				while (rs.next()) {
					iRowNum ++;
					System.out.println("Row Number [" + iRowNum + "]");

					for (int i=1; i <= columnCount; i++) {
						String strColumnName = rsMeta.getColumnName(i);
						String strText = rs.getString(i);

						System.out.println("\t[" + i + "] [" + strColumnName + "=" + strText + "]");
					}
				}

				db.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (Flag.TRUE) {
			try {

				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

				Properties props = new Properties();
				props.put("charSet", "EUC-KR");
				props.put("user", "kang");
				props.put("password", "seok");

				/*
				 * TODO : 2014.07.25 : ���� DNS ���� ���� mdb ������ ���� ����ó���Ѵ�. 
				 */
				Connection db = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)}; DBQ=D:/KANG/WORK/workspace7/KIEA_02/src/kiea/z01/ztest/t01/mdb/db/KANG01.mdb", props);

				Statement statement = db.createStatement();
				ResultSet rs = statement.executeQuery("select * from kang"); // query
				
				ResultSetMetaData rsMeta = rs.getMetaData();
				int columnCount = rsMeta.getColumnCount();
				
				int iRowNum = 0;
				while (rs.next()) {
					iRowNum ++;
					System.out.println("Row Number [" + iRowNum + "]");

					for (int i=1; i <= columnCount; i++) {
						String strColumnName = rsMeta.getColumnName(i);
						String strText = rs.getString(i);

						System.out.println("\t[" + i + "] [" + strColumnName + "=" + strText + "]");
					}
				}

				db.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void test01_drop()
	{
		if (Flag.TRUE) {
			try {

				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

				Properties props = new Properties();
				props.put("charSet", "EUC-KR");
				props.put("user", "kang");
				props.put("password", "seok");

				Connection db = DriverManager.getConnection("jdbc:odbc:kangKang01", props);

				StringBuffer sb = new StringBuffer();
				sb.append(" DROP TABLE imsi      ");
				
				Statement statement = db.createStatement();
				int ret = statement.executeUpdate(sb.toString());
				
				System.out.println("ret = " + ret);

				db.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	////////////////////////////////////////////////////////////////
	
	public static void main(String[] args)
	{
		if (Flag.TRUE) test01_create();
		if (!Flag.TRUE) test01_insert();
		if (!Flag.TRUE) test01_update();
		if (!Flag.TRUE) test01_delete();
		if (!Flag.TRUE) test01_select();
		if (!Flag.TRUE) test01_drop();
	}
}
