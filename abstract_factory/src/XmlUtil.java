import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlUtil
{
    public static Object getBean()
    {
        try
        {
            //创建文档对象
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("config.xml"));

            //获取包含品牌名称的文本节点
            NodeList nodeList = doc.getElementsByTagName("FactoryName");
            Node classNode=nodeList.item(0).getFirstChild();
            String className=classNode.getNodeValue().trim();

            Class c=Class.forName(className);
            return c.newInstance();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
