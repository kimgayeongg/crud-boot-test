package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService; //메소드르 사용하시 위해서 가져옴
    @GetMapping("/create")
    public String showBoardPage () {
        return "create";
    }
    @GetMapping("/detail/{id}") //id를 변수처럼 사용
    public String showDetailPage(@PathVariable Long id, Model model){ //@PathVariable 을 사용하여 id를 변수처럼 사용할 수 있다.
        Board currentBoard = boardService.findById(id); //id에 맞는 board 객체 찾기
        model.addAttribute("board",currentBoard);
        return "detail";
    }


   @PostMapping("/create")
    public String createPage(BoardDTO dto, RedirectAttributes redirectAttributes) {

        Board saveBoard = boardService.saveNewBoard(dto); //boardService에 saveNewBoard를 만들어주고 그 안에 dto를 전달
       redirectAttributes.addAttribute("id", saveBoard.getId()); //save를 해주면 DB에 저장

        return "redirect:/detail/{id}";
    }

}
