import * as React from "resources/js/react.js";

export const foo = (a, b) => {
  return a + b;
};

export const bar = (c, d) => {
  return c * d;
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
