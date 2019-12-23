import org.apache.logging.log4j.Logger;

public class SomeClass {

    private Logger logger;

    public void setLogger(Logger logger){
        this.logger = logger;
        logger.info("Logger setted in SomeClass");
    }
}
