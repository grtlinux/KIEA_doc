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
 * @date 2014. 8. 7.
 * @file_name AllQafTableInfoMain.java
 *
 */
public class AllQafTableInfoMain
{
	///////////////////////////////////////////////////////////////////////////

	private static void test01()
	{
		if (Flag.TRUE) {
			try {
				String[][] tableNames = {
						{ "D_CLUSTER_SPECIFY                ", "�м������������̺�", },
						{ "D_DCOLL                          ", "�м������������̺�", },
						{ "D_DELAYTIME_PROCESSTIME          ", "�м������������̺�", },
						{ "D_GAMMA_ALERT_ITEM_ID            ", "�м������������̺�", },
						{ "D_GAMMA_ALERT_PRODUCT            ", "�м������������̺�", },
						{ "D_ITEM_LIST                      ", "�м������������̺�", },
						{ "D_MATCHING_WEIGHT                ", "�м������������̺�", },
						{ "D_METRO_PROC_EQP                 ", "�м������������̺�", },
						{ "D_SAME_DEFECT                    ", "�м������������̺�", },
						{ "D_STEP_PROCESS                   ", "�м������������̺�", },
						{ "D_STEP_WEIGHT                    ", "�м������������̺�", },
						{ "ETL_DCOMP_EVENT                  ", "���ν��� ETL�� GLOBAL TEMPORARY TABLE", },
						{ "ETL_GAMMA_EVENT                  ", "���ν��� ETL�� GLOBAL TEMPORARY TABLE", },
						{ "ETL_JOB_CHECK                    ", "MDWDB -> YMSDB ��ȯ / ODI ��� �� �̻��", },
						{ "ETL_JOB_LIST                     ", "MDWDB -> YMSDB ��ȯ / ODI ��� �� �̻��", },
						{ "ETL_JOB_LIST_DEV                 ", "MDWDB -> YMSDB ��ȯ / ODI ��� �� �̻��", },
						{ "ETL_JOB_LOG                      ", "MDWDB -> YMSDB ��ȯ / ODI ��� �� �̻��", },
						{ "ETL_JOB_LOG_DEV                  ", "MDWDB -> YMSDB ��ȯ / ODI ��� �� �̻��", },
						{ "ETL_MURA_EVENT                   ", "���ν��� ETL�� GLOBAL TEMPORARY TABLE", },
						{ "ETL_PREJOB_LIST                  ", "MDWDB -> YMSDB ��ȯ / ODI ��� �� �̻��", },
						{ "ETL_SPC_EVENT                    ", "MDWDB -> YMSDB ��ȯ / ODI ��� �� �̻��", },
						{ "LOAD_V                           ", "MDWDB -> YMSDB ��ȯ / ODI ��� �� �̻��", },
						{ "PART_MGT_JOB_LOG                 ", "MDWDB -> YMSDB ��ȯ / ODI ��� �� �̻��", },
						{ "QAF_CHECK_DATA                   ", "TIBCO BW - SAS �� ��� ��� ���̺� (���� �α� ��������)", },
						{ "QAF_GOODBAD_ID                   ", "�м��� JOB_ID�� GOOD/BAD ���� ���̺�", },
						{ "QAF_ID_AWS_LOG_DETAIL            ", "WORKFLOW / JOB_ID�� SAS�м� ��� ����ð� ���� ���̺�", },
						{ "QAF_ID_AWS_LOG_HEADER            ", "WORKFLOW / JOB_ID�� SAS�м� ��� HEADER LOG ���� ���̺�", },
						{ "QAF_ID_DIP_HISTORY               ", "���� �ʱ� �ܰ� ����� ���̺�� ���� �̻��", },
						{ "QAF_ID_JOB_ARP_HISTORY           ", "JOB_ID�� �м� �Ķ���� ���� �Է�", },
						{ "QAF_ID_JOB_ARP_PARAM_VALUE       ", "ARP_HISTORY �� ���� �Ķ���� �������� ���̺�", },
						{ "QAF_ID_JOB_BASE                  ", "QAF �м��� ��ü �̷� ���� ���̺�", },
						{ "QAF_ID_JOB_DIP_HISTORY           ", "JOB_ID�� �м� �������� ���̺�(�м��ð�, ��, ����������)", },
						{ "QAF_ID_JOB_GIP_HISTORY           ", "USER CLUSTER �м��� ���Ǵ� �������� ���̺�", },
						{ "QAF_ID_JOB_SIP_HISTORY           ", "JOB_ID�� � �м� �������� �����ϴ� ���̺�(WIP/MOD/DEFECT ��)", },
						{ "QAF_ID_JOB_WORKFLOW_LIST         ", "WORKFLOW LIST �����������̺�", },
						{ "QAF_ID_LOGIC_BRANCH_CONTROL      ", "(���� ������ ����)", },
						{ "QAF_ID_OUTPUT_BASE               ", "JOB_ID�� CSV ���ϻ������ �̷°������̺�", },
						{ "QAF_MD_CODE_NAME                 ", "�������� ���̺�(QAF �ʱ� �ܰ迡 ����� �������� ���̺�) QAF META DATA �ڵ� �������� ����", },
						{ "QAF_MD_CODE_NAME1                ", "�̻�� ���̺�", },
						{ "QAF_MD_CONFIG_BASE               ", "�������� ���̺�(QAF �ʱ� �ܰ迡 ����� �������� ���̺�) QAF META DATA �ڵ� �������� ����", },
						{ "QAF_MD_DEFECTCD_MAPPING          ", "DEFECTCD MAPPING ��������", },
						{ "QAF_MD_ITEM_BASE                 ", "QAF SAS SOURCE �������� ���̺�", },
						{ "QAF_MD_OUTPUT_BROKER_STATUS      ", "QAF �м��� OUTPUT �������� ����", },
						{ "QAF_MD_RULE_BASE                 ", "�м��� �Ķ���� �������� ���̺�", },
						{ "QAF_MD_RULE_BASE_D               ", "(���� ������ ����)", },
						{ "QAF_MD_RULE_BASE_HISTORY         ", "(���� ������ ����)", },
						{ "QAF_MD_SRCDATA_MAPPING           ", "QAF META DATA �ҽ� ���� ���� ����", },
						{ "QAF_PARA_SASDI_JOB               ", "(���� ������ ����)", },
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
						{ "TMP_DEFECT                       ", "�̻�� ���̺�", },
						{ "TMP_INSPECT_HIST_MAIN            ", "�̻�� ���̺�", },
						{ "TMP_PRODUCT                      ", "�̻�� ���̺�", },
				};
				
				//OracleConnection conn = Connection.getOracleConnection("DEVTRC", "wkehdghk1");
				OracleConnection conn = Connection.getOracleConnection();
				Statement stmt = conn.createStatement();
				
				for (String[] tableName : tableNames) {
					String query;
					query = String.format("SELECT * FROM YMS_LYA.%s WHERE ROWNUM <= 5", tableName[0]);
					
					if (Flag.TRUE) {
						ResultSet resultSet = stmt.executeQuery(query);
						ResultSetMetaData metaData = resultSet.getMetaData();
						
						System.out.println(String.format("\n\n\n---------- table :  %s : %s ------------\n", tableName[0], tableName[1]));
						
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
		if (Flag.TRUE) test01();
	}
}
