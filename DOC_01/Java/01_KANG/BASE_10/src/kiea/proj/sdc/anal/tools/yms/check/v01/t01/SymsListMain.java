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

package kiea.proj.sdc.anal.tools.yms.check.v01.t01;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import kiea.kr.co.tain.base.Flag;
import kiea.proj.sdc.anal.common.Connection;
import oracle.jdbc.OracleConnection;

/**
 * @author KangSeok
 * @date 2014. 8. 6.
 * @file_name SymsListMain.java
 *
 */
public class SymsListMain
{
	///////////////////////////////////////////////////////////////////////////

	private static void test01()
	{
		if (Flag.TRUE) {
			try {
				String[] tableNames = {
						"SYMS_DEFECT_COMP_MASTER     ",
						"SYMS_INFRA_EES_JOB_MASTER   ",
						"SYMS_LYA_ANAL_FILE_STATUS   ",
						"SYMS_LYA_ANAL_REPORT        ",
						"SYMS_LYA_APP_CODE           ",
						"SYMS_LYA_APP_USER_LOG       ",
						"SYMS_LYA_JOB_ANAL_METHOD    ",
						"SYMS_LYA_JOB_FAIL_CODE      ",
						"SYMS_LYA_JOB_GLASS_GROUP    ",
						"SYMS_LYA_JOB_MASTER         ",
						"SYMS_LYA_JOB_PROCESS        ",
						"SYMS_LYA_JOB_PRODUCT        ",
						"SYMS_LYA_JOB_PRODUCT_GRP    ",
						"SYMS_LYA_JOB_STEPID         ",
						"SYMS_LYA_JOB_USER_RULE      ",
						"SYMS_LYA_LOG_INFO           ",
						"SYMS_LYA_MAIL_OPTION        ",
						"SYMS_LYA_MAP_LAYOUT         ",
						"SYMS_LYA_MST_SOURCE_FILE    ",
						"SYMS_LYA_QAF_RULE_BASE      ",
						"SYMS_LYA_QAF_WORKFLOW_LIST  ",
						"SYMS_LYA_QFOCUS_MASTER      ",
						"SYMS_LYA_REPORT_SCRAP       ",
						"SYMS_LYA_RULE_DELAYTIME     ",
						"SYMS_LYA_RULE_DELAYTIME_QAF ",
						"SYMS_LYA_RULE_MASTER        ",
						"SYMS_LYA_RULE_MASTER_QAF    ",
						"SYMS_LYA_RULE_VALUE         ",
						"SYMS_LYA_RULE_VALUE_QAF     ",
						"SYMS_LYA_SUMMARY_REPORT     ",
						"SYMS_LYA_SYS_LOG_INFO       ",
						"SYMS_LYA_USER_CLUSTER_MAP   ",
						"SYMS_LYA_USER_MASTER        ",
						"SYMS_LYA_USER_OPTION        ",
						"SYMS_LYA_USER_OPTION_DCOMP  ",
						"SYMS_LYA_USER_OPTION_INFRA  ",
						"SYMS_LYA_USER_OPTION_MURA   ",
						"SYMS_LYA_USER_OPTION_PRODUCT",
				};
				
				OracleConnection conn = Connection.getOracleConnection();
				Statement stmt = conn.createStatement();
				
				for (String tableName : tableNames) {
					String query;
					query = String.format("SELECT * FROM %s WHERE ROWNUM <= 10", tableName);
					
					if (Flag.TRUE) {
						ResultSet resultSet = stmt.executeQuery(query);
						ResultSetMetaData metaData = resultSet.getMetaData();
						
						System.out.println(String.format("\n\n\n---------- table :  %s  ------------\n", tableName));
						
						/*
						 * row data
						 */
						for (int i=0; i < 10000 && resultSet.next(); i++) {
							
							StringBuffer sb = new StringBuffer();
							sb.append(String.format("(%4d)   ", i));
							
							for (int col=1; col <= metaData.getColumnCount(); col++) {
								sb.append("\t").append(resultSet.getString(col));
							}
							
							System.out.println(sb.toString());
						}

						System.out.println();
						
						/* 
						 * meta data
						 */
						for (int i=1; i <= metaData.getColumnCount(); i++) {
							System.out.println(String.format("\t%2d) %-30s %-30s [%s]", i, metaData.getColumnName(i), metaData.getColumnLabel(i), metaData.getColumnClassName(i)));
						}
					}
				}
				
				conn.close();
				if (Flag.TRUE) System.out.println("##### OK!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void test02()
	{
		if (Flag.TRUE) {
			try {
				String[][] tableNames = {
						{ "SYMS_DEFECT_COMP_MASTER          ", "DEFECT PATTERN �м� MASTER ���̺�(���� �ش� �м� �̼���)", },
						{ "SYMS_LYA_ANAL_FILE_STATUS        ", "�м� ��� CSV ���� ��밡�� ���� �̷� ���� ���̺�", },
						{ "SYMS_LYA_ANAL_REPORT             ", "�м� JOB_ID �� ����Ʈ ���� DXP ���� �̷� ����", },
						{ "SYMS_LYA_APP_CODE                ", "���ν��� / UI���� ����ϴ� �������� ���̺�", },
						{ "SYMS_LYA_APP_USER_LOG            ", "APP ���� �̷°������̺�", },
						{ "SYMS_LYA_JOB_ANAL_METHOD         ", "JOB_ID�� �м���� �̷°������̺�", },
						{ "SYMS_LYA_JOB_FAIL_CODE           ", "JOB_ID�� �ҷ��ڵ� �̷°������̺�", },
						{ "SYMS_LYA_JOB_GLASS_GROUP         ", "", },
						{ "SYMS_LYA_JOB_MASTER              ", "�м� MASTER ���̺�", },
						{ "SYMS_LYA_JOB_PROCESS             ", "�����м��� �߻��ϴ� PROCESS_ID ���� ���̺�", },
						{ "SYMS_LYA_JOB_PRODUCT             ", "JOB_ID�� PRODUCT �������̺�(���� �̻��)", },
						{ "SYMS_LYA_JOB_PRODUCT_GRP         ", "JOB_ID�� PRODUCT_GRP �������̺�", },
						{ "SYMS_LYA_JOB_STEPID              ", "�����м��� �߻��ϴ� STEP_ID �������̺�", },
						{ "SYMS_LYA_JOB_USER_RULE           ", "�����м��� �߻��ϴ� USER RULE �������̺�", },
						{ "SYMS_LYA_LOG_INFO                ", "UI DAEMON Ư�� �α� �������̺�", },
						{ "SYMS_LYA_MAIL_OPTION             ", "���� ������ ��������", },
						{ "SYMS_LYA_MAP_LAYOUT              ", "���� ���� ���������� ���� �̻��", },
						{ "SYMS_LYA_MST_SOURCE_FILE         ", "SPOTFIRE ���ø� ���� �������� ���̺�", },
						{ "SYMS_LYA_NOTICE                  ", "�������� ������ ���̺�(���� �ڷ� ����)", },
						{ "SYMS_LYA_QAF_RULE_BASE           ", "�м��� �Ķ���� �������� ���̺�", },
						{ "SYMS_LYA_QAF_WORKFLOW_LIST       ", "UI��� WORKFLOW LIST �������� ���̺�", },
						{ "SYMS_LYA_QFOCUS_MASTER           ", "QFOCUS �м� MASTER ���̺�", },
						{ "SYMS_LYA_REPORT_SCRAP            ", "����Ʈ ��ũ�� �̷� ���� ���̺�(���� �ڷ� ����)", },
						{ "SYMS_LYA_RULE_DELAYTIME          ", "DELAYTIME ���� ���̺�(���� �ڷ� ����)", },
						{ "SYMS_LYA_RULE_DELAYTIME_QAF      ", "DELAYTIME ���� ���̺�(���� �ڷ� ����)", },
						{ "SYMS_LYA_RULE_MASTER             ", "UI RULE �������� ���̺�", },
						{ "SYMS_LYA_RULE_MASTER_QAF         ", "UI RULE �������� ���̺�", },
						{ "SYMS_LYA_RULE_VALUE              ", "UI RULE VALUE �������� ���̺�", },
						{ "SYMS_LYA_RULE_VALUE_QAF          ", "UI RULE VALUE �������� ���̺�", },
						{ "SYMS_LYA_SUMMARY_REPORT          ", "JOB_ID�� UI HTM �̷°��� ���̺�", },
						{ "SYMS_LYA_SYS_LOG_INFO            ", "", },
						{ "SYMS_LYA_USER_CLUSTER_MAP        ", "USER CLUSTER MAP ���� ���̺�(���� �ڷ� ����)", },
						{ "SYMS_LYA_USER_MASTER             ", "���� ������ �������� ���̺�", },
						{ "SYMS_LYA_USER_OPTION             ", "���� ������ �������� ���̺�", },
						{ "SYMS_LYA_USER_OPTION_DCOMP       ", "DEFECT PATTERN �м� ������ �������� ���̺�(���� �ش� �м� �̼���)", },
						{ "SYMS_LYA_USER_OPTION_GAMMA       ", "GAMMA �м� ������ �������� ���̺�(���� �ش� �м� �̼���)", },
						{ "SYMS_LYA_USER_OPTION_MURA        ", "��� �м� ������ �������� ���̺�(���� �ش� �м� �̼���)", },
						{ "SYMS_LYA_USER_OPTION_PRODUCT     ", "���� ������ �������� ���̺�", },
				};
				
				OracleConnection conn = Connection.getOracleConnection();
				Statement stmt = conn.createStatement();
				
				for (String[] tableName : tableNames) {
					String query;
					query = String.format("SELECT * FROM YMS_LYA.%s WHERE ROWNUM <= 1", tableName[0]);
					
					if (Flag.TRUE) {
						ResultSet resultSet = stmt.executeQuery(query);
						ResultSetMetaData metaData = resultSet.getMetaData();
						
						System.out.println(String.format("\n\n\n---------- table :  %s  %s ------------\n", tableName[0], tableName[1]));
						
						/*
						 * row data
						 */
						for (int i=0; i < 10000 && resultSet.next(); i++) {
							
							StringBuffer sb = new StringBuffer();
							sb.append(String.format("(%4d)   ", i));
							
							for (int col=1; col <= metaData.getColumnCount(); col++) {
								sb.append("\t").append(resultSet.getString(col));
							}
							
							System.out.println(sb.toString());
						}

						System.out.println();
						
						/* 
						 * meta data
						 */
						for (int i=1; i <= metaData.getColumnCount(); i++) {
							System.out.println(String.format("\t%2d) %-30s %-30s [%s]", i, metaData.getColumnName(i), metaData.getColumnLabel(i), metaData.getColumnClassName(i)));
						}
					}
				}
				
				conn.close();
				if (Flag.TRUE) System.out.println("##### OK!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args)
	{
		if (!Flag.TRUE) test01();
		if (Flag.TRUE) test02();
	}
}
