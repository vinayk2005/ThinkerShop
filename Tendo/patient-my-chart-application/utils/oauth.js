var propertiesReader = require('properties-reader');
var http = require('http');
const properties = propertiesReader(__dirname +'/../resources/config.properties');

exports.getOauthToken = async (env) =>{
    var key,secret, token
    var url = properties.get('hi.provider.search.tool.oauth.url');
    if( env.toLowerCase() === "dev"){
        url=url.replace("{key}",properties.get('hi.provider.search.tool.oauth.dev.key'));
        url=url.replace("{secret}",properties.get('hi.provider.search.tool.oauth.dev.secret'));
        url=url.replace("{env}",'dev');
    }
    if( env.toLowerCase() === "staging"){
        url=url.replace("{key}",properties.get('hi.provider.search.tool.oauth.staging.key'));
        url=url.replace("{secret}",properties.get('hi.provider.search.tool.oauth.staging.secret'));
        url=url.replace("{env}",'staging');
    }
    if( env.toLowerCase() === "prod"){
        url=url.replace("{key}",properties.get('hi.provider.search.tool.oauth.prod.key'));
        url=url.replace("{secret}",properties.get('hi.provider.search.tool.oauth.prod.secret'));
        url=url.replace("{env}",'prod');
    }

     token = await makeSynchronousRequest(url);
     return token;
     
}

function getPromise(url) {
    
	return new Promise((resolve, reject) => {
        let options = new URL(url);
		http.get(options, (response) => {
			let chunks_of_data = [];

			response.on('data', (fragments) => {
				chunks_of_data.push(fragments);
			});

			response.on('end', () => {
				let response_body = Buffer.concat(chunks_of_data);
				resolve(response_body.toString());
			});

			response.on('error', (error) => {
				reject(error);
			});
		});
	});
}

async function makeSynchronousRequest(request) {
	try {
		let http_promise = getPromise(request);
		let response_body = await http_promise;

		// holds response from server that is passed when Promise is resolved
        // console.log(response_body);
        return response_body;
	}
	catch(error) {
		// Promise rejected
		console.log(error);
	}
}

