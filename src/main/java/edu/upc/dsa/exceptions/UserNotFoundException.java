package edu.upc.dsa.exceptions;

public class UserNotFoundException extends Exception {
    // 默认构造函数
    public UserNotFoundException() {
        super("User not found");  // 默认错误消息
    }

    // 构造函数接收错误消息
    public UserNotFoundException(String message) {
        super(message);  // 调用父类构造函数传递错误消息
    }
}
