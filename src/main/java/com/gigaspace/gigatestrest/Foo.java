package com.gigaspace.gigatestrest;

public class Foo {
    private Integer entryNumber;
    private String myMessage;

    public Foo(Integer entryNumber, String myMessage) {
        this.entryNumber = entryNumber;
        this.myMessage = myMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Foo foo = (Foo) o;

        if (!getEntryNumber().equals(foo.getEntryNumber())) return false;
        return getMyMessage().equals(foo.getMyMessage());
    }

    @Override
    public int hashCode() {
        int result = getEntryNumber().hashCode();
        result = 31 * result + getMyMessage().hashCode();
        return result;
    }

    public void setEntryNumber(Integer entryNumber) {
        this.entryNumber = entryNumber;
    }

    public void setMyMessage(String myMessage) {
        this.myMessage = myMessage;
    }

    public Integer getEntryNumber() {
        return entryNumber;
    }

    public String getMyMessage() {
        return myMessage;
    }
}
