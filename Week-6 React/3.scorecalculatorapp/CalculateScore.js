import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore() {
  const name = "Thanuja";
  const school = "VelTech MultiTech";
  const total = 480;
  const goal = 500;

  const average = total / 5;

  return (
    <div className="score-card">
      <h2>Student Score Summary</h2>
      <p><strong>Name:</strong> {name}</p>
      <p><strong>School:</strong> {school}</p>
      <p><strong>Total Marks:</strong> {total}</p>
      <p><strong>Goal:</strong> {goal}</p>
      <p><strong>Average Score:</strong> {average}</p>
    </div>
  );
}

export default CalculateScore;


