package org.some.pkg.controller;

import org.some.pkg.entity.Detail;
import org.some.pkg.service.interfaces.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by siarqua on 10.08.15.
 */
@RestController // same as @Controller CHECK
@RequestMapping(value = "/details/api") // maps all method with prefix
public class DetailController {

    @Autowired // automatically find component and initialize it here
    private DetailService detailService;

    @ResponseBody
    @RequestMapping(method = POST)
    public ResponseEntity add(@RequestBody Detail detail){
        detailService.add(detail);
        return ResponseEntity.ok().build();
    }

    @ResponseBody
    @RequestMapping(method = GET, value = "/{id}")
    public ResponseEntity<Detail> get(@PathVariable long id){
        Detail detail = detailService.get(id);
        return ResponseEntity.ok().body(detail);
    }

    @ResponseBody
    @RequestMapping(method = GET, value = "/add-automatic", produces = TEXT_PLAIN_VALUE)
    public String addAutomaticSong() {
        Detail detail = new Detail();
        detail.setDescription("Some description");
        detailService.add(detail);
        return "added: " + detail.toString();
    }

}
