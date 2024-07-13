package org.example.friendexam.controller;

import lombok.RequiredArgsConstructor;
import org.example.friendexam.domain.Friend;
import org.example.friendexam.service.FriendService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/friends")
public class FriendController {

    private final FriendService friendService;

    /**
     * localhost/friends
     * 위 url에 들어왔을 때 기본적으로 친구 목록을 보여줌
     */
//    @GetMapping
//    public String friends(Model model) {
//        Iterable<Friend> friends = friendService.findAllFriends();
//        model.addAttribute("friends", friends);
//        return "friends/list";
//    }

    // 페이지 처리 해보기
    @GetMapping
    public String friends(Model model,
                          @RequestParam(defaultValue = "1") int page,
                          @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page -1, size);

        Page<Friend> friends = friendService.findAllFriends(pageable);
        model.addAttribute("friends", friends);
        model.addAttribute("currentPage", page); // 현재 페이지
        return "friends/list";
    }

    /**
     * 친구등록
     * /localhost/add
     * 폼 보여주기 ---> friends/add ---> Get 방식으로
     * 폼 등록하기 ---> friends/add ---> Post 방식으로
     */
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("friend", new Friend());
        return "friends/form";
    }

    // form.html 에서 <input type="submit" value="친구등록"> 을 클릭할 때 일어남
    @PostMapping("/add")
    public String addFriend(@ModelAttribute("friend") Friend friend, RedirectAttributes redirectAttributes) {

        friendService.saveFriend(friend);
        redirectAttributes.addFlashAttribute("message", "친구 등록 완료");

        return "redirect:/friends";
    }

    /**
     * 친구 상세페이지
     * localhost/friends/{id} ---> localhost/friends/1
     * @PathVariable 사용 --> 메소드 파라미터를 URI 템플릿 변수에 바인딩하는 데 사용
     * @GetMapping("/{id}") ---> {id} 는 URL의 해당 부분을 메소드의 id 파라미터에 바인딩
     * list.html 에서
     * <a th:href="@{/friends/{id}(id=${friend.id})}" th:text="${friend.name}"> </a> 태그 추가하면
     * 이름 클릭시 상세페이지로 이동
     */
    @GetMapping("/{id}")
    public String detailFriend(@PathVariable Long id, Model model) {
        Friend friend = friendService.findFriendById(id);
        model.addAttribute("friend", friend);

        return "friends/detail";
    }

    /**
     * 친구 정보 삭제
     */
    @GetMapping("/delete/{id}")
    public String deleteFriends(@PathVariable Long id) {
        friendService.deleteFriendById(id);
        return "redirect:/friends";
    }

    /**
     * 친구 정보 수정
     * Get 방식 : /localhost/friends/edit/{id} ---> localhost/friends/edit/1 --> 폼을 열어주는 역할 ... 조회
     * Post 방식 : /localhost/friends/edit/{id} ---> 폼 데이터를 처리하는 역할 ... 수정
     */

    // 폼을 열어주는 역할..?
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Friend friend = friendService.findFriendById(id);
        model.addAttribute("friend", friend);
        return "friends/edit";
    }

    // 수정을 실질적으로 담당해주는 역할..?
    @PostMapping("/edit")
    public String editFriend(@ModelAttribute Friend friend) {
        friendService.saveFriend(friend);
        return "redirect:/friends";
    }
}
