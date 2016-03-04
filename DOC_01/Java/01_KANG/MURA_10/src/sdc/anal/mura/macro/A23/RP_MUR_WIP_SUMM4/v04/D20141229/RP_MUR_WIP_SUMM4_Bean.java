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

package sdc.anal.mura.macro.A23.RP_MUR_WIP_SUMM4.v04.D20141229;

import java.util.ArrayList;
import java.util.List;

import kiea.proj.sdc.anal.macro.impl.bean.AbstractBean;

/**
 * @author KangSeok
 * @date 2014. 8. 8.
 * @file_name RP_TOTWIP_SUMM_Bean.java
 *
 */
public class RP_MUR_WIP_SUMM4_Bean extends AbstractBean
{
	/*
	"DIV_CODE    :DivCode     ",
	"CLUSTER_ID  :ClusterId   ",
	"STEP_ID     :StepId      ",
	"EQP_ID      :EqpId       ",
	"TRCK_IN_HOUR:TrckInHour  ",
	"���� CELL ��:TotCellCnt  ",
	"�ҷ� CELL ��:BadCellCnt  ",
	"CELL �ҷ��� :CellBadRatio",
	*/

	private String divCode     ;
	private String clusterId   ;
	private String stepId      ;
	private String eqpId       ;
	private String trckInHour  ;
	private String totCellCnt  ;
	private String badCellCnt  ;
	private String cellBadRatio;

	public void addTotCellCnt()
	{
		this.totCellCnt = "" + (Long.parseLong(this.totCellCnt) + 1);
	}
	
	public void addBadCellCnt()
	{
		this.badCellCnt = "" + (Long.parseLong(this.badCellCnt) + 1);
	}

	public String toString()
	{
		return String.format("READ : [%s] [%s] [%s] [%s] [%s] [%s] [%s] [%s]"
			, divCode     
			, clusterId   
			, stepId      
			, eqpId       
			, trckInHour  
			, totCellCnt  
			, badCellCnt  
			, cellBadRatio
		);
	}

	public static String[] getHeader()
	{
		List<String> list = new ArrayList<String>();
		list.add("DIV_CODE"    );
		list.add("CLUSTER_ID"  );
		list.add("STEP_ID"     );
		list.add("EQP_ID"      );
		list.add("TRCK_IN_HOUR");
		list.add("���� CELL ��");
		list.add("�ҷ� CELL ��");
		list.add("CELL �ҷ���" );

		return list.toArray(new String[list.size()]);
	}

	public String[] getStringArray()
	{
		List<String> list = new ArrayList<String>();
		list.add(divCode     );
		list.add(clusterId   );
		list.add(stepId      );
		list.add(eqpId       );
		list.add(trckInHour  );
		list.add(totCellCnt  );
		list.add(badCellCnt  );
		list.add(cellBadRatio);

		return list.toArray(new String[list.size()]);
	}

	public String getDivCode()
	{
		return divCode;
	}

	public void setDivCode(String divCode)
	{
		this.divCode = divCode;
	}

	public String getClusterId()
	{
		return clusterId;
	}

	public void setClusterId(String clusterId)
	{
		this.clusterId = clusterId;
	}

	public String getStepId()
	{
		return stepId;
	}

	public void setStepId(String stepId)
	{
		this.stepId = stepId;
	}

	public String getEqpId()
	{
		return eqpId;
	}

	public void setEqpId(String eqpId)
	{
		this.eqpId = eqpId;
	}

	public String getTrckInHour()
	{
		return trckInHour;
	}

	public void setTrckInHour(String trckInHour)
	{
		this.trckInHour = trckInHour;
	}

	public String getTotCellCnt()
	{
		return totCellCnt;
	}

	public void setTotCellCnt(String totCellCnt)
	{
		this.totCellCnt = totCellCnt;
	}

	public String getBadCellCnt()
	{
		return badCellCnt;
	}

	public void setBadCellCnt(String badCellCnt)
	{
		this.badCellCnt = badCellCnt;
	}

	public String getCellBadRatio()
	{
		return cellBadRatio;
	}

	public void setCellBadRatio(String cellBadRatio)
	{
		this.cellBadRatio = cellBadRatio;
	}
}
