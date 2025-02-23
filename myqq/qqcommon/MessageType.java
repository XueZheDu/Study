package cam.gnkjxy.myqq.qqcommon;

/**
 * @author XueZheDu
 * @version 1.0
 * 表示消息类型
 */
public interface MessageType {
    //在接口中定义了一些常量，不同的常量的值表示不同的消息类型
    String MESSAGE_LOGIN_SUCCEED = "1";  //表示登入成功
    String MESSAGE_LOGIN_FAIL = "2";  //表示登入失败
    String MESSAGE_COMM_MES = "3"; //普通信息包
    String MESSAGE_GET_ONLINE_FRIEND = "4"; //要求返回在线用户列表
    String MESSAGE_RET_ONLINE_FRIEND = "5"; //返回在线用户列表
    String MESSAGE_CLIENT_EXIT = "6"; //客户端请求退出
    String MESSAGE_CLIENT_EXIT_SUCCESS = "7"; //客户端请求退出成功
    String MESSAGE_TO_ALL_MES = "8"; //群发信息包
    String MESSAGE_FILE_MES = "9"; //文件信息（发送文件）
}