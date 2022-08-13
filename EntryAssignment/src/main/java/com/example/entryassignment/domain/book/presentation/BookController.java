package com.example.entryassignment.domain.book.presentation;

import com.example.entryassignment.domain.book.presentation.dto.request.AdminAddBookRequest;
import com.example.entryassignment.domain.book.presentation.dto.request.AdminUpdateBookRequest;
import com.example.entryassignment.domain.book.presentation.dto.request.ApplyBookRequest;
import com.example.entryassignment.domain.book.presentation.dto.response.QueryBookInfoListResponse;
import com.example.entryassignment.domain.book.presentation.dto.response.QueryNaverBookInfoResponse;
import com.example.entryassignment.domain.book.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {
    private final AdminAddBookService adminAddBookService;
    private final AdminUpdateBookService adminUpdateBookService;
    private final DeleteBookService deleteBookService;
    private final QueryNaverBookInfoService queryNaverBookInfoService;
    private final QueryBookInfoService queryBookInfoService;
    private final ApplyBookService applyBookService;

    @PostMapping("/add")
    public String addBook(@RequestBody @Valid AdminAddBookRequest request) {
        return adminAddBookService.execute(request);
    }

    @PatchMapping("/update")
    public String updateBook(@RequestBody @Valid AdminUpdateBookRequest request) {
        return adminUpdateBookService.execute(request);
    }

    @DeleteMapping("/delete/{book-id}")
    public String deleteBook(@PathVariable(name = "book-id") Long id) {
        return deleteBookService.execute(id);
    }

    @GetMapping("/naverbook/{keyword}")
    public QueryNaverBookInfoResponse queryNaverBookInfo(@PathVariable String keyword) {
        return queryNaverBookInfoService.execute(keyword);
    }

    @GetMapping("/info/{keyword}")
    public QueryBookInfoListResponse queryBookInfo(@PathVariable String keyword) {
        return queryBookInfoService.execute(keyword);
    }

    @PostMapping("/apply")
    public String applyBook(@RequestBody @Valid ApplyBookRequest request) {
        return applyBookService.execute(request);
    }
}
