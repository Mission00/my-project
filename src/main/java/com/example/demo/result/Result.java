package com.example.demo.result;


import java.io.Serializable;

public class Result<T> implements Serializable {
    int code;
    private T data;

    public T getData()
    {
        return data;
    }
    public void setData(T data)
    {
        this.data = data;
    }

    public Result(int code)
    {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}


