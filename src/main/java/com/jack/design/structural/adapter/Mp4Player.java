package com.jack.design.structural.adapter;

/**
 * Created by manchong on 2020/4/8.
 */
public class Mp4Player  implements AdvancedMediaPlayer {

    @Override
    public void playMp4(String fileName) {
        System.out.println("播放 mp4 格式音乐 。filename="+fileName);
    }

    @Override
    public void playVlc(String fileName) {

    }
}
