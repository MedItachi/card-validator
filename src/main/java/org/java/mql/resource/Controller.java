package org.java.mql.resource;

import javax.ws.rs.GET;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/test")
    public ResponseEntity test() {
        return ResponseEntity.ok("test");
    }
}
