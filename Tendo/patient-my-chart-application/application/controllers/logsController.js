const controller = require('./appController');
const fs  = controller.caboodle.filesystem
const log  = controller.caboodle.log

exports.getLogFileNames = (req,res) => {
    try {
        var fileNames =[];
        var count = 0;

        const logFolder =  __dirname + '/./../../logs/';
        fs.readdirSync(logFolder).forEach(file => {
            fileNames.push(file);
           count++;
        });
        fileNames.reverse();
      res.render("logs", {layout: 'logs', logFileNames: fileNames});
    } catch (err) {
      log.warn(err);
    }
      
  }