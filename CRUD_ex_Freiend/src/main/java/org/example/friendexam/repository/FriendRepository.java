package org.example.friendexam.repository;

import org.example.friendexam.domain.Friend;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * PagingAndSortingRepository<Friend, Long> ---> 페이지 처리 가능
 */
public interface FriendRepository extends CrudRepository<Friend, Long>, PagingAndSortingRepository<Friend, Long> {

}
