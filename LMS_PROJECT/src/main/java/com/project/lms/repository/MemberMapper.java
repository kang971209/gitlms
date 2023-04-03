package com.project.lms.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.lms.model.entity.member.Member;

@Mapper
public interface MemberMapper {
	int joinMember(Member member);
	Member findMemberById(String id);
	List<Member> findId(Member member);
	int updateMember(Member member);
	Member findPassword(Member member);
	Member findPassword2(Member member);
	int updatePassword(Member member);
}