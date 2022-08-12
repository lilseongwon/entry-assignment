package com.example.entryassignment.domain.book.presentation;

import com.example.entryassignment.domain.book.presentation.dto.request.AdminAddBookRequest;
import com.example.entryassignment.domain.book.service.AdminAddBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminAddBookService adminAddBookService;

    @PostMapping("/add")
    public String addBook(@RequestBody @Valid AdminAddBookRequest request){
        return adminAddBookService.execute(request);
    }
}
