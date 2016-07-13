单个客户端可以连无限个主机端口,登陆无限个用户

socket处理方式

rows    readLine()的行数 
instruction    执行指令
message    执行内容

instruction
    Client:
        ConnectRoom:
            connectRoom
            #roomid
            #roompassword
        
        SendMessage:
            sendMessage
            #roomid
            #chat_content
            
    Server:
        SendMessage:
            sendMessage
            #userid
            #time
            #roomid
            #chat_content


rule
    ServerHost
        InetAddress.getByName(serverhost);
        不抛异常
        
    ServerPort
        0-65535
        
    RoomID
        字符数:3
        字符:
            48-57,65-90,97-122
            数字,大写字母,小写字母
            
    RoomPassword
        字符数:0-16
        字符:
            33-126
            
    UserID
        字符数:1-10
        字符:
            48-57,65-90,97-122
            数字,大写字母,小写字母
        
    UserPassword
        无限制
        功能未开放