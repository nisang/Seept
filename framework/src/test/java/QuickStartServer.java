import com.seept.framework.test.jetty.JettyFactory;
import org.eclipse.jetty.server.Server;

/**
 * @author : lihaoquan
 *
 * Jetty 服务器启动程序
 */
public class QuickStartServer {

    public static final int PORT = 7001;
    public static final String CONTEXT = "/seept";
    public static final String[] TLD_JAR_NAMES
            = new String[] { "sitemesh", "spring-webmvc", "shiro-web"};

    public static void main(String[] args) throws Exception{

        Server server = JettyFactory.openServer(PORT,CONTEXT);
        JettyFactory.setTldJarNames(server);

        try {
            server.start();
            System.out.println("[INFO] Server running at http://localhost:" + PORT + CONTEXT);

            // 等待用户输入回车重载应用.
            while (true) {
                char c = (char) System.in.read();
                if (c == '\n') {
                    JettyFactory.reloadContext(server);
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}