package org.example.restexam.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/memos")
public class MomoRestController {

    private final Map<Long, String> memos = new HashMap<>();
    private final AtomicLong counter = new AtomicLong(); // 자동으로 생성

    // 메모 저장 확인
    // ResponseEntity 클래스는 Spring MVC에서 HTTP 요청에 대한 응답을 구성할 때 사용
    @PostMapping
    public ResponseEntity<Long> createMemo(@RequestBody String memo) {
        Long id = counter.incrementAndGet();
        memos.put(id, memo);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getMemo(@PathVariable("id") Long id) {
        String memo = memos.get(id);
        if (memo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(memo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMemo(@PathVariable("id") Long id, @RequestBody String memo) {
        if (!memos.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        memos.put(id, memo);
        return ResponseEntity.ok("메모 수정 성송!!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMemo(@PathVariable("id") Long id) {
        String removed = memos.remove(id);
        if (removed == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(removed);
    }
}
