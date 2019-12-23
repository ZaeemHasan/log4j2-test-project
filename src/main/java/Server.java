import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class Server{
    private Logger logger;
    private long id;
    SomeClass someClass;
    private boolean running = true;
    public Server(long id, SomeClass someClass) {
        this.id=id;
        this.someClass = someClass;
    }

    public void doStuff(Object lock){
        ThreadContext.put("ROUTINGKEY", "server"+id);
        synchronized(lock){
            logger = LogManager.getLogger(Constants.DYNAMIC_SERVERS);
            this.someClass.setLogger(logger);
        }
        logger.info("Server "+ id +" doing some stuff");
    }

    public void run() throws InterruptedException {
        logger.info("Server "+ id +" started running");
//        running = true;
        while(running){

            if (Thread.interrupted()) {
                logger.warn("I'm about to stop");
                throw new InterruptedException();
            }
        }
    }


    public void close() {
        running = false;
        logger.info("Server "+ id +" closed");
    }
}