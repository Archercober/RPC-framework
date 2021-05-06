package com.archer.test;

import com.archer.rpc.annotation.Service;
import com.archer.rpc.api.ByeService;

/**
 *
 */
@Service
public class ByeServiceImpl implements ByeService {



    @Override
    public String sayBye(String name) {
        return "bye, " + name;
    }
}
