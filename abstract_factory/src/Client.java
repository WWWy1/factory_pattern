//数据库连接接口：抽象产品Connection
abstract class Connection{ }

//Oracle数据库连接类：具体产品OracleConnection
class OracleConnection extends  Connection{
    public OracleConnection(){
        System.out.println("Oracle数据库");
    }
}

//MySQL数据库连接类：具体产品MySQLConnection
class MySQLConnection extends  Connection{
    public MySQLConnection(){
        System.out.println("MySql数据库");
    }
}
//数据库语句接口：抽象产品Statement
abstract class Statement{ }

//Oracle数据库语句类：具体产品OracleStatement
class OracleStatement extends Statement{
    public OracleStatement(){
        System.out.println("OracleStatement");
    }
}

//MySQL数据库语句类：具体产品MySQLStatement
class MySQLStatement extends Statement{
    public MySQLStatement(){
        System.out.println("MySQLStatement");
    }
}

//数据库工厂接口：抽象工厂DBFactory
abstract class DBFactory{
    abstract Connection createConnection();
    abstract Statement createStatement();
}

//Oracle数据库工厂：具体工厂OracleFactory
class OracleFactory extends DBFactory{

    @Override
    Connection createConnection() {
        return new OracleConnection();
    }

    @Override
    Statement createStatement() {
        return new OracleStatement();
    }
}

//MySQL数据库工厂：具体工厂MySQLFactory
class MySQLFactory extends DBFactory{

    @Override
    Connection createConnection() {
        return new MySQLConnection();
    }

    @Override
    Statement createStatement() {
        return new MySQLStatement();
    }
}

//客户端测试类
public class Client {

    public static void main(String[] args) {
        DBFactory dbFactory = (DBFactory)XmlUtil.getBean();
        Connection connection = dbFactory.createConnection();
        Statement statement = dbFactory.createStatement();
    }
}
