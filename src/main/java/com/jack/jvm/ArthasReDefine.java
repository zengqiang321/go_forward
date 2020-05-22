package com.jack.jvm;

import java.io.IOException;

/**
 * Created by manchong on 2020/5/14.
 */
public class ArthasReDefine {
    public static void main(String[] args) throws IOException {
        for (;;) {
            System.in.read();
            new TT().m();
        }
    }
}
