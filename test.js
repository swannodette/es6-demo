var mdeps = require('module-deps');
var JSONStream = require('JSONStream');

var md = mdeps();
md.pipe(JSONStream.stringify()).pipe(process.stdout);
md.end({ file: __dirname + '/src/libs/NodeStuff.js' });
