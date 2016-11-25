import * as React from "resources/js/react.js";
goog.require("cljs.core");

export var foo = (a, b) => {
  return a + b;
};

export var bar = (c, d) => {
  return c * d;
};

export var vec = (xs) => {
  return cljs.core.into(cljs.core.vector(), xs);
};

export var Circle = class extends React.Component {
  render() {
    return(
      <svg width="200px" height="200px" className="center">
        <circle cx="100px" cy="100px" r="100px" fill={this.props.color}>
        </circle>
      </svg>
    );
  }
}
