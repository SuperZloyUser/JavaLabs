const request = require('request');

// console.log(request.get('http://localhost:8081/books/1').auth('admin', '123', false));
 
const options = 
{
  url: 'http://localhost:8081/books',
  headers: 
  {
    'Accept': 'application/json',
    // 'Authorization':'Bearer f739a121-e374-40b6-8d7a-1d9ccbfc5724'
  }
};
 
function callback(error, response, body) 
{
  if (!error && response.statusCode == 200) 
  {
    // console.log(body);
    const info = JSON.parse(body);
    console.log(info);
  }
}
 
request(options, callback);

