package com.libon.test.tondeuseGazon.controlleur;

import com.libon.test.tondeuseGazon.domain.Payload;
import com.libon.test.tondeuseGazon.domain.Resultat;
import com.libon.test.tondeuseGazon.service.TondeuseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tondeuses")
@RequiredArgsConstructor
public class TondeuseControlleur {

    private final TondeuseService service;

    @GetMapping
    public Resultat getPositionTondeuse(@RequestBody Payload payload) {
        return service.getPosition(payload);
    }
}
