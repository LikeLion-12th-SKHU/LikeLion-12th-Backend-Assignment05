package org.likelion.likelionassignmentcrud.game.api;

import org.likelion.likelionassignmentcrud.game.api.dto.request.GameSaveReqDto;
import org.likelion.likelionassignmentcrud.game.api.dto.response.GameListResDto;
import org.likelion.likelionassignmentcrud.game.application.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> gameSave(@RequestBody GameSaveReqDto gameSaveReqDto) {
        gameService.gameSave(gameSaveReqDto);

        return new ResponseEntity<>("게임 저장!", HttpStatus.CREATED);
    }

    // 개발사에 따른 게임 리스트 불러오기
    @GetMapping("/{developerId}")
    public ResponseEntity<GameListResDto> myGameFindAll(@PathVariable("developerId") Long developerId) {
        GameListResDto gameListResDto = gameService.gameFindDeveloper(developerId);

        return new ResponseEntity<>(gameListResDto, HttpStatus.OK);
    }
}
