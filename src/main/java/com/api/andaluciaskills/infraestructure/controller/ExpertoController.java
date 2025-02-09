package com.api.andaluciaskills.infraestructure.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experto")
@PreAuthorize("hasRole('ROLE_EXPERTO')")
public class ExpertoController {

}


