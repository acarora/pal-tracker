package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    String port;
    String memoryLimit;
    String cfInstanceIndex;
    String cfInstanceError;


    public EnvController(@Value("${PORT:NOT SET}") String port,
                         @Value("${MEMORY_LIMIT:NOT SET}") String memoryLimit,
                         @Value("${CF_INSTANCE_INDEX:NOT SET}") String cfInstanceIndex,
                         @Value("${CF_INSTANCE_ADDR:NOT SET}") String cfInstanceError) {
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.cfInstanceIndex = cfInstanceIndex;
        this.cfInstanceError = cfInstanceError;
    }

    @GetMapping("/env")
    public Map<String,String> getEnv() {

        Map<String, String> env = new HashMap<String,String>();
        env.put("PORT",port);
        env.put("MEMORY_LIMIT",memoryLimit);
        env.put("CF_INSTANCE_INDEX",cfInstanceIndex);
        env.put("CF_INSTANCE_ADDR",cfInstanceError);

        return env;



    }
}
