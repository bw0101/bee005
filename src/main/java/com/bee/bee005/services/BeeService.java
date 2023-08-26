package com.bee.bee005.services;

import com.bee.bee005.models.Bee;
import com.bee.bee005.repositories.BeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@RequiredArgsConstructor
@Slf4j
@Service
public class BeeService {

    private BeeRepository repo;

    BeeService(BeeRepository repo) {
        this.repo = repo;
    }

    public Iterable<Bee> list() {
        return repo.findAll();
    }
}
