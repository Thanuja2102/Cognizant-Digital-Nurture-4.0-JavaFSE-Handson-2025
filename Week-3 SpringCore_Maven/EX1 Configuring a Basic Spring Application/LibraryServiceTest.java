package com.smartlib;

import com.smartlib.model.Book;
import com.smartlib.model.Member;
import com.smartlib.service.AdminService;
import com.smartlib.service.IssueService;
import com.smartlib.service.MemberService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryServiceTest {
    private AdminService adminService;
    private MemberService memberService;
    private IssueService issueService;

    @Before
    public void setup() {
        adminService = new AdminService();
        memberService = new MemberService();
        issueService = new IssueService();
        issueService.setAdminService(adminService);
    }

    @Test
    public void testIssueAndReturnBook() {
        Book book = new Book("JUnit in Action", "Craig Walls");
        adminService.addBook(book);
        Member member = new Member(1, "Tester");
        memberService.registerMember(member);

        issueService.issueBook(book, member);
        assertTrue(book.isIssued());

        issueService.returnBook(book, member);
        assertFalse(book.isIssued());
    }
}

