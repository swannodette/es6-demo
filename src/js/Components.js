import * as React from "resources/js/react.js";
goog.require("cljs.core");

export const foo = (a, b) => {
  return a + b;
};

export const bar = (c, d) => {
  return c * d;
};

export const vec = (xs) => {
  return cljs.core.into(cljs.core.vector(), xs);
};

export class Circle extends React.Component {
  render() {
    return(
      <svg width="200px" height="200px" className="center">
        <circle cx="100px" cy="100px" r="100px" fill={this.props.color}>
        </circle>
      </svg>
    );
  }
}
