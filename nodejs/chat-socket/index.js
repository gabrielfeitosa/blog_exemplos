var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);
var port = process.env.PORT || 5000;

app.get('/', function(req, res){
  res.sendfile('index.html');
});

io.on('connection', function(socket){
  var usuario = null;
  console.log('a user connected');
  socket.on('disconnect', function(){
    console.log('user disconnected '+ usuario);
    usuario = null;
  });

  socket.on('chat mensagem', function(msg){
    console.log('message: ' + msg);
    var m = {
    	texto: msg,
    	usuario: usuario,
    	data: new Date()
    }
    io.emit('chat mensagem', m);
  });

  socket.on('chat entrar', function(u){
  	console.log('usuario login'+u);
  	usuario = u;
  });

});


http.listen(port, function(){
  console.log('listening on *:'+port);
});