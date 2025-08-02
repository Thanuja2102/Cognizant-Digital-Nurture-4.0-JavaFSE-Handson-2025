import React from 'react';

const IndianPlayers = () => {
  const teamPlayers = ['Kohli', 'Rohit', 'Dhoni', 'Rahul', 'Pandya', 'Jadeja'];
  
  // Destructuring for Odd and Even team
  const oddPlayers = teamPlayers.filter((_, i) => i % 2 === 0);
  const evenPlayers = teamPlayers.filter((_, i) => i % 2 !== 0);

  // Merging two arrays using ES6 Spread
  const T20players = ['Kohli', 'Rohit', 'Rahul'];
  const RanjiTrophyPlayers = ['Pujara', 'Rahane', 'Shaw'];

  const allPlayers = [...T20players, ...RanjiTrophyPlayers];

  return (
    <div>
      <h2>Odd Team Players</h2>
      <ul>
        {oddPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>

      <h2>Even Team Players</h2>
      <ul>
        {evenPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>

      <h2>Merged Players (T20 + Ranji Trophy)</h2>
      <ul>
        {allPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;






