package co.develhope.logging.controllers;

import co.develhope.logging.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    Logger logger = LoggerFactory.getLogger(BasicController.class);
    @Autowired
    BasicService basicService;

    @GetMapping("/")
    public String getWelcome() {
        logger.info("Returning Welcome");
        return "Welcome";
    }

    @GetMapping("/exp")
    public String getService() {
        logger.debug("Returning service");
        return basicService.getPower(basicService.getN1(), basicService.getN2());
    }

    @GetMapping("/get-errors")
    public void gerError(){
        Error error = new Error("Error 404");
        logger.error("this is the ERROR Logger",error);
    }
}