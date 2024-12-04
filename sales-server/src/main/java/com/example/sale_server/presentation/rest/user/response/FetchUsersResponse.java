package com.example.sale_server.presentation.rest.user.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FetchUsersResponse {
    public final List<FindUserResponse> users;
}
