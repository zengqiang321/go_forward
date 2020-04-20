package com.jack.design.behavioral.chain_of_responsibility.demo1;

/**
 * Created by manchong on 2020/4/14.
 */
public class Response {
    String resp;

    public Response(String resp) {
        this.resp =resp;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    @Override
    public String toString() {
        return "Response{" +
                "resp='" + resp + '\'' +
                '}';
    }
}
