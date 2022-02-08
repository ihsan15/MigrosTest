package org.example.migrostest.api.constants;

import org.springframework.http.MediaType;

public final class ApiEndpoints {
    public static final String RESPONSE_CONTENTTYPE = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8";

    private static final String API_BASE_URL = "/api";

    public static final String API_ORDER = API_BASE_URL + "/order";

    private ApiEndpoints() {
    }
}
