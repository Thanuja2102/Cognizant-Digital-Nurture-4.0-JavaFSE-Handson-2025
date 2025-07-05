package com.smartlib.main;

import com.smartlib.model.Book;
import com.smartlib.model.Member;
import com.smartlib.service.AdminService;
import com.smartlib.service.MemberService;
import com.smartlib.service.IssueService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        AdminService admin = context.getBean("adminService", AdminService.class);
        MemberService memberService = context.getBean("memberService", MemberService.class);
        IssueService issueService = context.getBean("issueService", IssueService.class);

        Book book = new Book("Spring for Professionals", "John Doe");
        admin.addBook(book);

        Member member = new Member(101, "Ravi");
        memberService.registerMember(member);

        issueService.issueBook(book, member);
        issueService.checkOverdue(book);
        issueService.returnBook(book, member);

        ((ClassPathXmlApplicationContext) context).close();
    }
}
