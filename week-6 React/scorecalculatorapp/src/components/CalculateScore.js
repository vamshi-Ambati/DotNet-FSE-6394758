import React from "react";
import "../Stylesheets/mystyle.css";

const percentToDecimal = (decimal) => {
  return (decimal * 100).toFixed(2) + "%";
};

const calcScore = (total, goal) => {
  if (goal === 0) return "N/A";
  return percentToDecimal(total / goal);
};

const CalculateScore = ({ Name, School, total, goal }) => (
  <div className="formatstyle">
    <h1>
      <font color="Brown">Student Details:</font>
    </h1>

    <div className="Name">
      <b>Name: </b>
      <span>{Name}</span>
    </div>

    <div className="School">
      <b>School: </b>
      <span>{School}</span>
    </div>

    <div className="Total">
      <b>Total: </b>
      <span>{total} Marks</span>
    </div>

    <div className="Score">
      <b>Score: </b>
      <span>{calcScore(total, goal)}</span>
    </div>
  </div>
);

export default CalculateScore;
