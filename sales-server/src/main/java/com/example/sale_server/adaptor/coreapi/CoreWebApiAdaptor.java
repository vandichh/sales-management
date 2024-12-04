package com.example.sale_server.adaptor.coreapi;

import com.example.sale_server.domain.coreapi.CoreWebApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CoreWebApiAdaptor implements CoreWebApi {
    private final CoreAdaptorSupport support;

    @Override
    public void healthCheck() {
        RequestEntity<Void> request = this.support.initGet("/health-check").build();
        this.support.execute(request, Void.class);
    }
}
