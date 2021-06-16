const http = require('http');

const server = http.createServer((req, res) =>{
    res.setHeader('Content-Type', 'text/html');
    res.end('<h1>A Dynamic Page!</h1><p>with a random value: </p>' + Math.random());
});

server.listen(3000);
