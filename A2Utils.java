package ca.joseph.a2;
import com.google.common.base.Splitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;



public class A2Utils {

    public static Splitter splitter = Splitter.on("%%");
    public static final Logger logger = LoggerFactory.getLogger(A2Utils.class);
    public A2Utils(){

    }
    /**
     *Helps to parse a given text line in the mls.txt file
     *and to extract the tokens and construct the corresponding MultipleListingService record.
     * @param text a given text line in the format of mls.txt (refer to resources/data/mls.txt)
     * @return the MLS record using the tokens in the given text string.
     */
    public static MultipleListingService createMLSFromTextRecord(String text){
        MultipleListingService mls = null;
       List<String> tokens = new ArrayList();
        for(String str: splitter.split(text)) tokens.add(str);
        logger.debug("found " + tokens.size() + "tokens in: " + text);
        if(tokens.size() == 3){
            mls = new MultipleListingService.Builder(UUID.fromString(tokens.get(0)))
                    .locatedAt(tokens.get(1))
                    .pricedAt(Integer.parseInt(tokens.get(2)))
                    .build();
        }

        return mls;
    }

}
