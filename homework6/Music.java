package com.gnkjxy.demo2.homework6;

/*
	9.定义Music类，里面有音乐名name、音乐时长times属性，并有播放play功能和返回
	本身属性信息的功能方法getInfo.

 */

public class Music {
	String name;
	int times;
	
	public Music(String name, int times) {
		this.name = name;
		this.times = times;
	}
	
	public void play() {
		System.out.println("播放音乐中~");
	}
	
	public String getInfo() {
		return "歌名：" + name + " 时长：" + times;
	}
}
