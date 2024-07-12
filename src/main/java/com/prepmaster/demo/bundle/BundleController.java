package com.prepmaster.demo.bundle;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/bundles")
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "https://prepmaster-api-xwoy.onrender.com/api")
public class BundleController {
    private BundleService bundleService;

    @PostMapping
    void createBundle(@Valid @RequestBody BundleRequestBody bundleRequestBody){
        bundleService.createNewBundle(bundleRequestBody);
    }
    @GetMapping(path = "{bundleId}")
    Bundle readBundle(@Valid @PathVariable("bundleId") Long id) {
        return bundleService.getBundle(id);
    }
    @PutMapping
    void updateBundle(@Valid @RequestBody BundleRequestBody bundleRequestBody){
        bundleService.updateBundle(bundleRequestBody);
    }
    @DeleteMapping(path = "{bundleId}")
    void deleteBundle(@PathVariable("bundleId") Long id){
        bundleService.deleteBundle(id);
    }
    @GetMapping
    List<Bundle> getBundles(){
        return bundleService.getBundles();
    }
}
