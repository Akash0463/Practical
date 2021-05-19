
var http1 = require('http');
 var dt = require('./modules');
 //create a server :
 http1.createServer(function(req,res)
 {
    // res.writeHead(200, {'Content-Type' : 'text/html'});
     res.write("The date and time are currently:" +dt.myDateTime());
     res.end();
 }).listen(8080); 
 console.log("server has started..");
