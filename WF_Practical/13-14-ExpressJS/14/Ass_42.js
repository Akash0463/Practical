const express = require('express');
var bodyParser = require('body-parser');
var sessions = require('express-session');

var session;
var app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.use(sessions({
    secret: 'sldhassah876*',
    resave: false,
    saveUninitialized: true
}));

app.get('/', function(req, res) {
    session = req.session;
    res.sendFile('Ass_42Home.html', { root: __dirname });
});
app.get('/Ass_42Tea', function(req, res) {
    session = req.session;
    res.sendFile('Ass_42Tea.html', { root: __dirname });
});
app.get('/Ass_42Coffee', function(req, res) {
    session = req.session;
    res.sendFile('Ass_42Coffee.html', { root: __dirname });
});
app.get('/Ass_42BlackTea', function(req, res) {
    session = req.session;
    res.sendFile('Ass_42BlackTea.html', { root: __dirname });
});


app.listen(9000, function(req, res) {
    console.log('Running');
});


/*const prompt = require('prompt-sync')();
const express = require('express');
const Ass_41 = express();

const f1 = prompt('UserName:- ');
const f2 = prompt('Password:- ');

Ass_41.get('/', function(req, res) {
    if (f2 == '1234') {
        res.send(`hello ${f1}`);
    } else {
        res.send(`Welcome`);
    }
})

Ass_41.listen(9000, function(req, res) {
    console.log('Running');
});
*/