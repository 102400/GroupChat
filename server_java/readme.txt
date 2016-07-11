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