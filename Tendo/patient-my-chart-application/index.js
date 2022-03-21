  const application = require('./application/application.js');
const app = application.app;
const PORT = 3002

app.listen(PORT, () => {
  console.log ('Application "MY CHART" is started and listensing on port 3002...')
});