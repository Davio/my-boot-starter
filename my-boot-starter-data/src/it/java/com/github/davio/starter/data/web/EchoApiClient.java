package com.github.davio.starter.data.web;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "echoService", url = "${echo.url:http://localhost/api}")
public interface EchoApiClient extends EchoApi {
}
