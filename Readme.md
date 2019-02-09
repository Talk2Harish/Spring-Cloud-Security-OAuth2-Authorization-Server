# Authorization Server Configuration

As you configure the Authorization Server, you have to consider the grant type that the client is to use to obtain an access token from the end-user (e.g. authorization code, user credentials, refresh token). The configuration of the server is used to provide implementations of the client details service and token services and to enable or disable certain aspects of the mechanism globally. Note, however, that each client can be configured specifically with permissions to be able to use certain authorization mechanisms and access grants. I.e. just because your provider is configured to support the "client credentials" grant type, doesn't mean that a specific client is authorized to use that grant type.

The @EnableAuthorizationServer annotation is used to configure the OAuth 2.0 Authorization Server mechanism, together with any @Beans that implement AuthorizationServerConfigurer (there is a handy adapter implementation with empty methods). The following features are delegated to separate configurers that are created by Spring and passed into the AuthorizationServerConfigurer:

## ClientDetailsServiceConfigurer: 

a configurer that defines the client details service. Client details can be initialized, or you can just refer to an existing store.
AuthorizationServerSecurityConfigurer: defines the security constraints on the token endpoint.
AuthorizationServerEndpointsConfigurer: defines the authorization and token endpoints and the token services.


## localhost:8886/service/oauth/token

###  output:

{
    "access_token": "1009422d-47e9-4932-8fe0-7da2bff46e01",
    "token_type": "bearer",
    "refresh_token": "29f9d472-58f3-4271-88af-29f6a56f2fbb",
    "expires_in": 42982,
    "scope": "read write"
}

## http://localhost:8886/service/user

Header --> Authorization:Bearer "access_token"

output:

{
    "authorities": [
        {
            "authority": "ROLE_ADMIN"
        },
        {
            "authority": "ROLE_USER"
        }
    ],
    "details": {
        "remoteAddress": "0:0:0:0:0:0:0:1",
        "sessionId": null,
        "tokenValue": "1009422d-47e9-4932-8fe0-7da2bff46e01",
        "tokenType": "Bearer",
        "decodedDetails": null
    },
    "authenticated": true,
    "userAuthentication": {
        "authorities": [
            {
                "authority": "ROLE_ADMIN"
            },
            {
                "authority": "ROLE_USER"
            }
        ],
        "details": {
            "cilent_id": "HarishForJava",
            "grant_type": "password",
            "username": "HFJ"
        },
        "authenticated": true,
        "principal": {
            "password": null,
            "username": "HFJ",
            "authorities": [
                {
                    "authority": "ROLE_ADMIN"
                },
                {
                    "authority": "ROLE_USER"
                }
            ],
            "accountNonExpired": true,
            "accountNonLocked": true,
            "credentialsNonExpired": true,
            "enabled": true
        },
        "credentials": null,
        "name": "HFJ"
    },
    "oauth2Request": {
        "clientId": "HarishForJava",
        "scope": [
            "read",
            "write"
        ],
        "requestParameters": {
            "cilent_id": "HarishForJava",
            "grant_type": "password",
            "username": "HFJ"
        },
        "resourceIds": [],
        "authorities": [
            {
                "authority": "ROLE_USER"
            }
        ],
        "approved": true,
        "refresh": false,
        "redirectUri": null,
        "responseTypes": [],
        "extensions": {},
        "grantType": "password",
        "refreshTokenRequest": null
    },
    "clientOnly": false,
    "principal": {
        "password": null,
        "username": "HFJ",
        "authorities": [
            {
                "authority": "ROLE_ADMIN"
            },
            {
                "authority": "ROLE_USER"
            }
        ],
        "accountNonExpired": true,
        "accountNonLocked": true,
        "credentialsNonExpired": true,
        "enabled": true
    },
    "credentials": "",
    "name": "HFJ"
}