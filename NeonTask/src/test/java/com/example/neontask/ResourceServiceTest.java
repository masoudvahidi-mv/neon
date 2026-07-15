package com.example.neontask;

import com.example.neontask.dto.ResourceRequest;
import com.example.neontask.dto.ResourceResponse;
import com.example.neontask.entity.Resource;
import com.example.neontask.repository.ResourceRepository;
import com.example.neontask.service.ResourceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ResourceServiceTest {

    @Mock
    private ResourceRepository repository;

    @InjectMocks
    private ResourceService service;

    @Test
    void shouldCreateResource() {

        Resource resource = Resource.builder()
                .id(1L)
                .title("Payment API")
                .description("Payment Service")
                .organizationId("novinext.ir")
                .build();

        when(repository.save(any(Resource.class)))
                .thenReturn(resource);

        ResourceRequest request =
                new ResourceRequest(
                        "Payment API",
                        "Payment Service",
                        "novinext.ir"
                );

        ResourceResponse response =
                service.create(request);

        assertNotNull(response);
        assertEquals(1L, response.id());
        assertEquals("Payment API", response.title());
        assertEquals("Payment Service", response.description());
    }

}
