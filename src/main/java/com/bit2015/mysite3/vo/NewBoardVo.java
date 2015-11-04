package com.bit2015.mysite3.vo;

public class NewBoardVo {
	
	private Long no;
	private String title;
	private String content;
	private Long memberNo;
	private String memberName;
	private Long viewCnt;
	private String regDate;
	private Long groupNo;
	private Long orderNo;
	private Long depth;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(Long groupNo) {
		this.groupNo = groupNo;
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public Long getDepth() {
		return depth;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public Long getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(Long viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	@Override
	public String toString() {
		return "NewBoardVo [no=" + no + ", title=" + title + ", content="
				+ content + ", memberNo=" + memberNo + ", memberName="
				+ memberName + ", viewCnt=" + viewCnt + ", regDate=" + regDate
				+ ", groupNo=" + groupNo + ", orderNo=" + orderNo + ", depth="
				+ depth + "]";
	}
}