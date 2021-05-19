//event driven programming
var events = require('events');
var eventEmitter = new events.EventEmitter();

//Create an event handler:
var myEventHandler = function () {
  console.log('I am speaking!');
}

//Assign the event handler to an event:
eventEmitter.on('speak', myEventHandler);


eventEmitter.emit('speak');