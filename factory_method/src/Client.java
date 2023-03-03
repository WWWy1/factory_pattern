//日志记录器接口：抽象产品Log

import sun.rmi.runtime.Log;

abstract class Log{
    abstract void writeLog();
}

//文件日志记录器：具体产品FileLog
class FileLog extends Log {
    public void writeLog(){
        System.out.println("write a fileLog");
    }
}

//数据库日志记录器：具体产品DatabaseLog
class DatabaseLog extends Log{
    public void writeLog(){
        System.out.println("write a databaseLog");
    }
}

//日志记录器工厂接口：抽象工厂LogFactory
abstract class LogFactory{
    abstract Log createLog();
}

//文件日志记录器工厂类：具体工厂FileLogFactory
class FileLogFactory extends LogFactory{

    @Override
    public Log createLog() {
        return new FileLog();
    }
}

//数据库日志记录器工厂类：具体工厂DatabaseLogFactory
class DatabaseLogFactory extends LogFactory{

    @Override
    public Log createLog() {
        return new DatabaseLog();
    }
}
//客户端测试类
class Client
{
    public static void main(String[] args)
    {
        LogFactory factory;
        Log log;
        factory = new FileLogFactory();
        log = factory.createLog();
        log.writeLog();
    }
}
