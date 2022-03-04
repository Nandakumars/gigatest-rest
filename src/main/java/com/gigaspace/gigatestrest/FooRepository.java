package com.gigaspace.gigatestrest;

import java.util.List;

public interface FooRepository {
    int count();
    int insert(Foo foo);
    int update(Foo foo);
    int deleteByNumber(Integer entryNumber);
    Foo findByNumber(Integer entryNumber);
    List<Foo> getAll();
}
