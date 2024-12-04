package com.example.sale_server.domain.coreapi.result.user;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CoreApiFetchUsersResult {
    public final List<CoreApiFindUserResult> users;
}
