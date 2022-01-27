package com.yedam.app.memo;

public class Memo {
	private int memoId;
	private String memoTitle;
	private String memoWriter;
	private String memoContent;
	public int getMemoId() {
		return memoId;
	}
	public void setMemoId(int memoId) {
		this.memoId = memoId;
	}
	public String getMemoTitle() {
		return memoTitle;
	}
	public void setMemoTitle(String memoTitle) {
		this.memoTitle = memoTitle;
	}
	public String getMemoWriter() {
		return memoWriter;
	}
	public void setMemoWriter(String memoWriter) {
		this.memoWriter = memoWriter;
	}
	public String getMemoContent() {
		return memoContent;
	}
	public void setMemoContent(String memoContent) {
		this.memoContent = memoContent;
	}
	@Override
	public String toString() {
		return "메모 번호 : " + memoId + ", 메모 제목 : " + memoTitle + ", 메모 작성자 : " + memoWriter + ", 메모 내용 : "
				+ memoContent + "]";
	}
	
	
	
}
