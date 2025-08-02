import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: 'Virat Kohli', score: 85 },
    { name: 'Rohit Sharma', score: 90 },
    { name: 'MS Dhoni', score: 65 },
    { name: 'KL Rahul', score: 72 },
    { name: 'Hardik Pandya', score: 68 },
    { name: 'Jadeja', score: 77 },
    { name: 'Bumrah', score: 59 },
    { name: 'Shami', score: 81 },
    { name: 'Suryakumar Yadav', score: 66 },
    { name: 'Ishan Kishan', score: 70 },
    { name: 'Gill', score: 93 },
  ];

  const filteredPlayers = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>All Players:</h2>
      <ul>
        {players.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>

      <h3>Players with score below 70:</h3>
      <ul>
        {filteredPlayers.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;


