package com.mvc.upgrade.model.dto;

public class MemberDTO {

	private int MEMBERNO;
	private String MEMBERID;
	private String MEMBERPW;
	private String MEMBERNAME;

	public MemberDTO() {
	}

	public MemberDTO(int mEMBERNO, String mEMBERID, String mEMBERPW, String mEMBERNAME) {
		MEMBERNO = mEMBERNO;
		MEMBERID = mEMBERID;
		MEMBERPW = mEMBERPW;
		MEMBERNAME = mEMBERNAME;
	}

	public int getMEMBERNO() {
		return MEMBERNO;
	}

	public void setMEMBERNO(int mEMBERNO) {
		MEMBERNO = mEMBERNO;
	}

	public String getMEMBERID() {
		return MEMBERID;
	}

	public void setMEMBERID(String mEMBERID) {
		MEMBERID = mEMBERID;
	}

	public String getMEMBERPW() {
		return MEMBERPW;
	}

	public void setMEMBERPW(String mEMBERPW) {
		MEMBERPW = mEMBERPW;
	}

	public String getMEMBERNAME() {
		return MEMBERNAME;
	}

	public void setMEMBERNAME(String mEMBERNAME) {
		MEMBERNAME = mEMBERNAME;
	}

	@Override
	public String toString() {
		return "MemberDTO [MEMBERNO=" + MEMBERNO + ", MEMBERID=" + MEMBERID + ", MEMBERPW=" + MEMBERPW + ", MEMBERNAME="
				+ MEMBERNAME + "]";
	}

}
