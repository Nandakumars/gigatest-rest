package com.gigaspace.gigatestrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/foo")
public class FooRestController {

    @Autowired
    @Qualifier("FooRepository")
    private FooRepository fooRepo;

    @GetMapping(path = "/", produces = "application/json")
    public List<Foo> getAllFoo()
    {
        return fooRepo.getAll();
    }

    @GetMapping(path = "/add", produces = "application/json")
    public List<Foo> insertUpdateFoo(@RequestParam Integer entryNumber, @RequestParam String myMessage) {
        assert (entryNumber != null && myMessage != null) : "Invalid Input";

        Foo dbRow = fooRepo.findByNumber(entryNumber);

        if (dbRow != null) {
            fooRepo.update(new Foo(entryNumber, myMessage));
        } else {
            fooRepo.insert(new Foo(entryNumber, myMessage));
        }
        return fooRepo.getAll();
    }
}
