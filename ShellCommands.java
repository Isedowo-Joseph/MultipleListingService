package ca.joseph.a2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * Spring Shell methods goes in this class. This allows you to interact with your application at runtime.
 */
@ShellComponent
public class ShellCommands {

    private static final Logger logger = LoggerFactory.getLogger(ShellCommands.class);

    /**
     * Spring Shell method example. Use this in case you want to invalidate your cache or
     * to get the number of listings in your cache.
     * Try running "cache --forced true"
     * @param forced should we force wipe the cache right away? or get the size of the cache in memory?
     * @return message to echo back to the console
     */
    Singleton instance = Singleton.getInstance();
    @ShellMethod("interact with the cache ... ")
    public String cache(@ShellOption(defaultValue = "false") String forced) {
//        if (Boolean.valueOf(forced)) {
//            instance.clearCache();
//            return "forcing flushed ...";
//        } else {
//            return "the cache size is " + instance.getCount();
//        }
        return forced;
    }
}



