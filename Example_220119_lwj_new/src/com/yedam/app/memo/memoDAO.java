package com.yedam.app.memo;

import java.util.List;

public interface memoDAO {
	//전체  
	public List<Memo> selectAll();
	  //단건
	  public Memo slelectOne(int memoId);
	  //등록
	  public void  insert(Memo memo);
	  //수정
	  public void update(Memo memo);
	  //삭제
	  public void delete(int memoId);
}
