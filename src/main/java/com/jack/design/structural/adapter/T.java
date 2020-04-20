package com.jack.design.structural.adapter;

/**
 * Created by manchong on 2020/4/8.
 */
public class T {

    public static void main(String[] args) {
        MediaPalyer audioPlayer = new AudioPlayer(new MediaAdapter("mp4"));
        audioPlayer.play("mp4","file://c://1.mp3");
    }

}
