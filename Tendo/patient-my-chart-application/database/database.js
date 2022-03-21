var locallydb = require('locallydb');
var db = new locallydb('./database');
let tables = {
    tenants : {
        prod : db.collection('hiprodtenants'),
        staging: db.collection('histagingtenants'),
        dev: db.collection('hidevtenants')
    },
    users : db.collection('userdetails'),
    locks : db.collection('lockdetails'),
    products : db.collection('productdetails'),
    audits : db.collection('auditdetails'),
    settings : db.collection('settignsdetails'),
    userJiras : db.collection('userjiradetails'),
    userQueries : db.collection('userquerydetails')

};

exports.tables = tables;
