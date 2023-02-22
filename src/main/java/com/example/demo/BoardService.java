package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //final 이 붙은 변수(객체) 빈 주입
public class BoardService {

    private final  BoardRepository boardRepository;


    public Board saveNewBoard(BoardDTO dto) {    //()안에는 매개변수가 와야한다.
        Board newBoard = new Board();
        newBoard.setTitle(dto.getTitle());
        newBoard.setContent(dto.getContent());

        return  boardRepository.save(newBoard); // 저장과 동시에 DB에 저장된 객체를 다시 반환
    }

    public Board findById(Long id) {
        return  boardRepository.findById(id).get();
    }
}
