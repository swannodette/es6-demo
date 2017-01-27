var objectAssign = require("object-assign");
var React = require("react");
var ReactDOMServer = require("react-dom/server");

function foo(a, b) {
    return a + b;
}

function createElement() {
    return ReactDOMServer.renderToString(React.createElement("div", {}, "Hello world!"));
};

module.exports = {
    foo: foo,
    createElement: createElement
};
