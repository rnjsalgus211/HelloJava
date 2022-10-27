package co.edu.board;

public class PageVO {
	int totalCntl; // 전체 건수.
	int pageNum; // 현재 페이지.
	int startPage, endPage, totalPage; // 시작,마지막
	boolean prev, next; // 이전, 마지막 페이지 있는지 확인

	public PageVO(int totalCnt, int pageNum) {
		this.totalCntl = totalCnt;
		this.pageNum = pageNum;

		totalPage = (int) Math.ceil(totalCnt / 10.0); // ceil :올림해줌 51.6 >> 52
		// startPage, endPage 계산.
		this.endPage = (int) Math.ceil(this.pageNum / 10.0) * 10; // 10page
		this.startPage = this.endPage - 9;// 1page

		prev = this.startPage > 10; // 이전페이지.
		next = this.endPage < totalPage; // 다음페이지.

	}

	public int getTotalCntl() {
		return totalCntl;
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	@Override
	public String toString() {
		return "PageVO [totalCntl=" + totalCntl + ", pageNum=" + pageNum + ", startPage=" + startPage + ", endPage="
				+ endPage + ", totalPage=" + totalPage + ", prev=" + prev + ", next=" + next + "]";
	}

}
