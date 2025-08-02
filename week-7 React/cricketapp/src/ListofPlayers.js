import React from "react";

// Using ES6 let (block-scoped variable)
let ListofPlayers = ({ players }) => {
  // Using ES6 arrow function
  const playersBelow70 = players.filter((player) => player.score < 70);

  return (
    <div>
      <h2>All Players</h2>
      {/* Using ES6 map() method */}
      <ul>
        {players.map((player, index) => (
          <li key={index}>
            {player.name}: {player.score}
          </li>
        ))}
      </ul>

      <h2>Players with Scores Below 70</h2>
      <ul>
        {playersBelow70.map((player, index) => (
          <li key={index}>
            {player.name}: {player.score}
          </li>
        ))}
      </ul>
    </div>
  );
};

// Using ES6 const (cannot be reassigned)
export default ListofPlayers;
