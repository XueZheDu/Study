package cam.gnkjxy.myqq.qqcommon;

import java.io.Serializable;

/**
 * @author XueZheDu
 * @version 1.0
 * 表示一个客户端和服务端通信时的消息对象
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private String sender;  //发送者
    private String receiver;  //接收者
    private String content;  //消息内容
    private String sendTime;  //发送时间
    private String mesType;  //消息类型（可以在接口定义消息类型）
    //扩展文件消息相关成员
    private byte[] fileBytes;
    private int fileLen;
    private String dest; //文件发送目的地路径
    private String src; //源文件路径

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    public int getFileLen() {
        return fileLen;
    }

    public void setFileLen(int fileLen) {
        this.fileLen = fileLen;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}