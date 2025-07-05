package com.smartlib.service;

import com.smartlib.model.Member;
import java.util.*;

public class MemberService {
    private Map<Integer, Member> members = new HashMap<>();

    public void registerMember(Member member) {
        members.put(member.getId(), member);
        System.out.println("[INFO] Member '" + member.getName() + "' registered.");
    }

    public Member getMember(int id) {
        return members.get(id);
    }
}

