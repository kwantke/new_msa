package com.example.apigatewayservice.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class LoggingFilter extends AbstractGatewayFilterFactory<LoggingFilter.Config> {

  public LoggingFilter() {
    super(Config.class);
  }

  @Override
  public GatewayFilter apply(Config config) {
    //Custom Pre Filter
    /*return ((exchange, chain) -> {
      ServerHttpRequest request = exchange.getRequest();
      ServerHttpResponse response = exchange.getResponse();

      log.info("Global Pre Filter baseMessage: {}", config.getBaseMessage());

      if (config.isPreLogger()) {
        log.info("Global Filter Start: request id -> {}", request.getId());
      }

      //Custom PostFilter
      return chain.filter(exchange).then(Mono.fromRunnable(() -> {
        if (config.isPostLogger()) {
          log.info("Global POST filter End: response code -> {}", response.getStatusCode());
        }
      }));
    });*/
    GatewayFilter filter = new OrderedGatewayFilter((exchange, chain) -> {
      ServerHttpRequest request = exchange.getRequest();
      ServerHttpResponse response = exchange.getResponse();

      log.info("Logging Filter baseMessage: {}", config.getBaseMessage());

      if (config.isPreLogger()) {
        log.info("Logging PRE Filter: request id -> {}", request.getId());
      }

      //Custom PostFilter
      return chain.filter(exchange).then(Mono.fromRunnable(() -> {
        if (config.isPostLogger()) {
          log.info("Logging POST filter: response code -> {}", response.getStatusCode());
        }
      }));
    //}, Ordered.HIGHEST_PRECEDENCE);
    }, Ordered.LOWEST_PRECEDENCE);
  // filter들 중에 우선 순위를 가장 높게(HIGHEST_PRECEDENCE) 잡음으로서 가장 먼저 실행되므로 로그 출력이
    // 가정 먼저 출력되고 가장 마지막에 출력된다.
    return filter;
  }

  @Data
  public static class Config {
    private String baseMessage;
    private boolean preLogger;
    private boolean postLogger;

  }

}
