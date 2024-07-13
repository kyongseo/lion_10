package org.example.friendexam.service;

import lombok.RequiredArgsConstructor;
import org.example.friendexam.domain.Friend;
import org.example.friendexam.repository.FriendRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor // 생성자 자동 생성 final을 붙인 객체에 대해..
public class FriendService {
    private final FriendRepository friendRepository;

    /**
     * 친구 목록 보여주기
     * @Transactional(readOnly = true) ---> 읽기 전용 트랜잭션
     * 이 메소드가 데이터를 변경하지 않는다는 것
     * 불필요한 데이터베이스 락을 피할 수
     */
    @Transactional(readOnly = true)
    public Iterable <Friend> findAllFriends() {
        return friendRepository.findAll();
    }

    /**
     * 친구등록
     * 새로운 친구 정보를 저장하는 작업
     * @Transactional ---> 특히나 save 같은 경우..
     * 여러 데이터베이스 작업이 하나의 작업 단위로 묶여 처리 메소드 실행 중 발생하는 데이터베이스 작업이 트랜잭션 단위로 관리
     * 예외 발생 시 자동으로 롤백 처리
     * spring Data 에서 제공하는 save() 메서드는 id에 해당하는 값이 이미 존재한다면 수정 // 없다면 생성
     */
    @Transactional
    public Friend saveFriend(Friend friend) {
        return friendRepository.save(friend);
    }

    /**
     * id에 해당하는 친구정보조회
     */
    @Transactional(readOnly = true)
    public Friend findFriendById(Long id) {
        return friendRepository.findById(id).orElse(null);
    }

    /**
     * 친구 삭제하기
     */
    @Transactional
    public void deleteFriendById(Long id) {
        friendRepository.deleteById(id);
    }

    /**
     * 친구 수정하기
     * save() 메서드 사용
     */
    @Transactional
    public void editFriend(Friend friend) {
        friendRepository.save(friend);
    }

    /**
     * 페이진 처리된 친구 목록 조회
     * id 를 기준으로 내림차순 정렬
     */
    public Page<Friend> findAllFriends(Pageable pageable) {
        Pageable sortedByDescId = PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(),
                Sort.by(Sort.Direction.ASC, "id"));

        return friendRepository.findAll(sortedByDescId);
    }
}
