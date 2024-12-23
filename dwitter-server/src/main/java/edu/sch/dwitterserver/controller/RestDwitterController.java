package edu.sch.dwitterserver.controller;

import edu.sch.dwitterserver.domain.Dwitter;
import edu.sch.dwitterserver.dto.DwitterDto;
import edu.sch.dwitterserver.service.DwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController                // API로 리턴하는 컨트롤러
@RequestMapping("/api")     // 전체에 /api/... 로 맵핑
@CrossOrigin(origins = "http://localhost:3000")
public class RestDwitterController {
    /* TODO
     * 서비스 객체 생성
     * 등록, 전체 리스트 출력, 삭제 (3가지 기능)
     */

    // 서비스 객체
    private final DwitterService dwitterService;
    // 하나만 만들어서 사용: Singletone Design Pattern

    @Autowired  // 생성자를 통한 자동 주입
    public RestDwitterController(DwitterService dwitterService) {
        this.dwitterService = dwitterService;
    }


    /**
     * 리스트 조회
     */
    @GetMapping("/dwitters")    // /api/dwitters로 쓰면: /api/api/dwitters가 됨 (RequestMapping)
    public ResponseEntity<List<Dwitter>> list(Model model) {        // 전체 출력
        List<Dwitter> dwitters = dwitterService.findAll();   // before: findDwitters();
        return ResponseEntity.ok(dwitters);
        /* return 내용
        [{id: 1, name: 홍길동}, {id: 2, name: 김철수}, ...]
        -> App_dwitter.js의 App_dwitter()가 받음 */
    }

    /**
     * 등록
     */
    @PostMapping("/dwitters/register")
    public String register(@RequestBody DwitterDto dwitterDto) {    // 등록
        Dwitter dwitter = new Dwitter();
        dwitter.setName(dwitterDto.getName());
        dwitter.setMessage(dwitterDto.getMessage());
        dwitter.setImage(dwitterDto.getImage());
        dwitter.setAddress(dwitterDto.getAddress());

        dwitterService.register(dwitter);

        return "ok";
    }

    /**
     * 삭제
     */
    @PostMapping("/dwitters/delete")
    public String delete(@RequestBody DwitterDto dwitterDto) {      // 삭제
        Dwitter dwitter = new Dwitter();
        dwitter.setId(dwitterDto.getId());

        dwitterService.delete(dwitter);

        return "ok";
    }
}
