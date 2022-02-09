package org.example.migrostest.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.example.migrostest.api.constants.ApiEndpoints;
import org.example.migrostest.api.request.CreateOrderRequest;
import org.example.migrostest.api.response.CreateOrderResponse;
import org.example.migrostest.service.OrderCommandService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = ApiEndpoints.API_ORDER, produces = { ApiEndpoints.RESPONSE_CONTENTTYPE })
@Api(value = "api documentation")
@RequiredArgsConstructor
public class OrderController {

    private final OrderCommandService orderCommandService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "/", notes = "get Orders by request")
    public CreateOrderResponse createOrder(@RequestBody @Valid CreateOrderRequest request){
        return new CreateOrderResponse(orderCommandService.createOrder(request.getOrder()));
    }
}
