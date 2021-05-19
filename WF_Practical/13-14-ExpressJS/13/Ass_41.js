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

app.get('/login', function(req, res) {
    session = req.session;
    res.sendFile('Ass_4login.html', { root: __dirname });
});

app.post('/login', function(req, res) {
    session = req.session;
    if (req.body.Username == 'admin' && req.body.Password == 'admin') {
        session.UniqueId = req.body.Username;
    }
    res.redirect('/redirects');
});

app.get('/redirects', function(req, res) {
    session = req.session;
    if (session.UniqueId) {
        console.log(session.UniqueId);
        res.redirect('/admin');
    } else {
        res.redirect('/unknown');
    }
});
app.get('/admin', function(req, res) {
    session = req.session;
    res.sendFile('Ass_4admin.html', { root: __dirname });
});

app.get('/unknown', function(req, res) {
    session = req.session;
    res.sendFile('Ass_4unknown.html', { root: __dirname });
});

app.listen(9000, function(req, res) {
    console.log('Running');
});


