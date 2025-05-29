package com.petaiprogram.controller;

import com.petaiprogram.domain.vo.ResponseResult;
import com.petaiprogram.service.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("miniTest")
public class DoctorController {

    @Autowired
    private DoctorsService doctorsService;

    @GetMapping("/getDoctor")
    public ResponseResult getDoctorItem() {
        return ResponseResult.ok(doctorsService.list());
    }
}
