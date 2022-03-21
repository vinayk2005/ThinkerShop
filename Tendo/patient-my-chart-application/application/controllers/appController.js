var propertiesReader = require('properties-reader');
const logger = require('./../../utils/logger.js');
const helper  = require('./../../utils/helper.js');
const querybuilder  = require('./../../utils/queryBuilder.js');
const jiradude = require('./../../utils/jira.js');
const dbman = require('./../../database/database.js');
const mailer = require('./../../utils/mailer.js');
const scheduler = require('./../../utils/scheduler.js');
const gitter = require('./../../utils/git.js');
const oauth = require('./../../utils/oauth.js');
const filechad = require('fs');
const propreader = propertiesReader(__dirname +'/../../resources/config.properties');

let caboodle = {
     database : dbman,
     mailer : mailer,
     filesystem : filechad,
     log : logger.log,
     helper : helper.help,
     jira : jiradude.jira,
     properties : propreader,
     scheduler : scheduler,
     oauth :oauth,
     git : gitter,
     querybuilder : querybuilder.querybuilder
}   

exports.caboodle = caboodle;