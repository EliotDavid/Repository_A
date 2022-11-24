package com.example.demo.relation.domain.service;


import com.example.demo.relation.domain.repository.OrderRepository;
import com.example.demo.relation.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public void insert(Member member)
    {
        orderRepository.insert(member);
    }

}
