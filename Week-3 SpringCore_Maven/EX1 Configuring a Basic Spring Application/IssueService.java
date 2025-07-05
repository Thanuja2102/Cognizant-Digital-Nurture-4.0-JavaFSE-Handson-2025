package com.smartlib.service;

import com.smartlib.model.Book;
import com.smartlib.model.Member;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class IssueService {
    private Map<Integer, LocalDate> issueDates = new HashMap<>();
    private AdminService adminService;

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public void issueBook(Book book, Member member) {
        if (!book.isIssued()) {
            book.setIssued(true);
            issueDates.put(book.getId(), LocalDate.now().minusDays(10)); // Simulate overdue
            System.out.println("[INFO] Book issued to member: " + member.getName());
        }
    }

    public void checkOverdue(Book book) {
        LocalDate issueDate = issueDates.get(book.getId());
        if (issueDate != null) {
            long days = ChronoUnit.DAYS.between(issueDate, LocalDate.now());
            if (days > 7) {
                System.out.println("[WARNING] Book ID " + book.getId() + " is overdue!");
            }
        }
    }

    public void returnBook(Book book, Member member) {
        if (book.isIssued()) {
            book.setIssued(false);
            issueDates.remove(book.getId());
            System.out.println("[INFO] Book '" + book.getTitle() + "' returned by member: " + member.getName());
        }
    }
}

