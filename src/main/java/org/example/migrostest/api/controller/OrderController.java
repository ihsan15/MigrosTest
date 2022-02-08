package org.example.migrostest.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.migrostest.api.constants.ApiEndpoints;
import org.example.migrostest.api.request.CreateOrderRequest;
import org.example.migrostest.api.response.CreateOrderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = ApiEndpoints.API_ORDER, produces = { ApiEndpoints.RESPONSE_CONTENTTYPE })
@Api(value = "atmoperation-api")
public class OrderController {


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "/", notes = "get Orders by request")
    public CreateOrderResponse createOrder(@RequestBody @Valid CreateOrderRequest request){
        // TODO: create Order
        return new CreateOrderResponse();
    }
}
