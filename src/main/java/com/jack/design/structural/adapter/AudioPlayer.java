package com.jack.design.structural.adapter;

/**
 * Created by manchong on 2020/4/8.
 */
public class AudioPlayer  implements MediaPalyer{
    private MediaPalyer mediaPalyer;

    public AudioPlayer(){}

    public AudioPlayer(MediaPalyer mediaPalyer) {
        this.mediaPalyer = mediaPalyer;
    }

    @Override
    public void play(String mediaType, String fileName) {
        if(mediaType.equals("mp3")) {
            System.out.println("播放 mp4 格式音乐 。filename="+fileName);
            return;
        }

        if(mediaPalyer==null) {
            System.out.println("不支持的影评格式");
            return;
        } else {

            mediaPalyer.play(mediaType,fileName);
        }
    }
}
