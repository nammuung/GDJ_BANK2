package com.winter.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardService;
import com.winter.app.util.Pager;

@Service
public class QnaService implements BoardService {
	@Autowired
	private QnaDAO qnaDAO;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makeRow();
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setAdd(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//reply
	public int setReply(QnaDTO qnaDTO)throws Exception{
		//boardNum : 부모의 글번호
		//boardTitle: 답글제목
		//boardWriter: 답글작성자
		//boardContents: 답글내용
		
		//1. 부모의 정보는 조회(REF, STEP, DEPTH)
		QnaDTO parent= (QnaDTO)qnaDAO.getDetail(qnaDTO);
		
		//2. 답글 정보 저장(REF, STEP, DEPTH 
		qnaDTO.setBoardRef(parent.getBoardRef());
		qnaDTO.setBoardStep(parent.getBoardStep()+1);
		qnaDTO.setBoardDepth(parent.getBoardStep()+1);
		
		//3. 부모의 정보로 step을 업데이트
		int result = qnaDAO.setReplyUpdate(parent);
		
		//4. DB에 답글을 저장
		result = qnaDAO.setReplyAdd(qnaDTO);
		return result;
	}
	
	

}
