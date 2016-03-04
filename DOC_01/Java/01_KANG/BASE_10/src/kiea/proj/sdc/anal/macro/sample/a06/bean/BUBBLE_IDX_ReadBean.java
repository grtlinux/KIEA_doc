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

package kiea.proj.sdc.anal.macro.sample.a06.bean;

import java.util.ArrayList;
import java.util.List;

import kiea.proj.sdc.anal.macro.impl.bean.AbstractBean;

/**
 * @author KangSeok
 * @date 2014. 8. 8.
 * @file_name BUBBLE_IDX_ReadBean.java
 *
 */
public class BUBBLE_IDX_ReadBean extends AbstractBean
{
	private String procId   ;
	private String cellLocId;
	private String colIdx   ;
	private String rowIdx   ;
	private String pointX   ;
	private String pointY   ;

	public String toString()
	{
		return String.format("READ : [%s] [%s] [%s] [%s] [%s] [%s]"
			, procId   
			, cellLocId
			, colIdx   
			, rowIdx   
			, pointX   
			, pointY   
		);
	}

	public static String[] getHeader()
	{
		List<String> list = new ArrayList<String>();
		list.add("PROCID"   );
		list.add("CELLLOCID");
		list.add("COLIDX"   );
		list.add("ROWIDX"   );
		list.add("POINT_X"  );
		list.add("POINT_Y"  );

		return list.toArray(new String[list.size()]);
	}

	public String[] getStringArray()
	{
		List<String> list = new ArrayList<String>();
		list.add(procId   );
		list.add(cellLocId);
		list.add(colIdx   );
		list.add(rowIdx   );
		list.add(pointX   );
		list.add(pointY   );

		return list.toArray(new String[list.size()]);
	}

	/**
	 * @return the procId
	 */
	public String getProcId()
	{
		return procId;
	}

	/**
	 * @return the cellLocId
	 */
	public String getCellLocId()
	{
		return cellLocId;
	}

	/**
	 * @return the colIdx
	 */
	public String getColIdx()
	{
		return colIdx;
	}

	/**
	 * @return the rowIdx
	 */
	public String getRowIdx()
	{
		return rowIdx;
	}

	/**
	 * @return the pointX
	 */
	public String getPointX()
	{
		return pointX;
	}

	/**
	 * @return the pointY
	 */
	public String getPointY()
	{
		return pointY;
	}

	/**
	 * @param procId the procId to set
	 */
	public void setProcId(String procId)
	{
		this.procId = procId;
	}

	/**
	 * @param cellLocId the cellLocId to set
	 */
	public void setCellLocId(String cellLocId)
	{
		this.cellLocId = cellLocId;
	}

	/**
	 * @param colIdx the colIdx to set
	 */
	public void setColIdx(String colIdx)
	{
		this.colIdx = colIdx;
	}

	/**
	 * @param rowIdx the rowIdx to set
	 */
	public void setRowIdx(String rowIdx)
	{
		this.rowIdx = rowIdx;
	}

	/**
	 * @param pointX the pointX to set
	 */
	public void setPointX(String pointX)
	{
		this.pointX = pointX;
	}

	/**
	 * @param pointY the pointY to set
	 */
	public void setPointY(String pointY)
	{
		this.pointY = pointY;
	}
}
