export const environment = {
  production: false,
  serverUrl: 'http://localhost:8080/auth/',
  keycloak: {
    issuer: 'http://localhost:8080/auth/',
    realm: 'master',
    clientId: 'master-realm',
  },
};
