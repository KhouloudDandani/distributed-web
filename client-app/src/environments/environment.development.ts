export const environment = {
    API_URL: "http://localhost:8090",
    production: false,
    serverUrl: '/api',
    keycloak: {
      issuer: 'http://localhost:8080/auth/',
      realm: 'master',
      clientId: 'master-realm', },
};
