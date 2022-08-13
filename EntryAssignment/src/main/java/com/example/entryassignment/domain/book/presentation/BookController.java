package com.example.entryassignment.domain.book.presentation;

import com.example.entryassignment.domain.book.presentation.dto.request.AdminAddBookRequest;
import com.example.entryassignment.domain.book.presentation.dto.request.AdminUpdateBookRequest;
import com.example.entryassignment.domain.book.service.AdminAddBookService;
import com.example.entryassignment.domain.book.service.AdminUpdateBookService;
import com.example.entryassignment.domain.book.service.DeleteBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController{
    private final AdminAddBookService adminAddBookService;
    private final AdminUpdateBookService adminUpdateBookService;
    private final DeleteBookService deleteBookService;

    @PostMapping("/add")
    public String addBook(@RequestBody @Valid AdminAddBookRequest request) {
        return adminAddBookService.execute(request);
    }

    @PatchMapping("/update")
    public String updateBook(@RequestBody @Valid AdminUpdateBookRequest request){
        return adminUpdateBookService.execute(request);
    }

    @DeleteMapping("/delete/{book-id}")
    public String deleteBook(@PathVariable(name = "book-id") Long id){
        return deleteBookService
    }
}
