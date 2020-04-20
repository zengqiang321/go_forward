package com.jack.design.structural.adapter;

/**
 * Created by manchong on 2020/4/8.
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String fileName) {

    }

    @Override
    public void playVlc(String fileName) {
        System.out.println("播放 vlc 格式音乐 。filename="+fileName);
    }
}
