function() {    
  var env = java.lang.System.getenv('ENV') // get system property 'karate.env'
  karate.log('karate.env system property was:', env);
  if (!env) {
    env = 'dev';
  }

  var config = {
    env: env,
	userConfig: java.lang.System.getenv('USER_CONFIG'),
	urlGraphql: 'https://swapi-graphql.netlify.app/.netlify/functions/index'
  }

  if (env == 'dev') {
    // customize
    baseurl: 'pipeline'
  } else if (env == 'local') {
    // customize
    baseurl: 'hostname'
  }
  return config;
}
